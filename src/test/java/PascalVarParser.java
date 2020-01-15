
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

    static class VarContext {
        private Node node;
    
        VarContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public VarContext var() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                PascalVarLexer.Token n = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.NAME);
                return new VarContext( new NodeRule("var", new NodeToken(n)));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class VarsContext {
        private Node node;
    
        VarsContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public VarsContext vars() throws PascalVarParserException {
        switch (curToken.getName()) {
            case COLON:
            {
                return new VarsContext( new NodeRule("vars"));
            }
            case COMMA:
            {
                PascalVarLexer.Token c = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.COMMA);
                VarContext v = var();
                VarsContext vv = vars();
                return new VarsContext( new NodeRule("vars", v.node, vv.node));
            }
            default:
                throw new PascalVarParserException("Expected: COMMA or EPS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class TypeContext {
        private Node node;
    
        TypeContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public TypeContext type() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                PascalVarLexer.Token n = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.NAME);
                return new TypeContext( new NodeRule("type", new NodeToken(n)));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class DeclContext {
        private Node node;
    
        DeclContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public DeclContext decl() throws PascalVarParserException {
        switch (curToken.getName()) {
            case NAME:
            {
                VarContext v = var();
                VarsContext list = vars();
                PascalVarLexer.Token c = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.COLON);
                TypeContext t = type();
                PascalVarLexer.Token s = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.SEMICOLON);
                return new DeclContext( new NodeRule("decl", v.node, list.node, t.node));
            }
            default:
                throw new PascalVarParserException("Expected: NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class DeclsContext {
        private Node node;
    
        DeclsContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public DeclsContext decls() throws PascalVarParserException {
        switch (curToken.getName()) {
            case EOF:
            {
                return new DeclsContext( new NodeRule("decls"));
            }
            case NAME:
            {
                DeclContext d = decl();
                DeclsContext rest = decls();
                return new DeclsContext( new NodeRule("decls", d.node, rest.node));
            }
            default:
                throw new PascalVarParserException("Expected: EPS or NAME, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class StartContext {
        private Node node;
    
        StartContext(Node node) {
            this.node = node;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public StartContext start() throws PascalVarParserException {
        switch (curToken.getName()) {
            case VAR:
            {
                PascalVarLexer.Token v = new PascalVarLexer.Token(curToken);
                consume(PascalVarLexer.TokenType.VAR);
                DeclsContext list = decls();
                return new StartContext( new NodeRule("start", list.node));
            }
            default:
                throw new PascalVarParserException("Expected: VAR, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

}
