package abstractFactory.AbstractLangages;

import abstractFactory.Saver.Saver;

abstract public class ParserAbstract{
    public abstract void parse();
    abstract public String getName();

    public void save(){
        Saver.saveParser(getName(), this);
    }

    {
        this.save();
    }
}
