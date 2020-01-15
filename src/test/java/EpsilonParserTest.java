public class EpsilonParserTest {
    public static void main(String[] args) {
        EpsilonTestLexer lexer = new EpsilonTestLexer("x z");
        try {
            EpsilonTestParser parser = new EpsilonTestParser(lexer);
            EpsilonTestParser.StartContext startContext = parser.start();
            System.out.println("Result = " + startContext.getLetters() + "\nTree:");
            System.out.println(startContext.getNode().show(0));
        } catch (EpsilonTestParser.EpsilonTestParserException e) {
            System.err.println(e + (e.getCause() == null ? "" : "\nWith cause: " + e.getCause()));
        }
    }
}