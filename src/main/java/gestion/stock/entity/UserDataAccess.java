package gestion.stock.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDataAccess {
    String db = "supermarche_db";
    String user = "root";
    String pwd = "";
    String url = "jdbc:mysql://localhost:3306/" + db;
    Connection connection = null;

    public UserDataAccess() {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user";

        try {
            pst = connection.prepareStatement(sql);
            System.out.println("Succes d'exec de la requete!!");
            rs = pst.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getLong("id")+" "+rs.getString("email")+" "+rs.getString("password")+" "+rs.getString("type"));
                list.add(new User(rs.getLong("id"),rs.getString("email"),rs.getString("password"),rs.getString("type")));
            }
        } catch(SQLException exp){
            System.out.println(exp.getMessage());
        }


        return list;


        }
    public List<User> getUserByType(String type ) {
        List<User> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE type LIKE ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,type+"%");
            System.out.println("Succes d'exec de la requete!!");
            rs = pst.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getLong("id")+" "+rs.getString("email")+" "+rs.getString("password")+" "+rs.getString("type"));
                list.add(new User(rs.getLong("id"),rs.getString("email"),rs.getString("password"),rs.getString("type")));
            }
        } catch(SQLException exp){
            System.out.println(exp.getMessage());
        }


        return list;


    }

}
