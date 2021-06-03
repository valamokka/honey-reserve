package Marton.Szabo.model.jdbc;

import Marton.Szabo.model.dao.SetupDao;
import Marton.Szabo.model.utility.DatabaseManager;

import java.sql.*;

public class SetupJDBCdao implements SetupDao {

    @Override
    public void registerHoney(String kind, int weight, int sellingPrice, int flatCost) {
        String SQL = "INSERT INTO honey (kind_of_honey, weight, flat_cost, selling_price, quantity_packed, quantity_back) VALUES (?,?,?,?,0,0)";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, kind);
            ps.setInt(2, weight);
            ps.setInt(3, flatCost);
            ps.setInt(4, sellingPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSellingPrice(String kind, int weight, int newSellingPrice) {
        String SQL = "UPDATE honey SET selling_price = ? WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, newSellingPrice);
            ps.setString(2, kind);
            ps.setInt(3, weight);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFlatCost(String kind, int weight, int newFlatCost) {
        String SQL = "UPDATE honey SET flat_cost = ? WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, newFlatCost);
            ps.setString(2, kind);
            ps.setInt(3, weight);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllHoneys() {
        String SQL = "DELETE FROM honey";
        try (Connection conn = DatabaseManager.getConnection()) {
            Statement statement = conn.createStatement();
            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHoney(String kind, int weight) {
        String SQL = "DELETE FROM honey WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, kind);
            ps.setInt(2, weight);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
