package projet.typage;

public class Reduction {
    private Double reduction;

    public static Reduction Reduction(final Double value) {
        return new Reduction(value);
    }

    public Reduction(Double reduction){
        this.reduction = reduction;
    }

    public Double getReductionValue() {
        return reduction;
    }

    @Override
    public String toString() {
        return String.valueOf(reduction);
    }
}
