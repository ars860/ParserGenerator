//just some text to test @header
import java.util.Arrays;
import java.util.List;


public class CaclulatorParser {
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
        private CaclulatorLexer.Token token;
    
        public NodeToken(CaclulatorLexer.Token token) {
            this.token = token;
        }
    
        @Override
        public String show(int indent) {
            return "*  ".repeat(Math.max(0, indent)) + "("  + token.getName() + " : " + token.getText() + ")" + "\n";
        }
    }

    static class CaclulatorParserException extends Exception {
        CaclulatorParserException(String message) {
            super(message);
        }
    
        CaclulatorParserException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private CaclulatorLexer lexer;
    private CaclulatorLexer.Token curToken;
    
    private CaclulatorLexer.Token nextToken() throws CaclulatorParserException {
        try {
            curToken = lexer.nextToken();
        } catch (CaclulatorLexer.CaclulatorLexerException e) {
            throw new CaclulatorParserException("Can't parse token", e);
        }
        return curToken;
    }
    
    private void consume(CaclulatorLexer.TokenType expectedTokenName) throws CaclulatorParserException {
        if(curToken.getName() != expectedTokenName) {
            throw new CaclulatorParserException("Expected: " + expectedTokenName + " got: " + curToken.getName());
        }
        nextToken();
    }

    CaclulatorParser(CaclulatorLexer lexer) throws CaclulatorParserException {
        this.lexer = lexer;
        nextToken();
    }

    static class unaryContext {
        private Integer val;
        private Node node;
    
        unaryContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public unaryContext unary() throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case LP:
            {
                CaclulatorLexer.Token l = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.LP);
                startContext mid = start();
                CaclulatorLexer.Token r = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.RP);
                val = mid.res;
                return new unaryContext(val, new NodeRule("unary", mid.node));
            }
            case NUMBER:
            {
                CaclulatorLexer.Token num = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.NUMBER);
                val = Integer.valueOf(num.getText());
                return new unaryContext(val, new NodeRule("unary", new NodeToken(num)));
            }
            case MINUS:
            {
                CaclulatorLexer.Token m = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.MINUS);
                unaryContext rest = unary();
                val = -1 * rest.val;
                return new unaryContext(val, new NodeRule("unary", rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: NUMBER or LP or MINUS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class powContContext {
        private Integer val;
        private Node node;
    
        powContContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public powContContext powCont() throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case DIV:
            case MULT:
            case EOF:
            case RP:
            case MINUS:
            case PLUS:
            {
                val = 1;
                return new powContContext(val, new NodeRule("powCont"));
            }
            case POW:
            {
                CaclulatorLexer.Token p = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.POW);
                unaryContext first = unary();
                powContContext rest = powCont();
                val = (int) Math.pow(first.val.doubleValue(), rest.val.doubleValue());
                return new powContContext(val, new NodeRule("powCont", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: EPS or POW, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class multDivContext {
        private Integer val;
        private Node node;
    
        multDivContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public multDivContext multDiv() throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case NUMBER:
            case LP:
            case MINUS:
            {
                unaryContext first = unary();
                powContContext rest = powCont();
                val = (int) Math.pow(first.val.doubleValue(), rest.val.doubleValue());
                return new multDivContext(val, new NodeRule("multDiv", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: NUMBER or LP or MINUS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class multDivContContext {
        private Integer val;
        private Node node;
    
        multDivContContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public multDivContContext multDivCont(Integer acc) throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case EOF:
            case RP:
            case MINUS:
            case PLUS:
            {
                val = acc;
                return new multDivContContext(val, new NodeRule("multDivCont"));
            }
            case DIV:
            {
                CaclulatorLexer.Token d = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.DIV);
                multDivContext first = multDiv();
                Integer nextAcc = acc / first.val;
                multDivContContext rest = multDivCont(nextAcc);
                val = rest.val;
                return new multDivContContext(val, new NodeRule("multDivCont", first.node, rest.node));
            }
            case MULT:
            {
                CaclulatorLexer.Token m = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.MULT);
                multDivContext first = multDiv();
                Integer nextAcc = acc * first.val;
                multDivContContext rest = multDivCont(nextAcc);
                val = rest.val;
                return new multDivContContext(val, new NodeRule("multDivCont", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: DIV or MULT or EPS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class addSubContContext {
        private Integer val;
        private Node node;
    
        addSubContContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public addSubContContext addSubCont() throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case NUMBER:
            case LP:
            case MINUS:
            {
                multDivContext first = multDiv();
                multDivContContext rest = multDivCont(first.val);
                val = rest.val;
                return new addSubContContext(val, new NodeRule("addSubCont", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: NUMBER or LP or MINUS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class addSubContext {
        private Integer val;
        private Node node;
    
        addSubContext(Integer returns, Node node) {
            this.node = node;
            this.val = returns;
        }
    
        public Integer getval() {
            return val;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public addSubContext addSub(Integer acc) throws CaclulatorParserException {
        Integer val;
        switch (curToken.getName()) {
            case EOF:
            case RP:
            {
                val = acc;
                return new addSubContext(val, new NodeRule("addSub"));
            }
            case MINUS:
            {
                CaclulatorLexer.Token m = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.MINUS);
                addSubContContext first = addSubCont();
                Integer nextAcc = acc - first.val;
                addSubContext rest = addSub(nextAcc);
                val = rest.val;
                return new addSubContext(val, new NodeRule("addSub", first.node, rest.node));
            }
            case PLUS:
            {
                CaclulatorLexer.Token p = new CaclulatorLexer.Token(curToken);
                consume(CaclulatorLexer.TokenType.PLUS);
                addSubContContext first = addSubCont();
                Integer nextAcc = acc + first.val;
                addSubContext rest = addSub(nextAcc);
                val = rest.val;
                return new addSubContext(val, new NodeRule("addSub", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: EPS or MINUS or PLUS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

    static class startContext {
        private Integer res;
        private Node node;
    
        startContext(Integer returns, Node node) {
            this.node = node;
            this.res = returns;
        }
    
        public Integer getres() {
            return res;
        }
    
        public Node getNode() {
            return node;
        }
    }

    public startContext start() throws CaclulatorParserException {
        Integer res;
        switch (curToken.getName()) {
            case NUMBER:
            case LP:
            case MINUS:
            {
                addSubContContext first = addSubCont();
                addSubContext rest = addSub(first.val);
                res = rest.val;
                return new startContext(res, new NodeRule("start", first.node, rest.node));
            }
            default:
                throw new CaclulatorParserException("Expected: NUMBER or LP or MINUS, got: " + curToken.getName().name() + ", at: ..." + curToken.getText() + lexer.getInput().substring(0, Math.min(10, lexer.getInput().length())) + (lexer.getInput().length() > 10 ? "..." : ""));
        }
    }

}
