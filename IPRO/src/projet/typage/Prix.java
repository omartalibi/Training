package projet.typage;

public class Prix {
    private Double prix;

    public static Prix Prix(final Double value) {
        return new Prix(value);
    }

    public Prix(Double prix){
        this.prix = prix;
    }

    public Double getPrixValue() {
        return prix;
    }

    @Override
    public String toString() {
        return String.valueOf(prix);
    }

}
