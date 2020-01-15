package grammar;

import grammar.atom.Atom;

import java.util.List;
import java.util.stream.Collectors;

public class Option {
    private List<Atom> atoms;

    public Option(List<Atom> atoms) {
        this.atoms = atoms;
    }

    public List<Atom> getAtoms() {
        return atoms;
    }

    public void setAtoms(List<Atom> atoms) {
        this.atoms = atoms;
    }

    @Override
    public String toString() {
        return atoms.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
