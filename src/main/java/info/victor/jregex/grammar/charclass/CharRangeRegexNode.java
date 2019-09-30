package info.victor.jregex.grammar.charclass;

import info.victor.jregex.grammar.CharClassRegexNode;

public class CharRangeRegexNode extends CharClassRegexNode {
    private Character from;
    private Character to;

    public CharRangeRegexNode(Character from, Character to) {
        this.from = from;
        this.to = to;
    }
}
