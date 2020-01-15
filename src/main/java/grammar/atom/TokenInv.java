package grammar.atom;

public class TokenInv implements Atom {
    private String name;
    private String newName;

    public TokenInv(String newName, String name) {
        this.name = name;
        this.newName = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public type getType() {
        return type.TOKEN;
    }

    @Override
    public String toString() {
        return newName + " = " + name;
    }
}
