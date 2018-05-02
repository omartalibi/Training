package kata.arbreAST.Simple;

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
    public String render(AST ast) {
        return "(" + render(((BinaryOperator) ast).getFG()) + " " +
                ((BinaryOperator) ast).getSymbole() + " " +
                render(((BinaryOperator) ast).getFD()) + ")";
    }

    @Override
    public int compute(AST ast) {
        return 0;
    }
}
