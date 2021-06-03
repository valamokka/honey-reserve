package Marton.Szabo.model.dao;

public interface MarketResultDao {

    void updateQuantityBack(String kind, int weight, int quantityBack);
    void resetAllQuantities();
}
