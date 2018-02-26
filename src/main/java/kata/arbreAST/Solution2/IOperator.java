package kata.arbreAST.Solution2;

public interface IOperator extends IAST {
    public IAST getFG();
    public IAST getFD();
    public String getSymbole();
}
