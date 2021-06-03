package Marton.Szabo.model.dao;

public interface SetupDao {

    void registerHoney(String kind, int weight, int sellingPrice, int flatCost);
    void deleteHoney(String kind, int weight);
    void updateSellingPrice(String kind, int weight, int newSellingPrice);
    void updateFlatCost(String kind, int weight, int newFlatCost);
    void deleteAllHoneys();
}
