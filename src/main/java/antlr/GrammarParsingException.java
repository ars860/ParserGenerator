package antlr;

public class GrammarParsingException extends Exception {
    public GrammarParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GrammarParsingException(String message) {
        super(message);
    }
}
