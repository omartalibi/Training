package kata.arbreAST.Solution2;

public interface IOperator extends IAST {
    IAST getFG();
    IAST getFD();
    String getSymbole();
}
