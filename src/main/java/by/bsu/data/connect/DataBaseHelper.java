package by.bsu.data.connect;

import by.bsu.data.subject.Abonent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;

public class DataBaseHelper {
    private final static String SQL_INSERT=
            "INSERT INTO Employees(id,age,last) values(?,?,?)";
    private Connection connection;

    public DataBaseHelper() throws SQLException {
        connection=ConnectorDB.getConnection();
    }
    public PreparedStatement getPreparedStatement(){
        PreparedStatement ps = null;
        try{
            ps=connection.prepareStatement(SQL_INSERT);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ps;
    }

    public boolean insertEmployee(PreparedStatement ps, Abonent ab){
        boolean flag = false;
        try{
            ps.setInt(1,ab.getId());
            ps.setInt(2,ab.getAge());
            ps.setString(3,ab.getLast());
            ps.executeUpdate();
            return flag;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public void closeStatement(PreparedStatement ps){
        if (ps != null){
            try{
                ps.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
