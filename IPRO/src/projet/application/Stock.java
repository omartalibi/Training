package projet.application;

import projet.typage.Id;

import java.util.ArrayList;
import java.util.List;

import static projet.typage.Quantity.*;

public class Stock {
    private Id id;
    private List<StockQte> stockQteList;

    public Stock(Id id) {
        this.id = id;
        this.stockQteList =  new ArrayList<>();
    }

    public void addSellable(ISellable iSellable){
        stockQteList.add(new StockQte(iSellable, Quantity(1)));
    }

    public void addSellable(ISellable iSellable, int nb){
        stockQteList.add(new StockQte(iSellable, Quantity(nb)));
    }

    public void addSellables(ISellable...iSellables){
        for(ISellable sellable: iSellables){
            stockQteList.add(new StockQte(sellable, Quantity(1)));

        }
    }

    public void decreaseSellable(ISellable iSellable){

        for(StockQte stockQte: stockQteList){
            if(stockQte.getIsellable().getReferenceObject().getReferenceValue().equals(iSellable.getReferenceObject().getReferenceValue())){
                if(stockQte.getQuantity().getQuantityValue() == 1) {
                    stockQteList.remove(stockQte);
                    break;
                }
                else
                    stockQte.decrease(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockQteList=" + stockQteList +
                '}';
    }

    public Id getId() {
        return id;
    }

    public List<StockQte> getStockQteList() {
        return stockQteList;
    }
}
