package generator;

import grammar.Grammar;
import grammar.GrammarException;
import grammar.Option;
import grammar.Rule;
import grammar.atom.Atom;
import grammar.atom.Code;
import grammar.atom.RuleInv;
import grammar.atom.TokenInv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator extends Generator {
    public ParserGenerator(Grammar grammar, Path out) throws IOException {
        super(grammar, out);
    }

    private void generateNode() throws IOException {
        writeStrings(1,
                "public interface Node {",
                "    String show(int indent);",
                "}",
                "",
                "private static class NodeRule implements Node {",
                "    private String name;",
                "    private List<Node> children;",
                "",
                "    NodeRule(String name, Node... children) {",
                "        this.name = name;",
                "        this.children = Arrays.asList(children);",
                "    }",
                "",
                "    @Override",
                "    public String show(int indent) {",
                "       StringBuilder res = new StringBuilder(\"*  \".repeat(Math.max(0, indent)) + name + \"\\n\");",
                "        for (final Node node : children) {",
                "            res.append(node.show(indent + 1));",
                "        }",
                "        return res.toString();",
                "    }",
                "}",
                "",
                "private static class NodeToken implements Node {",
                "    private " + getName() + "Lexer.Token token;",
                "",
                "    public NodeToken(" + getName() + "Lexer.Token token) {",
                "        this.token = token;",
                "    }",
                "",
                "    @Override",
                "    public String show(int indent) {",
                "        return \"*  \".repeat(Math.max(0, indent)) + \"(\"  + token.getName() + \" : \" + token.getText() + \")\" + \"\\n\";",
                "    }",
                "}"
        );
    }

    private void generateException() throws IOException {
        writeStrings(1,
                "static class " + getName() + "ParserException extends Exception {",
                "    " + getName() + "ParserException(String message) {",
                "        super(message);",
                "    }",
                "",
                "    " + getName() + "ParserException(String message, Throwable cause) {",
                "        super(message, cause);",
                "    }",
                "}");
    }

    private void generateConsume() throws IOException {
        String lexerName = getName() + "Lexer";
        writeStrings(1,
                "private " + lexerName + " lexer;",
                "private " + lexerName + ".Token curToken;",
                "",
                "private " + lexerName + ".Token nextToken() throws " + getName() + "ParserException {",
                "    try {",
                "        curToken = lexer.nextToken();",
                "    } catch (" + getName() + "Lexer." + getName() + "LexerException e) {",
                "        throw new " + getName() + "ParserException(\"Can't parse token\", e);",
                "    }",
                "    return curToken;",
                "}",
                "",
                "private void consume(" + getName() + "Lexer.TokenType expectedTokenName) throws " + getName() + "ParserException {",
                "    if(curToken.getName() != expectedTokenName) {",
                "        throw new " + getName() + "ParserException(\"Expected: \" + expectedTokenName + \" got: \" + curToken.getName());",
                "    }",
                "    nextToken();",
                "}");
    }

    private void generateConstructor() throws IOException {
        writeStrings(1,
                getName() + "Parser(" + getName() + "Lexer lexer) throws " + getName() + "ParserException {",
                "    this.lexer = lexer;",
                "    nextToken();",
                "}");
    }

    public void generateParser() throws IOException, GrammarException {
        writeString(grammar.getHeader().prettify(), 0);
        generateImports(
                "java.util.Arrays",
                "java.util.List");
        writeString("public class " + getName() + "Parser {", 0);
        generateNode();
        writeln();
        generateException();
        writeln();
        generateConsume();
        writeln();
        generateConstructor();
        writeln();
        for (final Rule rule : grammar.getRules()) {
            generateRule(rule);
            writeln();
        }
        writeString("}", 0);
        writer.close();
    }

    public void generateRule(Rule rule) throws IOException, GrammarException {
        Rule.Argument returns = rule.getReturns();

        //  Context
        if (returns != null) {
            writeStrings(1,
                    "static class " + rule.getName() + "Context {",
                    "    private " + returns.getType() + " " + returns.getName() + ";",
                    "    private Node node;",
                    "",
                    "    " + rule.getName() + "Context(" + returns.getType() + " returns, Node node) {",
                    "        this.node = node;",
                    "        this." + returns.getName() + " = returns;",
                    "    }",
                    "",
                    "    public " + returns.getType() + " get" + returns.getName() + "() {",
                    "        return " + returns.getName() + ";",
                    "    }",
                    "",
                    "    public Node getNode() {",
                    "        return node;",
                    "    }",
                    "}");
        } else {
            writeStrings(1,
                    "static class " + rule.getName() + "Context {",
                    "    private Node node;",
                    "",
                    "    " + rule.getName() + "Context(Node node) {",
                    "        this.node = node;",
                    "    }",
                    "",
                    "    public Node getNode() {",
                    "        return node;",
                    "    }",
                    "}");
        }
        writeln();

        writeString(
                "public " + rule.getName() + "Context " + rule.getName() + "(" +
                        rule.getArguments().stream().map((argument) -> argument.getType() + " " + argument.getName()).collect(Collectors.joining(",")) + ") throws " + getName() + "ParserException {",
                1);

        if (returns != null) {
            writeString(returns.getType() + " " + returns.getName() + ";", 2);
        }

        List<Option> options = rule.getOptions();
        List<Set<String>> optionsFirsts = new ArrayList<>();
        for (final Option option : options) {
            optionsFirsts.add(grammar.calcFirstForOption(option));
        }

        if (new HashSet<>(optionsFirsts).size() != optionsFirsts.size()) {
            throw new GrammarException("Grammar is not LL1, because Rule: " + rule.getName() + " has options with equal firsts.");
        }

        writeStrings(2,
                "switch (curToken.getName()) {");

        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            Set<String> first = optionsFirsts.get(i);

            if (first.contains(grammar.getEPSILON())) {
                first.remove(grammar.getEPSILON());
                for (final String tokenName : grammar.getFollow().get(rule.getName())) {
                    writeString("case " + tokenName + ":", 3);
                }
            }

            for (final String tokenName : first) {
                writeString("case " + tokenName + ":", 3);
            }

            writeString("{", 3);

            List<String> returnList = new ArrayList<>();

            for (final Atom atom : option.getAtoms()) {
                switch (atom.getType()) {
                    case CODE:
                        writeString(((Code) atom).prettify(), 4);
                        break;
                    case TOKEN: {
                        TokenInv tokenInv = (TokenInv) atom;
                        if (grammar.getKeepInTree().contains(tokenInv.getName())) {
                            returnList.add("new NodeToken(" + tokenInv.getNewName() + ")");
                        }
                        writeString(getName() + "Lexer.Token " + tokenInv.getNewName() + " = new " + getName() + "Lexer.Token(curToken);", 4);
                        writeString("consume(" + getName() + "Lexer.TokenType." + tokenInv.getName() + ");", 4);
                        break;
                    }
                    case RULE: {
                        RuleInv ruleInv = (RuleInv) atom;
                        returnList.add(ruleInv.getNewName() + ".node");
                        writeString(ruleInv.getRuleName() + "Context " + ruleInv.getNewName() + " = " + ruleInv.getRuleName() + "(" + String.join(", ", ruleInv.getArguments()) + ");", 4);
                        break;
                    }
                }
            }

            String returnString = String.join(", ", returnList);
            if (returns != null) {
                writeString("return new " + rule.getName() + "Context(" + returns.getName() + ", new NodeRule(\"" + rule.getName() + "\"" + (returnString.length() > 0 ? ", " : "") + returnString + "));", 4);
            } else {
                writeString("return new " + rule.getName() + "Context( new NodeRule(\"" + rule.getName() + "\"" + (returnString.length() > 0 ? ", " : "") + returnString + "));", 4);
            }
            writeString("}", 3);
        }

        writeStrings(3,
                "default:",
                "    throw new " + getName() + "ParserException(\"Expected: " + String.join(" or ", grammar.getFirst().get(rule.getName())) + ", got: \" + curToken.getName().name() + \", at: ...\" + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? \"...\" : \"\"));");

        writeString("}", 2);
        writeString("}", 1);
    }
}
