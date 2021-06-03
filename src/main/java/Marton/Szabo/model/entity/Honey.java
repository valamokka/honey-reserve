package Marton.Szabo.model.entity;

import lombok.Data;

@Data
public class Honey {

    private final String KIND_OF_HONEY;
    private final int WEIGHT;
    private final int FLAT_PRICE;
    private int sellingPrice;
    private int profit;
    private int quantitySold;
    private int quantityPacked;
    private int totalIncome;
    private int totalProfit;
    private int myShare;
    private int fatherShare;


    public Honey(String kindOfHoney, int weight, int flatPrice, int sellingPrice, int quantityPacked, int quantityBack) {
        this.KIND_OF_HONEY = kindOfHoney;
        this.WEIGHT = weight;
        this.FLAT_PRICE = flatPrice;
        this.sellingPrice = sellingPrice;
        this.quantityPacked = quantityPacked;
        quantitySold = quantityPacked - quantityBack;
        profit = this.sellingPrice - this.FLAT_PRICE;
        totalIncome = quantitySold*this.sellingPrice;
        totalProfit = quantitySold*profit;
        myShare = (int) (totalProfit*0.3);
        fatherShare = totalIncome - myShare;
    }

    public String toStringForPrintingSummary() {
        return
                "||| " + KIND_OF_HONEY +
                " ||| " + WEIGHT +
                " || eladva: " + quantitySold +
                " || bevetel: " + totalIncome +
                " || profit: " + totalProfit;
    }

    public String toStringForDisplayingPackedHoneys() {
        return
                "||| " + KIND_OF_HONEY +
                        " ||| weight: " + WEIGHT +
                        " || packed: " + quantityPacked;
    }


}
