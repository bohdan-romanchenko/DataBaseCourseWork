package com.kpi.service;

import com.kpi.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {

    @Autowired
    Environment environment;
    @Autowired
    Connection connection;

    public List<Agent> getAll() {
        List<Agent> agents = new ArrayList<Agent>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from AGENT");
            while (rs.next()) {
                Agent agent = new Agent();
                agent.setId((long) Integer.parseInt(rs.getString("id")));
                agent.setName(rs.getString("name"));
                agent.setAddress(rs.getString("address"));
                agent.setBankDetails(rs.getString("bank_details"));
                agent.setRestSugar(rs.getInt("rest_sugar"));
                agent.setRestBagasse(rs.getInt("rest_bagasse"));
                agents.add(agent);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return agents;
    }

    public Agent getById(Integer id) {
        Agent agent = new Agent();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from AGENT where id=?");
            preparedStatement.setString(1, id.toString());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                agent.setId((long) Integer.parseInt(rs.getString("id")));
                agent.setName(rs.getString("name"));
                agent.setAddress(rs.getString("address"));
                agent.setBankDetails(rs.getString("bank_details"));
                agent.setRestSugar(rs.getInt("rest_sugar"));
                agent.setRestBagasse(rs.getInt("rest_bagasse"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return agent;
    }

    public void update(Agent agent) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "update AGENT set name=?, address=?, bank_details=?, rest_sugar=?, rest_bagasse=? where id=?");

        preparedStatement.setString(1, agent.getName());
        preparedStatement.setString(2, agent.getAddress());
        preparedStatement.setString(3, agent.getBankDetails());
        preparedStatement.setInt(4, agent.getRestSugar());
        preparedStatement.setInt(5, agent.getRestBagasse());
        preparedStatement.setLong(6, agent.getId());
        preparedStatement.executeUpdate();
    }

    public void insert(Agent agent) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO AGENT(id, name, address, bank_details, rest_sugar, rest_bagasse) " +
                        "VALUES (?,?,?,?,?,?)");

        preparedStatement.setLong(1, agent.getId());
        preparedStatement.setString(2, agent.getName());
        preparedStatement.setString(3, agent.getAddress());
        preparedStatement.setString(4, agent.getBankDetails());
        preparedStatement.setInt(5, agent.getRestSugar());
        preparedStatement.setInt(6, agent.getRestBagasse());
        preparedStatement.executeUpdate();
    }

    public void delete(Integer id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from AGENT where id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }

    public Long getMaxId() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT MAX(id) FROM AGENT");
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next())
            return rs.getLong("MAX(id)");
        else
            return null;
    }
}
