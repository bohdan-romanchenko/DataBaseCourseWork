package com.kpi.service;

import com.kpi.model.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyService {

    @Autowired
    Environment environment;

    @Autowired
    Connection connection;

    public List<Supply> getAll() {
        List<Supply> supplies = new ArrayList<Supply>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from SUPPLY");
            while (rs.next()) {
                Supply supply = new Supply();
                supply.setId(Long.parseLong(rs.getString("id")));
                supply.setBillDate(rs.getDate("bill_date"));
                supply.setBeetEstimated(Integer.parseInt(rs.getString("beet_supplied")));
                supply.setSugarEstimated(Integer.parseInt(rs.getString("sugar_estimated")));
                supply.setBagasseEstimated(Integer.parseInt(rs.getString("bagasse_estimated")));
                supply.setAgent(Long.parseLong(rs.getString("agent_id")));
                supplies.add(supply);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return supplies;
    }

    public Supply getById(Long id) {
        Supply supply = new Supply();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from SUPPLY where id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                supply.setId(Long.parseLong(rs.getString("id")));
                supply.setBillDate(rs.getDate("bill_date"));
                supply.setBeetEstimated(Integer.parseInt(rs.getString("beet_supplied")));
                supply.setSugarEstimated(Integer.parseInt(rs.getString("sugar_estimated")));
                supply.setBagasseEstimated(Integer.parseInt(rs.getString("bagasse_estimated")));
                supply.setAgent(Long.parseLong(rs.getString("agent_id")));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return supply;
    }

    public void update(Supply supply) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "update SUPPLY set bill_date=?, beet_supplied=?, sugar_estimated=?, bagasse_estimated=?, agent_id=? where id=?");

        preparedStatement.setDate(1, supply.getBillDate());
        preparedStatement.setInt(2, supply.getBeetEstimated());
        preparedStatement.setInt(3, supply.getSugarEstimated());
        preparedStatement.setInt(4, supply.getBagasseEstimated());
        preparedStatement.setLong(5, supply.getAgent());
        preparedStatement.setLong(6, supply.getId());
        preparedStatement.executeUpdate();
    }

    public void insert(Supply supply) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SUPPLY(id, bill_date, beet_supplied, sugar_estimated, bagasse_estimated, agent_id) " +
                        "VALUES (?,?,?,?,?,?)");

        preparedStatement.setLong(1, supply.getId());
        preparedStatement.setDate(2, supply.getBillDate());
        preparedStatement.setInt(3, supply.getBeetEstimated());
        preparedStatement.setInt(4, supply.getSugarEstimated());
        preparedStatement.setInt(5, supply.getBagasseEstimated());
        preparedStatement.setLong(6, supply.getAgent());
        preparedStatement.executeUpdate();
    }

    public void delete(Long id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from SUPPLY where id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }

    public Integer getMaxId() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT MAX(id) FROM SUPPLY");
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next())
            return rs.getInt("MAX(id)");
        else
            return null;
    }
}
