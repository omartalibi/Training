package projet.typage;

public class Quantity {
    private int quantity;

    public static Quantity Quantity(final int value) {
        return new Quantity(value);
    }

    public Quantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantityValue() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }

}
