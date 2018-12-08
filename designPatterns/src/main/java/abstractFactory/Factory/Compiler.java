package abstractFactory.Factory;

import abstractFactory.AbstractLangages.*;

public class Compiler {
    protected GeneratorAbstract generatorAbstract;
    protected LexerAbstract lexerAbstract;
    protected ParserAbstract parserAbstract;

    public Compiler(GeneratorAbstract generatorAbstract, LexerAbstract lexerAbstract, ParserAbstract parserAbstract) {
        this.generatorAbstract = generatorAbstract;
        this.lexerAbstract = lexerAbstract;
        this.parserAbstract = parserAbstract;
    }

    public void compile(){
        lexerAbstract.scan();
        parserAbstract.parse();
        generatorAbstract.generate();
    }

}
