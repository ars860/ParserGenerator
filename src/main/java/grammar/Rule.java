package grammar;

import java.util.List;

public class Rule {
    private String name;
    private List<Argument> arguments;
    private Argument returns;
    private List<Option> options;

    static public class Argument {
        private final String name;
        private final String type;

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public Argument(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    public Rule(String name, List<Argument> arguments, Argument returns, List<Option> options) {
        this.name = name;
        this.arguments = arguments;
        this.returns = returns;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public Argument getReturns() {
        return returns;
    }

    public void setReturns(Argument returns) {
        this.returns = returns;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
