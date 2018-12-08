package abstractFactory.Langages.Scala;

import abstractFactory.AbstractLangages.GeneratorAbstract;

public class ScalaGenerator extends GeneratorAbstract {
    @Override
    public void generate() {
        System.out.println("Generating Java ");
    }

    @Override
    public String getName() {
        return "Scala";
    }
}
