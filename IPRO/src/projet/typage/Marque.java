package projet.typage;

public class Marque {
    private String marque;

    public static Marque Marque(final String value) {
        return new Marque(value);
    }

    public Marque(String marque){
        this.marque = marque;
    }

    @Override
    public String toString() {
        return marque;
    }

    public String getMarque() {
        return marque;
    }
}
