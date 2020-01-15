import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class CaclulatorLexer {
        enum TokenType {
            NUMBER,
            PLUS,
            MINUS,
            MULT,
            DIV,
            POW,
            LP,
            RP,
            WS,
            EOF
        }

    static class CaclulatorLexerException extends Exception {
        CaclulatorLexerException(String message) {
            super(message);
        }
    }

    private String input;
    
    public String getInput() {
        return new String(input);
    }
    
    CaclulatorLexer(String input){
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
        new TokenPattern(TokenType.NUMBER, "^[1-9][0-9]*"), 
        new TokenPattern(TokenType.PLUS, "^[+]"), 
        new TokenPattern(TokenType.MINUS, "^[-]"), 
        new TokenPattern(TokenType.MULT, "^[*]"), 
        new TokenPattern(TokenType.DIV, "^[/]"), 
        new TokenPattern(TokenType.POW, "^[\\^]"), 
        new TokenPattern(TokenType.LP, "^[(]"), 
        new TokenPattern(TokenType.RP, "^[)]")
    };

    private TokenPattern[] skipPatterns = {
        new TokenPattern(TokenType.WS, "^[ \t\n\r]+")
    };

    public Token nextToken() throws CaclulatorLexerException {
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
        throw new CaclulatorLexerException ("Can't parse token at: ..." + input.substring(0, Math.min(10, input.length())) + (input.length() > 10 ? "..." : ""));
    }
}
