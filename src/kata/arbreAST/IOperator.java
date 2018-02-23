package kata.arbreAST;

public interface IOperator extends IAST {
    public IAST getFG();
    public IAST getFD();
    public String getSymbole();
}
