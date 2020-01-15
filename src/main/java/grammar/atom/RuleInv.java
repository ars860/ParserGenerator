package grammar.atom;

import java.util.List;

public class RuleInv implements Atom {
    private String newName;
    private String ruleName;
    private List<String> arguments;

    public RuleInv(String newName, String ruleName, List<String> arguments) {
        this.newName = newName;
        this.ruleName = ruleName;
        this.arguments = arguments;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public type getType() {
        return type.RULE;
    }

    @Override
    public String toString() {
        return newName + " = " + ruleName + "[" + String.join(", ", arguments) + "]";
    }
}
