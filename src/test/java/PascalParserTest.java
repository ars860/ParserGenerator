import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PascalParserTest extends Assert {
//    public static void main(String[] args) {
//        PascalVarLexer lexer = new PascalVarLexer("var a, b, c : t1; d, e ,f : t2;");
//        try {
//            PascalVarParser parser = new PascalVarParser(lexer);
//            PascalVarParser.startContext startContext = parser.start();
//            System.out.println(startContext.getNode().show(0));
//        } catch (PascalVarParser.PascalVarParserException e) {
//            System.err.println(e + (e.getCause() == null ? "" : "\nWith cause: " + e.getCause()));
//        }
//    }

    private PascalVarParser.StartContext proceedString(String input) throws PascalVarParser.PascalVarParserException {
        PascalVarLexer lexer = new PascalVarLexer(input);
        PascalVarParser parser = new PascalVarParser(lexer);

        return parser.start();
    }

    @Test
    public void simpleTest() throws PascalVarParser.PascalVarParserException {
        String testString = "var aba:type;aba,baba,caba:type;  ";
        System.out.println(proceedString(testString).getNode().show(0));
    }

    @Test
    public void iDontKnowHowToWriteTestsParser() throws PascalVarParser.PascalVarParserException {
        String testString = "                 \n" +
                "\n" +
                "var\n" +
                "a\n" +
                ",\n" +
                "b\n" +
                ":                                                             t1\n" +
                "\n" +
                ";\n" +
                "                             aba,                             baba,                     caba    :    type2;";
        System.out.println(proceedString(testString).getNode().show(0));
    }

    @Test
    public void noVarTest() {
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("no var here"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("vhaha"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("vahaha"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("varhaha"));
    }

    @Test
    public void badNames() {
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var V@r1aBl3"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var 1variable"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a : B@d_Typ3"));
    }

    @Test
    public void intruders() {
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a, b, c Intruder"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a,b : int Intruder"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a,b : int; ;"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a,,b : int; ;"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var ,a,b : int; ;"));
        Assertions.assertThrows(PascalVarParser.PascalVarParserException.class, () -> proceedString("var a,b : :int; ;"));
    }
}
