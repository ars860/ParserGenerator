package antlr;

import grammar.Grammar;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class AntlrGrammarParser {
    public static Grammar getGrammarFromFile(Path in) throws GrammarParsingException {
        String grammarString;
        try (BufferedReader reader = Files.newBufferedReader(in)) {
            grammarString = reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new GrammarParsingException("Can't read input file: " + in.toString(), e);
        }

        return getGrammarFromString(grammarString);
    }

    public static Grammar getGrammarFromString(String grammarString) throws GrammarParsingException {
        CharStream stream = CharStreams.fromString(grammarString);

        RulesLexer exprLexer = new RulesLexer(stream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);

        RulesParser exprParser = new RulesParser(commonTokenStream);

        Grammar grammar;

        try {
            grammar = exprParser.start().grammar;
        } catch (Exception e) {
            throw new GrammarParsingException("Exception during parsing grammar with antlr", e);
        }

        return grammar;
    }
}
