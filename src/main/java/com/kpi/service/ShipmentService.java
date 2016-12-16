package com.kpi.service;

import com.kpi.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    Environment environment;
    @Autowired
    Connection connection;

    public List<Shipment> getAll() {
        List<Shipment> shipments = new ArrayList<Shipment>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from SHIPMENT");
            while (rs.next()) {
                Shipment shipment = new Shipment();
                shipment.setId(Long.parseLong(rs.getString("id")));
                shipment.setBillDate(rs.getDate("bill_date"));
                shipment.setSugarShipped(Integer.parseInt(rs.getString("SUGAR_SHIPPED")));
                shipment.setBagasseShipped(Integer.parseInt(rs.getString("bagasse_shipped")));
                shipment.setSupply((long) Integer.parseInt(rs.getString("supply_id")));
                shipment.setAgent((long) Integer.parseInt(rs.getString("agent_id")));

                shipments.add(shipment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return shipments;
    }

    public Shipment getById(Long id) {
        Shipment shipment = new Shipment();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from SHIPMENT where id=?");
            preparedStatement.setString(1, id.toString());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                shipment.setId(Long.parseLong(rs.getString("id")));
                shipment.setBillDate(rs.getDate("bill_date"));
                shipment.setSugarShipped(Integer.parseInt(rs.getString("SUGAR_SHIPPED")));
                shipment.setBagasseShipped(Integer.parseInt(rs.getString("bagasse_shipped")));
                shipment.setSupply((long) Integer.parseInt(rs.getString("supply_id")));
                shipment.setAgent((long) Integer.parseInt(rs.getString("agent_id")));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return shipment;
    }

    public void update(Shipment shipment) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "update SHIPMENT set bill_date=?, sugar_shipped=?, bagasse_shipped=?, supply_id=?, agent_id=? where id=?");

        preparedStatement.setDate(1, shipment.getBillDate());
        preparedStatement.setInt(2, shipment.getSugarShipped());
        preparedStatement.setInt(3, shipment.getBagasseShipped());
        preparedStatement.setLong(4, shipment.getSupply());
        preparedStatement.setLong(5, shipment.getAgent());
        preparedStatement.setLong(6, shipment.getId());
        preparedStatement.executeUpdate();
    }

    public void insert(Shipment shipment) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SHIPMENT(id, bill_date, sugar_shipped, bagasse_shipped, supply_id, agent_id) " +
                        "VALUES (?,?,?,?,?,?)");

        preparedStatement.setLong(1, shipment.getId());
        preparedStatement.setDate(2, shipment.getBillDate());
        preparedStatement.setInt(3, shipment.getSugarShipped());
        preparedStatement.setInt(4, shipment.getBagasseShipped());
        preparedStatement.setLong(5, shipment.getSupply());
        preparedStatement.setLong(6, shipment.getAgent());
        preparedStatement.executeUpdate();
    }

    public void check(Shipment shipment) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "select id from SHIPMENT where id = " + shipment.getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next())
            update(shipment);
        else
            insert(shipment);

    }

    public void delete(Long id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from SHIPMENT where id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }

    public Integer getMaxId() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT MAX(id) FROM SHIPMENT");
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next())
            return rs.getInt("MAX(id)");
        else
            return null;
    }
}
