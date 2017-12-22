package by.bsu.data.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException{
        //System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("database", Locale.ENGLISH);
        String url = bundle.getString("db.url");
        String user = bundle.getString("db.user");
        String pass = bundle.getString("db.password");
        return DriverManager.getConnection(url,user,pass);
    }
}
