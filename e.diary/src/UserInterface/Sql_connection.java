/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class Sql_connection {
     Connection con = null;
     
    
    public static void insertDatabaseData(int ID,String date, String word) {
        String sql = "INSERT INTO thought (ID,date,Thought) VALUES (?,?,?)";
 
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:thought.sqlite")) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1,ID);
            pstmt.setString(2,date);
            pstmt.setString(3, word);
            
            pstmt.executeUpdate();
            
            System.out.println("Data Inserted!");
            con.close();
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection Connect(){
        try{
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:thought.sqlite");
        System.out.println("connect to database");
        return con;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        return null;
        }
    }
    
}
