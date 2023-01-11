/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class passConnection {

      //Connection con=null;
      
      public static void insertDatabaseData(String pass) {
        String sql = "INSERT INTO pass (password) VALUES (?)";
 
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:pass.sqlite")) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,pass);
            pstmt.executeUpdate();
            
            System.out.println("pass word Inserted!");
            con.close();
           
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
      
      public static Connection Connect(){
          
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con=DriverManager.getConnection("jdbc:sqlite:pass.sqlite");
            System.out.println("connected");
            return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
            }
      }


}
