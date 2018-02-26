package kata.arbreAST.Solution2;

public class ASTOperator implements IOperator {
    private IAST FG;
    private IAST FD;
    private String symbole;

    public ASTOperator(IAST FG, IAST FD, String symbole) {
        this.FG = FG;
        this.FD = FD;
        this.symbole = symbole;
    }

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

}
