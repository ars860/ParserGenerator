grammar Expr;

@header {
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
}

start
    : string[new HashMap<String, Integer>()]
    ;

string[Map<String, Integer> curVars]
     : VAR '=' expr[curVars] ';' {curVars.put($VAR.text, $expr.value); System.out.println($VAR.text + " = " + $expr.value);} string[curVars]
     | <EOF>
     ;

expr[Map<String, Integer> variables] returns [int value]
   : term[variables] exprr[$term.value, variables]                              {$value = $exprr.value;}
   ;

exprr[int prev, Map<String, Integer> variables] returns [int value]
    : '+' term[variables] exprr1 = exprr[$prev + $term.value, variables]        {$value = $exprr1.value;}
    | '-' term[variables] exprr1 = exprr[$prev - $term.value, variables]        {$value = $exprr1.value;}
    |                                                                           {$value = $prev;}
    ;

term[Map<String, Integer> variables] returns [int value]
   : fact[variables] termm[$fact.value, variables]                              {$value = $termm.value;}
   ;

termm[int prev, Map<String, Integer> variables] returns [int value]
    : '*' fact[variables] termm1 = termm[$prev * $fact.value, variables]        {$value = $termm1.value;}
    | '/' fact[variables] termm1 = termm[$prev / $fact.value, variables]        {$value = $termm1.value;}
    |                                                                           {$value = $prev;}
    ;

fact[Map<String, Integer> variables] returns [int value]
   : INT                                                                        {$value = Integer.parseInt($INT.text);}
   | VAR                                                                        {$value = variables.get($VAR.text);}
   | '(' expr[variables] ')'                                                    {$value = $expr.value;}
   ;

INT     : [0-9]+ ;
VAR     : [a-zA-Z_]+;
WS      : ('\t' | '\n' | '\r' | ' ') -> skip;