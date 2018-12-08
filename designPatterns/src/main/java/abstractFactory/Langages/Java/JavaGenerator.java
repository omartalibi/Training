package abstractFactory.Langages.Java;

import abstractFactory.AbstractLangages.GeneratorAbstract;

public class JavaGenerator extends GeneratorAbstract {
    @Override
    public void generate() {
        System.out.println("Generating Scala ");
    }

    @Override
    public String getName() {
        return "Java";
    }


}
