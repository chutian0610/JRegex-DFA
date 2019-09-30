package info.victor.jregex.grammar;

public class ConcatenationRegexNode extends RegexNode {
    private RegexNode left;
    private RegexNode right;

    public ConcatenationRegexNode(RegexNode left, RegexNode right) {
        this.left = left;
        this.right = right;
    }
}