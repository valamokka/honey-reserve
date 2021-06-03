package Marton.Szabo.model.dao;

import Marton.Szabo.model.entity.Honey;

import java.util.List;

public interface PackSellDao {

    List<Honey> getAllHoneys();
    void packHoney(String kind, int weight, int quantity);
    void unpackHoney(String kind, int weight, int quantity);

}
