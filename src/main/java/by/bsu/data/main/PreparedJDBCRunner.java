package by.bsu.data.main;

import by.bsu.data.connect.DataBaseHelper;
import by.bsu.data.subject.Abonent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparedJDBCRunner {
    public static void main(String[] args) {
        ArrayList<Abonent> list = new ArrayList<Abonent>(){
            {
                add(new Abonent(176,34,"Myrzakanova"));
                add(new Abonent(177,35,"Myrzakanov"));
            }
        };

        DataBaseHelper helper =null;
        PreparedStatement statement = null;
        try{
            helper=new DataBaseHelper();
            statement=helper.getPreparedStatement();
            for (Abonent abonent:
                 list) {
                helper.insertEmployee(statement,abonent);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            helper.closeStatement(statement);
        }
    }
}
