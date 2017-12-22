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

                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    System.out.println("Count of coloumn from table Employees = "+resultSetMetaData.getColumnCount());
                    System.out.println("getCatalogName represent database name = "+resultSetMetaData.getCatalogName(1));
                    System.out.println("getColumnName = "+resultSetMetaData.getColumnName(2));
                    System.out.println("getColumnType = "+resultSetMetaData.getColumnType(2));
                    System.out.println("getColumnClassName = "+resultSetMetaData.getColumnClassName(2));
                    System.out.println("getColumnLabel = "+resultSetMetaData.getColumnLabel(2));
                    System.out.println("getColumnTypeName = "+resultSetMetaData.getColumnTypeName(2));
                    System.out.println("getSchemaName = "+resultSetMetaData.getSchemaName(2));
                    System.out.println("getTableName = "+resultSetMetaData.getTableName(2));
                    System.out.println("getColumnDisplaySize = "+resultSetMetaData.getColumnDisplaySize(2));
                    System.out.println("getScale = "+resultSetMetaData.getScale(2));

                    DatabaseMetaData databaseMetaData = connection.getMetaData();
                    System.out.println("===============databaseMetaData================");
                    System.out.println("getURL = "+databaseMetaData.getURL());
                    System.out.println("getCatalogSeparator = "+databaseMetaData.getCatalogSeparator());
                    System.out.println("getCatalogTerm = "+databaseMetaData.getCatalogTerm());
                    System.out.println("getDatabaseProductName = "+databaseMetaData.getDatabaseProductName());
                    System.out.println("getDatabaseProductVersion = "+databaseMetaData.getDatabaseProductVersion());
                    System.out.println("getDriverName = "+databaseMetaData.getDriverName());
                    System.out.println("getDriverVersion = "+databaseMetaData.getDriverVersion());
                    System.out.println("getUserName ="+databaseMetaData.getUserName());


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
