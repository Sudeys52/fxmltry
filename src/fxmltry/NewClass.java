/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wku-cslab1
 */
public class NewClass {
                private static String url="jdbc:mysql://localhost:3306/medical store ms";
private static String user="root";
private static String password="";
private static String driver="com.mysql.jdbc.Driver";
 Connection connMethod() throws ClassNotFoundException, SQLException{
   Class.forName(driver);
   Connection con=null;
  
   try{
        con=DriverManager.getConnection(url,user,password); 
             
     JOptionPane.showMessageDialog(null, "connected!!!" ); 
   

   }catch(SQLException e){
       
     JOptionPane.showMessageDialog(null, "Error :" +e); 
   }
 
   
   return con;



    }
}
