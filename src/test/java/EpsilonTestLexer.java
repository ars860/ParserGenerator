import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class EpsilonTestLexer {
        enum TokenType {
            X,
            Y,
            Z,
            WS,
            EOF
        }

    static class EpsilonTestLexerException extends Exception {
        EpsilonTestLexerException(String message) {
            super(message);
        }
    }

    private String input;
    
    public String getInput() {
        return new String(input);
    }
    
    EpsilonTestLexer(String input){
        this.input = input;
    }

    static class TokenPattern {
        final private TokenType tokenName;
        final private Pattern pattern;
    
        TokenPattern(TokenType tokenName, String pattern){
            this.tokenName = tokenName;
            this.pattern = Pattern.compile(pattern);
        }
    }

    static class Token {
        final private TokenType name;
        final private String text;
    
        Token(TokenType name, String text) {
            this.name = name;
            this.text = text;
        }
    
        Token(Token other) {
            this.name = other.name;
            this.text = other.text;
        }
    
        public TokenType getName() {
            return name;
        }
    
        public String getText() {
            return text;
        }
    }

    private TokenPattern[] tokenPatterns = {
        new TokenPattern(TokenType.X, "^x"), 
        new TokenPattern(TokenType.Y, "^y"), 
        new TokenPattern(TokenType.Z, "^z")
    };

    private TokenPattern[] skipPatterns = {
        new TokenPattern(TokenType.WS, "^[ \t\n\r]+")
    };

    public Token nextToken() throws EpsilonTestLexerException {
        for (final TokenPattern pattern : skipPatterns) {
            Matcher matcher = pattern.pattern.matcher(input);
            if (matcher.find()) {
                input = input.substring(matcher.group(0).length());
            }
        }
        for (final TokenPattern pattern : tokenPatterns) {
            Matcher matcher = pattern.pattern.matcher(input);
            if (matcher.find()) {
                input = input.substring(matcher.group(0).length());
                return new Token(pattern.tokenName, matcher.group(0));
            }
        }
        if (input.length() == 0) {
            return new Token(TokenType.EOF, "");
        }
        throw new EpsilonTestLexerException ("Can't parse token at: ..." + input.substring(0, Math.min(10, input.length())) + (input.length() > 10 ? "..." : ""));
    }
}
