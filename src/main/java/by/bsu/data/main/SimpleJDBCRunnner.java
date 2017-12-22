package by.bsu.data.main;

import by.bsu.data.connect.ConnectorDB;
import by.bsu.data.subject.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleJDBCRunnner {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mariadb://localhost/test";
//        Properties prop = new Properties();
//        prop.put("user","root");
//        prop.put("password","root");

        Connection connection = null;
        DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        try{
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try{
                statement=connection.createStatement();
                ResultSet resultSet = null;
                try{
                    resultSet = statement.executeQuery("SELECT  * FROM Employees");
                    ArrayList<Abonent> list = new ArrayList<Abonent>();
                    while (resultSet.next()){
                        list.add(new Abonent(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(4)));

                    }
                    if (list.size()>0)
                        System.out.println(list);
                    else
                        System.out.println("Not Found");
                } finally {
                    if (resultSet !=null){
                        resultSet.close();
                    } else{
                        System.err.println("Error reading Database");
                    }
                }
            } finally {
                if (statement !=null){
                    statement.close();
                } else {
                    System.err.println("Statement not create");
                }
            }
        } catch (SQLException e){
            System.err.println("DB connection errro: "+e);
        } finally {
            if (connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    System.err.println("Connection close error: "+e);
                }
            }
        }
    }
}
