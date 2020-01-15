package grammar.atom;

public class Code implements Atom {
    private String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public type getType() {
        return type.CODE;
    }

    @Override
    public String toString() {
        return code;
    }

    public String prettify() {
        return code.length() != 0 ? code.substring(1).substring(0, code.length() - 2) : code;
    }
}
