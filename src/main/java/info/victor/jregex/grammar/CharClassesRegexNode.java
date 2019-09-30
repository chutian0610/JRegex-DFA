package info.victor.jregex.grammar;

import java.util.Arrays;
import java.util.List;

public class CharClassesRegexNode extends RegexNode{
    private List<RegexNode> charClassRegexNodeList;

    public CharClassesRegexNode(RegexNode... charClassRegexNodeList) {
        this.charClassRegexNodeList = Arrays.asList(charClassRegexNodeList);
    }
}
