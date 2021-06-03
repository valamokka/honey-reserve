package Marton.Szabo.model.jdbc;

import Marton.Szabo.model.dao.MarketResultDao;
import Marton.Szabo.model.entity.Honey;
import Marton.Szabo.model.utility.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarketResultJDBCdao implements MarketResultDao {



    @Override
    public void updateQuantityBack(String kind, int weight, int quantityBack) {
        String SQL = "UPDATE honey SET quantity_back = ? WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()){
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, quantityBack);
            ps.setString(2, kind);
            ps.setInt(3, weight);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetAllQuantities() {
        String SQL = "UPDATE honey SET quantity_packed = 0, quantity_back = 0";
        try (Connection conn = DatabaseManager.getConnection()) {
            Statement statement = conn.createStatement();
            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Honey> getAllHoneys() {
        List<Honey> allHoneys = new ArrayList<>();
        String SQL = "SELECT * FROM honey";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                allHoneys.add(new
                        Honey(rs.getString(1).toUpperCase(), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allHoneys;
    }
}
