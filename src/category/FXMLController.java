/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import home.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField TXTCATEGORY;
    @FXML
    private AnchorPane bacbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical store ms", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    @FXML
    private void ADD(ActionEvent event) throws IOException {
        
        
        Connection con=null;
            connection db =new connection();
   
        try{ con=db.connMethod();
             String query = "INSERT INTO category VALUES('"+TXTCATEGORY.getText()+"')";
        PreparedStatement pst = con.prepareStatement(query);
                        
               pst.execute();
            JOptionPane.showMessageDialog(null, "category aded");
        }catch(Exception ex){
            ex.printStackTrace();
        }
             TXTCATEGORY.setText("");
              FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController .class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
    }

    @FXML
    private void back(ActionEvent event) throws IOException  {
             FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController .class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
           
        
    }
    
    
}
