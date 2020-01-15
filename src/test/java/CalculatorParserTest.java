import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorParserTest extends Assert {
//    public static void main(String[] args) {
//        CaclulatorLexer lexer = new CaclulatorLexer("(1 + 2 + 3 + 12 * (- 1)) / 2 * (3 + 1)");
//        try {
//            CaclulatorParser parser = new CaclulatorParser(lexer);
//            CaclulatorParser.startContext startContext = parser.start();
//            System.out.println("Result = " + startContext.getres() + "\nTree:");
//            System.out.println(startContext.getNode().show(0));
//        } catch (CaclulatorParser.CaclulatorParserException e) {
//            System.err.println(e + (e.getCause() == null ? "" : "\nWith cause: " + e.getCause()));
//        }
//    }

    private CaclulatorParser.StartContext proceedString(String input) throws CaclulatorParser.CaclulatorParserException {
        CaclulatorLexer lexer = new CaclulatorLexer(input);
        CaclulatorParser parser = new CaclulatorParser(lexer);

        return parser.start();
    }

    private int getResult(String input) throws CaclulatorParser.CaclulatorParserException {
        return proceedString(input).getRes();
    }

    @Test
    public void resultTest() throws CaclulatorParser.CaclulatorParserException {
        assertEquals(2, getResult("1 + 1"));
        assertEquals(1, getResult("64 / (1 + 1) / (5 - 3) / (3 - (4 / 2)) / 2 / (8 / 2 * 2)"));
        assertEquals(-12, getResult("(1 + 2 + 3 + 12 * (- 1)) / 2 * (3 + 1)"));
        assertEquals(27 , getResult("3 ^ (2 ^ 2 - 1)"));
    }

    @Test
    public void testThrows() {
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("one + two"));
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("1 +"));
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("1 + ("));
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("((1 + 1)"));
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("((1 + 1) - )"));
        Assertions.assertThrows(CaclulatorParser.CaclulatorParserException.class, () -> proceedString("((1 + 1 1))"));
    }
}
