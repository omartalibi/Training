package abstractFactory.Langages.Java;

import abstractFactory.AbstractLangages.ParserAbstract;

public class JavaParser extends ParserAbstract {
    @Override
    public void parse() {
        System.out.println("Parsing scala ");
    }

    @Override
    public String getName() {
        return "Java";
    }
}
