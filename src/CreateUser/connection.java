
package CreateUser;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class connection {
    
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

    public Connection getconnMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    
    
}
