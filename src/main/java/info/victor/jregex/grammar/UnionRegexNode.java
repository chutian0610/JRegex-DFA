package info.victor.jregex.grammar;

public class UnionRegexNode extends RegexNode {
    private RegexNode left;
    private RegexNode right;

    public UnionRegexNode(RegexNode left, RegexNode right) {
        this.left = left;
        this.right = right;
    }
}
