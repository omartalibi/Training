package kata.arbreAST.Solution2;

public class ASTOperator implements IOperator {
    private IAST FG;
    private IAST FD;
    private String symbole;

    @Override
    public IAST getFG() {
        return FG;
    }

    @Override
    public IAST getFD() {
        return FD;
    }

    @Override
    public String getSymbole() {
        return symbole;
    }

    public void setFG(IAST FG) {
        this.FG = FG;
    }

    public void setFD(IAST FD) {
        this.FD = FD;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
