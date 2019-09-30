# ebnf

```ebnf
union   = concat
        | concat | union
        ;
concat  = repeat
        | repeat concatexp
        ;
repeat  = basic '?' (zero or one occurrence) 
        | basic '*' (zero or more occurrences) 
        | basic '*?' {zero or more, non-greedy}
        | basic '+' (one or more occurrences) 
        | basic '+?' {one or more, non-greedy}
        | basic '{n}' (n occurrences) 
        | basic '{n,}' (n or more occurrences) 
        | basic '{n,m}' (n to m occurrences, including both) 
        | basic
        ;
basic   = atom
        | ( union )
        ;
        
atom  = '[' bracketExp ']'
      | characterExp
      ;

bracketExp = '^'? characterclass;

characterclass =  characterrange
                | characterrange characterclass
                ;

characterrange  = character
                | character - character
                ;

characterExp =  metacharacter
             |  '\' metacharacter {metacharacters which length =1 }
             |  any character not in metacharacter
             ;

metacharacter = ? {=0 or 1, greedy}
              | * {=0 or more, greedy}
              | + {=1 or more, greedy}
              | ^ {=begin of line character}
              | $ {=end of line character}
              | $` {=the characters to the left of the match}
              | $' {=the characters to the right of the match}
              | $& {=the characters that are matched}
              | \t {=tab character}
              | \n {=newline character}
              | \r {=carriage return character}
              | \f {=form feed character}
              | \cX {=control character CTRL-X}
              | \N {=the characters in Nth tag (if on match side)}
              | $N{=the characters in Nth tag (if not on match side)}
              | \NNN {=octal code for character NNN}
              | \b {=match a 'word' boundary}
              | \B {=match not a 'word' boundary}
              | \d {=a digit, [0-9]}
              | \D {=not a digit, [^0-9]}
              | \s {=whitespace, [ \t\n\r\f]}
              | \S {=not a whitespace, [^ \t\n\r\f]}
              | \w {='word' character, [a-zA-Z0-9_]}
              | \W {=not a 'word' character, [^a-zA-Z0-9_]}
              | \Q {=put a quote (de-meta) on characters, until \E}
              | \U {=change characters to uppercase, until \E}
              | \L {=change characters to uppercase, until \E}
              ;
``` 

## 参考资料

1. [stackoverflow](https://stackoverflow.com/questions/265457/regex-grammar)
2. [POSIX字符组](https://zh.wikipedia.org/wiki/正则表达式#POSIX字符组)