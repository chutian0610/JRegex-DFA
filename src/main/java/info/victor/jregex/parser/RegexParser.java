package info.victor.jregex.parser;

import info.victor.jregex.grammar.*;
import info.victor.jregex.grammar.charclass.AnyCharNotNewLine;
import info.victor.jregex.grammar.charclass.CharRangeRegexNode;
import info.victor.jregex.grammar.CharRegexNode;

public class RegexParser {
    /**
     * 正则字符串
     */
    private String regex;
    /**
     * 当前字符指针位置
     */
    int position;

    public RegexParser(String regex) {
        this.regex = regex;

    }

    // ++++++++++++++++++++++++++++ static ++++++++++++++++++++++++++++++

    /**
     * 构造 “分支” 语法节点
     * @param exp1
     * @param exp2
     * @return
     */
    static RegexNode onUnion(RegexNode exp1, RegexNode exp2) {
        return new UnionRegexNode(exp1,exp2);
    }

    /**
     * 构造 “连接” 语法节点
     * @param exp1
     * @param exp2
     * @return
     */
    static RegexNode onConcatenation(RegexNode exp1, RegexNode exp2) {
        return new ConcatenationRegexNode(exp1,exp2);
    }

    /**
     * 构造 “重复” 语法节点
     * @param exp
     * @param min 至少 min 次重复
     * @param greedy 是否贪婪
     * @return
     */
    static RegexNode onRepeatMinly(RegexNode exp,int min,boolean greedy){
        return new RepeatRegexNode(min,-1,exp,greedy);
    }

    /**
     * 构造 “重复” 语法节点，min <= max
     * @param exp
     * @param min 至少 min 次重复
     * @param max 至多 max 次重复
     * @param greedy 是否贪婪
     * @return
     */
    static RegexNode onRepeat(RegexNode exp,int min,int max,boolean greedy) {
        return new RepeatRegexNode(min,max,exp,greedy);
    }

    /**
     * 构造 字符组 a-z 0-9
     * @param from
     * @param to
     * @return
     */
    static RegexNode onCharRange(char from, char to) {
        return new CharRangeRegexNode(from,to);
    }

    /**
     * 构造 字符
     * @param c
     * @return
     */
    static RegexNode onChar(char c) {
        return new CharRegexNode(c);
    }

    /**
     * 构造 补集
     * @param exp
     * @return
     */
    static RegexNode onComplement(RegexNode exp) {
        return new ComplementRegexNode(exp);
    }

    /**
     * 构造 "." ,匹配除 "\n"外所有字符
     * @return
     */
    static RegexNode onAnyCharNotNewLine() {
        return new AnyCharNotNewLine();
    }
    static RegexNode onCharSets(RegexNode... regexNodes) {
        return new CharClassesRegexNode(regexNodes);
    }

    // ++++++++++++++++++++++++++++ parser functions ++++++++++++++++++++++++

    /**
     * 语法产生式 union
     * @return
     */
    final RegexNode parseUnionExp() {
        RegexNode node = parseConcatExp();
        if (more() && match('|')){
            node = onUnion(node,parseUnionExp());
        }
        return node;
    }

    /**
     * 语法产生式 concat
     * @return
     */
    final RegexNode parseConcatExp() {
        RegexNode node = parseRepeatExp();
        if (more() && !peek(")|")){
            node = onConcatenation(node,parseConcatExp());
        }
        return node;
    }

    /**
     * 语法产生式 repeat
     * @return
     */
    final RegexNode parseRepeatExp() {
        RegexNode node = parseBasicExp();
        while (peek("?*+{")) {
            if (match('?')) {
                node = onRepeat(node, 0, 1, true);
            }
            else if (match('*')) {
                if(match('?')){
                    node = onRepeatMinly(node, 0,false);
                }else {
                    node = onRepeatMinly(node, 0,true);
                }
            }
            else if (match('+')) {
                if(match('?')) {
                    node = onRepeatMinly(node, 1,false);
                }else {
                    node = onRepeatMinly(node, 1,true);
                }
            }
            else if (match('{')) {
                int start = position;
                while (peek("0123456789")) {
                    next();
                }
                if (start == position) {
                    throw new IllegalArgumentException("integer expected at position " + position);
                }
                int min = Integer.parseInt(regex.substring(start, position));
                int max = -1;
                if (match(',')) {
                    start = position;
                    while (peek("0123456789")) {
                        next();
                    }
                    if (start != position)
                        max = Integer.parseInt(regex.substring(start, position));
                } else {
                    max = min;
                }
                if (!match('}'))
                    throw new IllegalArgumentException("expected '}' at position " + position);
                if (max == -1) {
                    node = onRepeatMinly(node, min,true);
                }
                else {
                    node = onRepeat(node, min, max,true);
                }
            }
        }
        return node;
    }

