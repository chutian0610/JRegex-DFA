package info.victor.jregex.grammar;

public class RepeatRegexNode extends RegexNode{

    /** exp     min   max
     *  ?        0     1
     *  +        1     -1 (without ending)
     *  *        0     -1 (without ending)
     *  {n}      n     n
     *  {n,m}    n     m
     *  {n,}     n     -1 (without ending)
     */
    private int min;
    private int max;
    private RegexNode inner;
    private boolean greedy;

    public RepeatRegexNode(int min, int max, RegexNode inner,boolean greedy) {
        this.min = min;
        this.max = max;
        this.inner = inner;
        this.greedy = greedy;
    }
}
