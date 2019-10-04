package info.victor.jregex.parser;

public class Pattern {

    public static Pattern compile(String regex) {
        return new Pattern(regex);
    }


    public Pattern(String regex) {
        this.regex = regex;
    }

    /**
     *  正则字符串
     */
    private String regex;

    public static void main(String[] args) {
        String test = "\n";
        System.out.println(test.length());
    }
}
