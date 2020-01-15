package grammar.atom;

public interface Atom {
    enum type{
        CODE, RULE, TOKEN
    }

    type getType();
}
