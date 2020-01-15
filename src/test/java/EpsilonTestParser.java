import java.util.*;
import java.util.Arrays;
import java.util.List;


public class EpsilonTestParser {
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
        private EpsilonTestLexer.Token token;
    
        public NodeToken(EpsilonTestLexer.Token token) {
            this.token = token;
        }
    
        @Override
        public String show(int indent) {
            return "*  ".repeat(Math.max(0, indent)) + "("  + token.getName() + " : " + token.getText() + ")" + "\n";
        }
    }

    static class EpsilonTestParserException extends Exception {
        EpsilonTestParserException(String message) {
            super(message);
        }
    
        EpsilonTestParserException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private EpsilonTestLexer lexer;
    private EpsilonTestLexer.Token curToken;
    
    private EpsilonTestLexer.Token nextToken() throws EpsilonTestParserException {
        try {
            curToken = lexer.nextToken();
        } catch (EpsilonTestLexer.EpsilonTestLexerException e) {
            throw new EpsilonTestParserException("Can't parse token", e);
        }
        return curToken;
    }
    
    private void consume(EpsilonTestLexer.TokenType expectedTokenName) throws EpsilonTestParserException {
        if(curToken.getName() != expectedTokenName) {
            throw new EpsilonTestParserException("Expected: " + expectedTokenName + " got: " + curToken.getName());
        }
        nextToken();
    }

    EpsilonTestParser(EpsilonTestLexer lexer) throws EpsilonTestParserException {
        this.lexer = lexer;
        nextToken();
    }

    static class Eps3Context {
        private Set<String> res;
        private Node node;
    
        Eps3Context(Set<String> returns, Node node) {
            this.node = node;
            this.res = returns;
        }
    
        public Set<String> getRes() {
            return res;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public Eps3Context eps3() throws EpsilonTestParserException {
        Set<String> res;
        switch (curToken.getName()) {
            case EOF:
            {
                res = new HashSet<>();
                return new Eps3Context(res, new NodeRule("eps3"));
            }
            case Z:
            {
                EpsilonTestLexer.Token z = new EpsilonTestLexer.Token(curToken);
                consume(EpsilonTestLexer.TokenType.Z);
                res = Collections.singleton(z.getText());
                return new Eps3Context(res, new NodeRule("eps3"));
            }
            default:
                throw new EpsilonTestParserException("Expected: EPS or Z, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class Eps2Context {
        private Set<String> res;
        private Node node;
    
        Eps2Context(Set<String> returns, Node node) {
            this.node = node;
            this.res = returns;
        }
    
        public Set<String> getRes() {
            return res;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public Eps2Context eps2() throws EpsilonTestParserException {
        Set<String> res;
        switch (curToken.getName()) {
            case Z:
            case EOF:
            {
                res = new HashSet<>();
                return new Eps2Context(res, new NodeRule("eps2"));
            }
            case Y:
            {
                EpsilonTestLexer.Token y = new EpsilonTestLexer.Token(curToken);
                consume(EpsilonTestLexer.TokenType.Y);
                res = Collections.singleton(y.getText());
                return new Eps2Context(res, new NodeRule("eps2"));
            }
            default:
                throw new EpsilonTestParserException("Expected: EPS or Y, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class Eps1Context {
        private Set<String> res;
        private Node node;
    
        Eps1Context(Set<String> returns, Node node) {
            this.node = node;
            this.res = returns;
        }
    
        public Set<String> getRes() {
            return res;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public Eps1Context eps1() throws EpsilonTestParserException {
        Set<String> res;
        switch (curToken.getName()) {
            case Y:
            case EOF:
            {
                res = new HashSet<>();
                return new Eps1Context(res, new NodeRule("eps1"));
            }
            case X:
            {
                EpsilonTestLexer.Token x = new EpsilonTestLexer.Token(curToken);
                consume(EpsilonTestLexer.TokenType.X);
                res = Collections.singleton(x.getText());
                return new Eps1Context(res, new NodeRule("eps1"));
            }
            default:
                throw new EpsilonTestParserException("Expected: X or EPS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class StartContext {
        private Set<String> letters;
        private Node node;
    
        StartContext(Set<String> returns, Node node) {
            this.node = node;
            this.letters = returns;
        }
    
        public Set<String> getLetters() {
            return letters;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public StartContext start() throws EpsilonTestParserException {
        Set<String> letters;
        switch (curToken.getName()) {
            case X:
            case Y:
            case Z:
            case EOF:
            {
                Eps1Context e1 = eps1();
                Eps2Context e2 = eps2();
                Eps3Context e3 = eps3();
                letters = new HashSet<>(); letters.addAll(e1.res); letters.addAll(e2.res); letters.addAll(e3.res);
                return new StartContext(letters, new NodeRule("start", e1.node, e2.node, e3.node));
            }
            default:
                throw new EpsilonTestParserException("Expected: X or EPS or Y or Z, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

}
