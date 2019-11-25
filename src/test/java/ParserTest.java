import antlr.ExprLexer;
import antlr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserTest extends Assert {
    public static String parse(String testString) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        CharStream stream = CharStreams.fromString(testString);

        ExprLexer exprLexer = new ExprLexer(stream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);

        ExprParser exprParser = new ExprParser(commonTokenStream);

        exprParser.start();

        System.setOut(null);
        List<String> splitted = Arrays.stream(byteArrayOutputStream.toString().split("[\n\r]")).filter(str -> !str.isEmpty()).collect(Collectors.toList());
        return String.join(";", splitted);
    }

    public void runTest(String testString, String res) {
        assertEquals(parse(testString),res);
    }

    @Test
    public void simpleTest(){
        String testString = "a = 2;\n" +
                "b = a / 2;\n" +
                "c = a + b * (b - 3);\n" +
                "a = 3;\n" +
                "c = a + b * (b - 3);";

        assertEquals(parse(testString),"a = 2;b = 1;c = 0;a = 3;c = 1");
    }

    @Test
    public void aaaa(){
        runTest("a = 45; b=14; c = a - b; d = c + c + c; e = c - c + a + 24; e = a; a = 25;", "a = 45;b = 14;c = 31;d = 93;e = 69;e = 45;a = 25");
    }
}
