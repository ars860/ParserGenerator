
import java.util.Arrays;
import java.util.List;


public class PascalVarParser {
    public interface Node {
        String show(int indent);
    }
    
    private static class NodeRule implements Node {
        private String name;
        private List<Node> children;
    
        NodeRule(String name, Node... children) {
            this.name = name;
            this.children = Arrays.asList(children);
        }
    
        @Override
        public String show(int indent) {
           StringBuilder res = new StringBuilder("*  ".repeat(Math.max(0, indent)) + name + "\n");
            for (final Node node : children) {
                res.append(node.show(indent + 1));
            }
            return res.toString();
        }
    }
    
    private static class NodeToken implements Node {
        private PascalVarLexer.Token token;
    
        public NodeToken(PascalVarLexer.Token token) {
            this.token = token;
        }
    
        @Override
        public String show(int indent) {
            return "*  ".repeat(Math.max(0, indent)) + "("  + token.getName() + " : " + token.getText() + ")" + "\n";
        }
    }

    static class PascalVarParserException extends Exception {
        PascalVarParserException(String message) {
            super(message);
        }
    
        PascalVarParserException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private PascalVarLexer lexer;
    private PascalVarLexer.Token curToken;
    
    private PascalVarLexer.Token nextToken() throws PascalVarParserException {
        try {
            curToken = lexer.nextToken();
        } catch (PascalVarLexer.PascalVarLexerException e) {
            throw new PascalVarParserException("Can't parse token", e);
        }
        return curToken;
    }
    
    private void consume(PascalVarLexer.TokenType expectedTokenName) throws PascalVarParserException {
        if(curToken.getName() != expectedTokenName) {
            throw new PascalVarParserException("Expected: " + expectedTokenName + " got: " + curToken.getName());
        }
        nextToken();
    }

    PascalVarParser(PascalVarLexer lexer) throws PascalVarParserException {
        this.lexer = lexer;
        nextToken();
    }

    static class varContext {
        private Node node;
    
        varContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public varContext var() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                PascalVarLexer.Token n = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.NAME);
                return new varContext( new NodeRule("var", new NodeToken(n)));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class varsContext {
        private Node node;
    
        varsContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public varsContext vars() throws PascalVarParserException {
        switch (curToken.getName()) {
            case COLON:
            {
                return new varsContext( new NodeRule("vars"));
            }
            case COMMA:
            {
                PascalVarLexer.Token c = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.COMMA);
                varContext v = var();
                varsContext vv = vars();
                return new varsContext( new NodeRule("vars", v.node, vv.node));
            }
            default:
                throw new PascalVarParserException("Expected: COMMA or EPS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class typeContext {
        private Node node;
    
        typeContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public typeContext type() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                PascalVarLexer.Token n = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.NAME);
                return new typeContext( new NodeRule("type", new NodeToken(n)));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class declContext {
        private Node node;
    
        declContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public declContext decl() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                varContext v = var();
                varsContext list = vars();
                PascalVarLexer.Token c = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.COLON);
                typeContext t = type();
                PascalVarLexer.Token s = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.SEMICOLON);
                return new declContext( new NodeRule("decl", v.node, list.node, t.node));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class declsContext {
        private Node node;
    
        declsContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public declsContext decls() throws PascalVarParserException {
        switch (curToken.getName()) {
            case EOF:
            {
                return new declsContext( new NodeRule("decls"));
            }
            case NAME:
            {
                declContext d = decl();
                declsContext rest = decls();
                return new declsContext( new NodeRule("decls", d.node, rest.node));
            }
            default:
                throw new PascalVarParserException("Expected: EPS or NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class startContext {
        private Node node;
    
        startContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public startContext start() throws PascalVarParserException {
        switch (curToken.getName()) {
            case VAR:
            {
                PascalVarLexer.Token v = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.VAR);
                declsContext list = decls();
                return new startContext( new NodeRule("start", list.node));
            }
            default:
                throw new PascalVarParserException("Expected: VAR, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

}
