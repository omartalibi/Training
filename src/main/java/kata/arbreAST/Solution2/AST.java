package kata.arbreAST.Solution2;

public class AST implements IAST{

    private IAST FG;
    private IAST FD;
    private String value;

    public void setFD(IAST FD) {
        this.FD = FD;
    }

    public IAST getFG() {
        return FG;
    }

    public void setFG(IAST FG) {
        this.FG = FG;
    }

    public IAST getFD() {
        return FD;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
