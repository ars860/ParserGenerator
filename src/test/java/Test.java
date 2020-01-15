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
    private static void generateParser(Path inPath, Path outPath) throws IOException, GrammarParsingException, GrammarException {
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
    }

    public static void main(String[] args) throws GrammarException, IOException, GrammarParsingException {
//        Path inPath = Path.of("src/test/grammars/calculator.grammar");
//        Path inPath = Path.of("src/test/grammars/pascalVar.grammar");
//        Path inPath = Path.of("src/test/grammars/epsilonRules.grammar");
        Path outPath = Path.of("src/test/java");

        generateParser(Path.of("src/test/grammars/calculator.grammar"), outPath);
        generateParser(Path.of("src/test/grammars/pascalVar.grammar"), outPath);
        generateParser(Path.of("src/test/grammars/epsilonRules.grammar"), outPath);
    }
}
