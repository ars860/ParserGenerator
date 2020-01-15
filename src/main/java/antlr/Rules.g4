grammar Rules;

@header {
import java.util.*;
import grammar.Grammar;
import grammar.Rule;
import grammar.TokenDef;
import grammar.Option;
import grammar.atom.*;
}

start returns [Grammar grammar]
    : 'grammar' TYPE ';' header skip keep rules tokens_ {Collections.reverse($tokens_.tokens); $grammar = new Grammar($TYPE.text, $header.code, $rules.rules_, $tokens_.tokens, $skip.tokens, $keep.tokenNames);}
    ;

header returns [Code code]
     : '@header' CODE {$code = new Code($CODE.text);}
     | {$code = new Code("");}
     ;

skip returns [List<TokenDef> tokens]
   : '@skip' '(' tokens_ ')' {$tokens = $tokens_.tokens;}
   | {$tokens = new ArrayList<TokenDef>();}
   ;

keep returns [Set<String> tokenNames]
   : '@keepInTree' '(' tokensList ')' {$tokenNames = $tokensList.arguments;}
   | {$tokenNames = new HashSet<>();}
   ;

tokensList returns [Set<String> arguments]
   : TOKENNAME tokensListCont {$arguments = $tokensListCont.arguments;
                               $arguments.add($TOKENNAME.text);}
   | {$arguments = new HashSet<>();}
   ;

tokensListCont returns [Set<String> arguments]
        : ',' TOKENNAME tokensListCont {$arguments = $tokensListCont.arguments;
                                        $arguments.add($TOKENNAME.text);}
        | {$arguments = new HashSet<>();}
        ;

tokens_ returns [List<TokenDef> tokens]
     : token ';' tokens_ {$tokens = $tokens_.tokens;
                          $tokens.add($token.token_);}
     | {$tokens = new ArrayList<TokenDef>();}
     ;

token returns [TokenDef token_]
    : TOKENNAME ':' REGEX {$token_ = new TokenDef($TOKENNAME.text, $REGEX.text);}
    ;

rules returns [List<Rule> rules_]
   : rule_ ';' rules {$rules_ = $rules.rules_;
                      $rules_.add($rule_.rule);}
   | {$rules_ = new ArrayList<Rule>();}
   ;

rule_ returns [Rule rule]
   : NAME ruleArgs ruleReturns ':' ruleCase ruleCases
   {$ruleCases.options.add(new Option($ruleCase.options));
    $rule = new Rule($NAME.text, $ruleArgs.arguments, $ruleReturns.ret, $ruleCases.options);
   }
   ;

ruleReturns returns [Rule.Argument ret]
          : 'returns' '[' TYPE NAME ']' {$ret = new Rule.Argument($TYPE.text, $NAME.text);}
          | {$ret = null;}
          ;

ruleArgs returns [List<Rule.Argument> arguments]
       : '[' typedArgs ']' {$arguments = $typedArgs.arguments;}
       | {$arguments = new ArrayList<Rule.Argument>();}
       ;

typedArgs returns [List<Rule.Argument> arguments]
   : TYPE NAME typedArgsList {$arguments = $typedArgsList.arguments;
                                       $arguments.add(new Rule.Argument($TYPE.text, $NAME.text));}
   | {$arguments = new ArrayList<Rule.Argument>();}
   ;

typedArgsList returns [List<Rule.Argument> arguments]
            : ',' TYPE NAME typedArgsList {$arguments = $typedArgsList.arguments;
                                                    $arguments.add(new Rule.Argument($TYPE.text, $NAME.text));}
            | {$arguments = new ArrayList<Rule.Argument>();}
            ;

ruleCases returns [List<Option> options]
        : '|' ruleCase ruleCases {$options = $ruleCases.options;
                                  $options.add(new Option($ruleCase.options));}
        | {$options = new ArrayList<Option>();}
        ;

ruleCase returns [List<Atom> options]
       : ruleCaseTerm ruleCaseTerms {$options = $ruleCaseTerms.options;
                                     $options.add($ruleCaseTerm.atom);
                                     Collections.reverse($options);}
       | {$options = new ArrayList<>();}
       ;

ruleCaseTerms returns [List<Atom> options]
            : ruleCaseTerm ruleCaseTerms {$options = $ruleCaseTerms.options;
                                          $options.add($ruleCaseTerm.atom);}
            | {$options = new ArrayList<>();}
            ;

ruleCaseTerm returns [Atom atom]
           : ruleInv {$atom = $ruleInv.res;}
           | CODE {$atom = new Code($CODE.text);}
           | tokenInv {$atom = $tokenInv.res;}
           ;

ruleInv returns [RuleInv res]
      : newName = NAME '=' ruleName = NAME '[' args ']' {$res = new RuleInv($newName.text, $ruleName.text, $args.arguments);}
      | newName = NAME '=' ruleName = NAME {$res = new RuleInv($newName.text, $ruleName.text, new ArrayList<>());}
      ;

tokenInv returns [TokenInv res]
      : newName = NAME '=' ruleName = TOKENNAME {$res = new TokenInv($newName.text, $ruleName.text);}
      ;

args returns [List<String> arguments]
   : DOTTEDNAME argsList {$arguments = $argsList.arguments;
                          $arguments.add($DOTTEDNAME.text);}
   | NAME argsList {$arguments = $argsList.arguments;
                    $arguments.add($NAME.text);}
   | {$arguments = new ArrayList<>();}
   ;

argsList returns [List<String> arguments]
        : ',' DOTTEDNAME argsList {$arguments = $argsList.arguments;
                                   $arguments.add($DOTTEDNAME.text);}
        | ',' NAME argsList {$arguments = $argsList.arguments;
                             $arguments.add($NAME.text);}
        | {$arguments = new ArrayList<>();}
        ;

INT         : [0-9]+ ;
TOKENNAME   : [A-Z][A-Z1-9_]*;
BIGLETTERNAME : [A-Z][a-zA-Z1-9_]*;
TYPE : [A-Z][a-zA-Z1-9_]*('<'TYPE*([ \t]*','[ \t]*TYPE*)*'>')?;
NAME    : [a-z][a-zA-Z1-9_]*;
DOTTEDNAME  : [a-z][a-zA-Z1-9_.]*;
WS          : ('\t' | '\n' | '\r' | ' ') -> skip;
TOKEN       : '\''~[']+'\'';
REGEX       : '"'~["]+'"';
CODE        : '{' (~[{}]+ CODE?)* '}';