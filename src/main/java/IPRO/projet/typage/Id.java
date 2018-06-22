package IPRO.projet.typage;

public class Id {
    private int id;

    public static Id Id(final int value) {
        return new Id(value);
    }

    public Id(int id){
        this.id = id;
    }

    public int getIdValue() {
        return id;
    }
    public void setIdValue(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

