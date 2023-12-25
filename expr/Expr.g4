//做简单的输入语句的运算实现
grammar Expr;

//语法规则定义
//声明开始【定义stat】
prog: stat+;

stat: expr NEWLINE
    |  ID '=' expr NEWLINE
    |  NEWLINE
    ;

//先后顺序对解析成为的树有影响
//核心就是优先匹配原则
//乘除的优先级高于加减【所以优先匹配】
//并且需要注意ID作为标识符匹配，在忽略空格的情况下，ID需要放在运算符表达式的后面才能正常匹配逻辑，否则会抛出一定的异常
// （因为运算符表达式本身也容易匹配到ID上）
expr: INT
    | expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | ID
    | '(' expr ')'
    ;

//词法定义规则
ID: [a-zA-Z]+;//标识符定义
INT:[0-9]+;
NEWLINE:'\r'?'\n';
WS:[\t]+ -> skip;
