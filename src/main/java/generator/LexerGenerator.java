package generator;

import grammar.Grammar;
import grammar.TokenDef;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class LexerGenerator extends Generator {
    public LexerGenerator(Grammar grammar, Path out) throws IOException {
        super(grammar, out);
    }

    private void generateEnum() throws IOException {
        writeString("enum TokenType {", 2);
        for (int i = 0; i < grammar.getTokens().size(); i++) {
            TokenDef token = grammar.getTokens().get(i);
            writeString(token.getName() + ",", 3);
        }
        for (int i = 0; i < grammar.getSkipTokens().size(); i++) {
            TokenDef token = grammar.getSkipTokens().get(i);
            writeString(token.getName() + ",", 3);
        }
        writeString(grammar.getEOF(), 3);
        writeString("}", 2);
    }

    public void generateLexer() throws IOException {
        generateImports("java.util.regex.Pattern",
                "java.util.regex.Matcher");
        writeString("public class " + getName() + "Lexer {", 0);
        generateEnum();
        writeln();
        generateException();
        writeln();
        writeStrings(1,
                "private String input;",
                "",
                "public String getInput() {",
                "    return new String(input);",
                "}",
                "",
                getName() + "Lexer(String input){",
                "    this.input = input;",
                "}");
        writeln();
        writeStrings(1,
                "static class TokenPattern {",
                "    final private TokenType tokenName;",
                "    final private Pattern pattern;",
                "",
                "    TokenPattern(TokenType tokenName, String pattern){",
                "        this.tokenName = tokenName;",
                "        this.pattern = Pattern.compile(pattern);",
                "    }",
                "}");
        writeln();
        writeStrings(1,
                "static class Token {",
                "    final private TokenType name;",
                "    final private String text;",
                "",
                "    Token(TokenType name, String text) {",
                "        this.name = name;",
                "        this.text = text;",
                "    }",
                "",
                "    Token(Token other) {",
                "        this.name = other.name;",
                "        this.text = other.text;",
                "    }",
                "",
                "    public TokenType getName() {",
                "        return name;",
                "    }",
                "",
                "    public String getText() {",
                "        return text;",
                "    }",
                "}");
        writeln();
        generateMatchersFromTokens();
        writeln();
        generateNext();
        writeString("}", 0);
        writer.close();
    }

    private void generateException() throws IOException {
        writeStrings(1,
                "static class " + getName() + "LexerException extends Exception {",
                "    " + getName() + "LexerException(String message) {",
                "        super(message);",
                "    }",
                "}");
    }

    private void generateMatchersFromTokens() throws IOException {
        List<TokenDef> tokens = grammar.getTokens();
        List<TokenDef> skipTokens = grammar.getSkipTokens();

        writeString("private TokenPattern[] tokenPatterns = {", 1);

        generateTokens(tokens);
        writeln();
        writeString("private TokenPattern[] skipPatterns = {", 1);

        generateTokens(skipTokens);
    }

    private void generateTokens(List<TokenDef> tokens) throws IOException {
        for (int i = 0; i < tokens.size(); i++) {
            TokenDef token = tokens.get(i);
            writeString("new TokenPattern(TokenType." + token.getName() + ", \"^" + token.getRegex().substring(1) + ")" + (i == tokens.size() - 1 ? "" : ", "), 2);
        }

        writeString("};", 1);
    }

    private void generateNext() throws IOException {
        writeString("public Token nextToken() throws " + getName() + "LexerException {", 1);
        writeStrings(2,
                "for (final TokenPattern pattern : skipPatterns) {",
                "    Matcher matcher = pattern.pattern.matcher(input);",
                "    if (matcher.find()) {",
                "        input = input.substring(matcher.group(0).length());",
                "    }",
                "}",
                "for (final TokenPattern pattern : tokenPatterns) {",
                "    Matcher matcher = pattern.pattern.matcher(input);",
                "    if (matcher.find()) {",
                "        input = input.substring(matcher.group(0).length());",
                "        return new Token(pattern.tokenName, matcher.group(0));",
                "    }",
                "}",
                "if (input.length() == 0) {",
                "    return new Token(TokenType." + grammar.getEOF() + ", \"\");",
                "}",
                "throw new " + getName() + "LexerException (\"Can't parse token at: ...\" + input.substring(0, Math.min(10, input.length())) + (input.length() > 10 ? \"...\" : \"\"));");
        writeString("}", 1);
    }
}
