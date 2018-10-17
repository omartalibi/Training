package projet.application;

import projet.typage.Quantity;

import static projet.typage.Quantity.*;

public class StockQte {
    Quantity quantity;
    ISellable isellable;

    public StockQte(ISellable isellable,Quantity quantity) {
        this.quantity = quantity;
        this.isellable = isellable;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public ISellable getIsellable() {
        return isellable;
    }

    public void decrease(int nb){
        this.quantity = Quantity(this.quantity.getQuantityValue() - nb);
    }

    @Override
    public String toString() {
        return "StockQte{" +
                "quantity=" + quantity +
                ", isellable=" + isellable +
                '}';
    }


}
