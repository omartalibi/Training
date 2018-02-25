package should;

import kata.arbreAST.Solution2.ASTCalculation;
import kata.arbreAST.Solution2.ASTLiteral;
import kata.arbreAST.Solution2.ASTOperator;
import org.junit.Test;

public class ASTShould {


    @Test
    public void test(){
        ASTOperator ast = new ASTOperator();
        ast.setSymbole("+");

        ASTLiteral filsDroit = new ASTLiteral();
        filsDroit.setValue("3");

        ASTLiteral filsGauche = new ASTLiteral();
        filsGauche.setValue("2");

        ast.setFD(filsDroit);
        ast.setFG(filsGauche);

        System.out.println(ASTCalculation.render(ast));
    }
}
