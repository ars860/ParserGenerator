package generator;

import grammar.Grammar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Generator {
    BufferedWriter writer;
    Grammar grammar;

    public Generator(Grammar grammar, Path out) throws IOException {
        this.grammar = grammar;
        writer = Files.newBufferedWriter(out);
    }

    void generateImports(String ...strings) throws IOException {
        writeStrings(0, Arrays.stream(strings).map(importString -> "import " + importString + ";").toArray(String[]::new));
        writeln();
        writeln();
    }

    void writeln() throws IOException {
        writer.write("\n");
    }

    void writeString(String str, int tabs) throws IOException {
        for (int i = 0; i < tabs; i++) {
            writer.write("    ");
        }
        writer.write(str);
        writer.write("\n");
    }

    void writeStrings(int tabs, String... strings) throws IOException {
        for(final String string : strings) {
            writeString(string, tabs);
        }
    }

    String getName() {
        return grammar.getGrammarName();
    }
}
