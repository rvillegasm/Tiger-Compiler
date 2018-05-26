package co.edu.eafit.dis.st0270.s20181.rafacort;

import java_cup.runtime.Symbol;

%%
%cup
%class TigerLexer
%line
%column

number = 0 | [1-9][0-9]*
whitespace = [ \t]
eol = \n\r|\r\n|\r|\n
string = [""]
comment = "/*" [^*] ~"*/"
identifier = [:jletter:][:jletterdigit:]
typeid = [:jletter:][:jletterdigit:]

%%
/* keyword */
<YYINITIAL> 
