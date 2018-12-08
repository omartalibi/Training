package abstractFactory.AbstractLangages;

import abstractFactory.Saver.Saver;

abstract public class GeneratorAbstract {
    abstract public void generate();
    abstract public String getName();

    public void save(){
        Saver.saveGeneretor(getName(),this);
    }

    {
        this.save();
    }
}
