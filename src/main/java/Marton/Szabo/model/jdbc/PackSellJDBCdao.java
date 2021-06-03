package Marton.Szabo.model.jdbc;

import Marton.Szabo.model.dao.PackSellDao;
import Marton.Szabo.model.entity.Honey;
import Marton.Szabo.model.utility.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackSellJDBCdao implements PackSellDao {

    @Override
    public List<Honey> getAllHoneys() {
        List<Honey> allHoneys = new ArrayList<>();
        String SQL = "SELECT * FROM honey ORDER BY kind_of_honey, weight DESC";
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

    @Override
    public void packHoney(String kind, int weight, int quantity) {
        String SQL_QUERY = "SELECT quantity_packed FROM honey WHERE kind_of_honey = ? AND weight = ?";
        String SQL_UPDATE = "UPDATE honey SET quantity_packed = ? WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps1 = conn.prepareStatement(SQL_QUERY);
            ps1.setString(1, kind);
            ps1.setInt(2, weight);
            ResultSet rs = ps1.executeQuery();
            rs.next();
            int newPackedQuantity = rs.getInt(1) + quantity;

            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, newPackedQuantity);
            ps.setString(2, kind);
            ps.setInt(3, weight);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unpackHoney(String kind, int weight, int quantity) {
        String SQL_QUERY = "SELECT quantity_packed FROM honey WHERE kind_of_honey = ? AND weight = ?";
        String SQL_UPDATE = "UPDATE honey SET quantity_packed = ? WHERE kind_of_honey = ? AND weight = ?";
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps1 = conn.prepareStatement(SQL_QUERY);
            ps1.setString(1, kind);
            ps1.setInt(2, weight);
            ResultSet rs = ps1.executeQuery();
            rs.next();
            int newPackedQuantity = rs.getInt(1) - quantity;

            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, newPackedQuantity);
            ps.setString(2, kind);
            ps.setInt(3, weight);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
