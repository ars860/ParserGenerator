import antlr.AntlrGrammarParser;
import antlr.GrammarParsingException;
import antlr.RulesLexer;
import antlr.RulesParser;
import generator.LexerGenerator;
import generator.ParserGenerator;
import grammar.Grammar;
import grammar.GrammarException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Test {
    public static Grammar parse(String testString) {
        CharStream stream = CharStreams.fromString(testString);

        RulesLexer exprLexer = new RulesLexer(stream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);

        RulesParser exprParser = new RulesParser(commonTokenStream);

        return exprParser.start().grammar;
    }

    public static void main(String[] args) throws GrammarException, IOException, GrammarParsingException {
//        Path inPath = Path.of("src/test/grammars/calculator.grammar");
//        Path inPath = Path.of("src/test/grammars/pascalVar.grammar");
        Path inPath = Path.of("src/test/grammars/epsilonRules.grammar");
        Path outPath = Path.of("src/test/java");

        Grammar grammar = AntlrGrammarParser.getGrammarFromFile(inPath);
        grammar.init();
        Files.createDirectories(outPath);
        try {
            Files.createFile(outPath.resolve(grammar.getGrammarName() + "Lexer.java"));
            Files.createFile(outPath.resolve(grammar.getGrammarName() + "Parser.java"));
        } catch (FileAlreadyExistsException e) {
            //ignore
        }
        LexerGenerator lexerGenerator = new LexerGenerator(grammar, outPath.resolve(grammar.getGrammarName() + "Lexer.java"));
        lexerGenerator.generateLexer();
        ParserGenerator parserGenerator = new ParserGenerator(grammar, outPath.resolve(grammar.getGrammarName() + "Parser.java"));
        parserGenerator.generateParser();
        int x = 123 + 123;
//        int x = 123 + 123;
    }
}
