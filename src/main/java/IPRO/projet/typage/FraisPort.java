package IPRO.projet.typage;

public class FraisPort {
    private Double fraisPort;

    public static FraisPort FraisPort(final Double value) {
        return new FraisPort(value);
    }

    public FraisPort(Double fraisPort){
        this.fraisPort = fraisPort;
    }

    public Double getFraisPortValue() {
        return fraisPort;
    }

    @Override
    public String toString() {
        return String.valueOf(fraisPort);
    }

}