    /**
     * 语法产生式 basic，表示组或字符
     * @return
     */
    final RegexNode parseBasicExp(){
        if(match('(')){
            if (match(')')) {
                throw new IllegalArgumentException("expected regex expression before ')' at position " + position);
            }
            RegexNode e = parseUnionExp();
            if (!match(')'))
                throw new IllegalArgumentException("expected ')' at position " + position);
            return e;
        }else {
            return parseAtomExp();
        }
    }
    /**
     * 语法产生式 atom, 代表一个字符的所有可能描述
     * @return
     */
    final RegexNode parseAtomExp() {
        if (match('[')) {
            RegexNode e = parseBracketExp();
            if (!match(']')) {
                throw new IllegalArgumentException("expected ']' at position " + position);
            }
            return e;
        } else {
            return parseSimpleExp();
        }
    }

    /**
     * 处理中括号表达式
     * @return
     */
    final RegexNode parseBracketExp(){
        boolean negate = false;
        if (match('^')) {
            negate = true;
        }
        RegexNode e = parseCharacterSets();
        if (negate) {
            e = onComplement(e);
        }
        return e;
    }

    final RegexNode parseSimpleExp(){
        ////todo
        //============ special Char   =============

        //===========================================

        //============ special Char Set =============

        //===========================================
        return parseCharExp();
    }

    /**
     * 处理语法: 字符类
     * @return
     */
    final RegexNode parseCharacterSets() {
        RegexNode e = parseCharacterSet();
        while (more() && !peek("]")) {
            e = onCharSets(e, parseCharacterSets());
        }
        return e;
    }

    /**
     * 处理字符类语法
     * @return
     */
    final RegexNode parseCharacterSet() {
        ////todo
        //============ special Char Set =============

        //===========================================
        RegexNode c = parseCharExp();
        if (match('-')) {
            if (peek("]")) {
                return onCharSets(c, onChar('-'));
            }
            else {
                return onCharRange(((CharRegexNode)c).getCharacter(), ((CharRegexNode)parseCharExp()).getCharacter());
            }
        }
        else {
            return c;
        }
    }

    /**
     * 处理 普通字符，和转义字符
     * @return
     */
    final RegexNode parseCharExp() {
        // 转义字符或是普通字符,只取需要处理的部分
        match('\\');
        return onChar(next());
    }

    // +++++++++++++++++++++++++++ char reader function ++++++++++++++++++++++++++++
    /**
     * 判断此时的字符是否满足条件,若满足，指针前进
     * @param c
     * @return
     */
    private boolean match(char c) {
        if (position >= regex.length())
            return false;
        if (regex.charAt(position) == c) {
            position++;
            return true;
        }
        return false;
    }

    /**
     * whether next chars match string .
     * @param str
     * @return
     */
    private boolean matches(String str){
        boolean flag = true;
        for (int i=0;i<str.length();i++) {
            if (position + i >= regex.length()) {
                flag = false;
                break; // not match
            }
            if (str.charAt(i) != regex.charAt(position + i)) {
                flag = false;
                break; // not match
            }
        }
        if(flag){
            position = position + str.length();
        }
        return true;
    }

    /**
     * 仍有未处理的字符
     * @return
     */
    private boolean more() {
        return position < regex.length();
    }

    /**
     * 判断此时的字符是否在参数中，指针不变
     * @param s
     * @return
     */
    private boolean peek(String s) {
        return more() && s.indexOf(regex.charAt(position)) != -1;
    }

    /**
     * 获取下一个字符，如果到达EOF，抛出异常 IllegalArgumentException
     * @return
     * @throws IllegalArgumentException
     */
    private char next() throws IllegalArgumentException {
        if (!more())
            throw new IllegalArgumentException("unexpected end-of-string");
        return regex.charAt(position++);
    }

}
