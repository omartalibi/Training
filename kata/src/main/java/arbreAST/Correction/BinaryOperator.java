package arbreAST.Correction;

final class BinaryOperator implements AST {
    private AST FG;
    private AST FD;
    private String symbole;

    BinaryOperator(String symbole, AST FG, AST FD) {
        this.FG = FG;
        this.FD = FD;
        this.symbole = symbole;
    }

    public AST getFG() {
        return FG;
    }

    public AST getFD() {
        return FD;
    }

    public String getSymbole() {
        return symbole;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
