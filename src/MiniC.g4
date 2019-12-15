grammar MiniC;

@header { 
package generated;
}
program : decl+         ;
decl        : var_decl
      | fun_decl      ;
var_decl   :  type_spec IDENT ';'
         | type_spec IDENT '=' CHAR_SET ';'
         | type_spec IDENT '=' LITERAL ';'
         | type_spec IDENT '[' LITERAL ']' ';'   ;
type_spec   : VOID
        | DOUBLE
        | FLOAT
        | INT
        | CHAR;
fun_decl   : type_spec IDENT '(' params ')' compound_stmt ;
params      : param (',' param)*
      | VOID
      |           ;
param       : type_spec IDENT
      | type_spec IDENT '[' ']'   ;
stmt    : expr_stmt
      | compound_stmt
      | if_stmt
      | while_stmt
      | return_stmt
      | for_stmt;
expr_stmt   : expr ';'      ;
while_stmt   : WHILE '(' expr ')' stmt   ;
compound_stmt: '{' local_decl* stmt* '}'   ;
local_decl   : type_spec IDENT ';'
      | type_spec IDENT '=' CHAR_SET ';'
      | type_spec IDENT '=' LITERAL ';'
      | type_spec IDENT '[' LITERAL ']' ';'     ;
if_stmt     : IF '(' expr ')' stmt
      | IF '(' expr ')' stmt ELSE stmt       ;
return_stmt : RETURN ';'
      | RETURN expr ';'           ;
for_stmt : FOR '(' for_condition ')' compound_stmt       ;
for_condition: expr ';' expr ';' expr
       | ';' expr ';' expr
       | ';' expr ';'
       | expr ';' expr ';';
expr    :  LITERAL
   | '(' expr ')'
   | FLOAT_IDENT
   | CHAR_SET
   | IDENT
   | IDENT '[' expr ']'
   | IDENT '(' args ')'
   | '-' expr
   | '+' expr
   | '--' expr
   | '++' expr
   | expr '*' expr
   | expr '/' expr
   | expr '%' expr
   | expr '+' expr
   | expr '-' expr
   | expr EQ expr
   | expr NE expr
   | expr LE expr
   | expr '<' expr
   | expr GE expr
   | expr '>' expr
   | '!' expr
   | expr AND expr
   | expr OR expr
   | IDENT '=' expr
   | IDENT '[' expr ']' '=' expr;

args   : expr (',' expr)*
   |                    ;


VOID: 'void';
INT: 'int';
CHAR : 'char';
DOUBLE: 'double';
FLOAT: 'float';

WHILE: 'while';
IF: 'if';
ELSE: 'else';
RETURN: 'return';
FOR: 'for';
OR: 'or';
AND: 'and';
LE: '<=';
GE: '>=';
EQ: '==';
NE: '!=';

IDENT  : [a-zA-Z_]
        (   [a-zA-Z_]
        |  [0-9]
        )*;


CHAR_SET
   : '\'' AlPHA_CHAR '\''
   | '\'' '0' .. '9' '\''
   | '\'' '\u00B7' '\''
   | '\'' '\u0300' .. '\u036F' '\''
   | '\'' '\u203F' .. '\u2040' '\''
   ;

AlPHA_CHAR
   : 'A' .. 'Z'
   | 'a' .. 'z'
   | '\u00C0' .. '\u00D6'
   | '\u00D8' .. '\u00F6'
   | '\u00F8' .. '\u02FF'
   | '\u0370' .. '\u037D'
   | '\u037F' .. '\u1FFF'
   | '\u200C' .. '\u200D'
   | '\u2070' .. '\u218F'
   | '\u2C00' .. '\u2FEF'
   | '\u3001' .. '\uD7FF'
   | '\uF900' .. '\uFDCF'
   | '\uFDF0' .. '\uFFFD'
   ;


FLOAT_IDENT : DecimalConstant'.'[0-9]+ ;

LITERAL:   DecimalConstant     |   OctalConstant     |   HexadecimalConstant    | FLOAT_IDENT ;

DecimalConstant
    :   '0'
   |   [1-9] [0-9]*
    ;

OctalConstant
    :   '0'[0-7]*
    ;

HexadecimalConstant
    :   '0' [xX] [0-9a-fA-F] +
    ;

WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\n'
        )+
   -> channel(HIDDEN)
    ;