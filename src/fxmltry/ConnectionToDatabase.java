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


class ConnectionToDatabase {
 private static String url="jdbc:mysql://localhost:3306/medical store ms";
private static String user="root";
private static String password="";
private static String driver="com.mysql.jdbc.Driver";
 Connection connMethod() throws ClassNotFoundException, SQLException{
   Class.forName(driver);
   Connection con=null;
  
   try{
        con=DriverManager.getConnection(url,user,password); 
      // String insertquery = "INSERT INTO 'dept_tb3'('SID','studId','Firstname','Lastname','Section','Department')values('4','NSR/004/14','Adane','Girma','SecA','CS')";
   

   }catch(SQLException e){
       
     JOptionPane.showMessageDialog(null, "Error :" +e); 
   }
 
   
   return con;



    }  
    
    
    
    
}
