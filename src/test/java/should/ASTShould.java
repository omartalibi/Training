package should;

import kata.arbreAST.Solution2.AST;
import kata.arbreAST.Solution2.ASTCalculation;
import org.junit.Assert;
import org.junit.Test;

public class ASTShould {


    @Test
    public void test(){
        AST ast = new AST();
        ast.setValue("+");

        AST filsDroit = new AST();
        filsDroit.setValue("1");

        AST filsGauche = new AST();
        filsGauche.setValue("2");

        ast.setFD(filsDroit);
        ast.setFG(filsGauche);

        System.out.println(ASTCalculation.render(ast));
    }
}
