# ebnf

这是正则表达式目前支持的语法:

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
      | simpleExp
      ;

bracketExp = '^'? characterSets;

characterSets =  characterSet
                | characterSet characterSets
                ;

characterSet  = specialSet
                | characterExp
                | characterExp - characterExp
                ;

characterExp =  character      { 非转义字符 }
             |  '\' character  { 转义字符 }
             ;
             
specialSet  = \d { 数字,[0-9] }
            | \D { 非数字,[^0-9] }
            | \w { 单词,[a-zA-Z0-9_] }
            | \W { 非单词,[^a-zA-Z0-9_] }
            ;
           
simpleExp = specialChar
          | specialSet
          | characterExp
          ;
specialChar = . { any char except \n }
            ;
``` 

## 参考资料

1. [stackoverflow](https://stackoverflow.com/questions/265457/regex-grammar)
2. [POSIX字符组](https://zh.wikipedia.org/wiki/正则表达式#POSIX字符组)