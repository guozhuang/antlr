/**
首个考虑实际使用的demo
*/
grammar ArrayInit;

//匹配{value}或{value, value}规则
init : '{' value (',' value)* '}';

//value内可以时init的嵌套，也可以是单独的值
value : init
        | INT
        ;

INT : [0-9]+;//单值格式是int
WS  : [\t\r\n]+ -> skip;//跳过换行等制表符号