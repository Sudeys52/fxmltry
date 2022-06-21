
package fxmltry;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class FXMLDocumentController implements Initializable {
NewClass cc = new NewClass();
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;
    @FXML
    private Label label;
    @FXML
    private TextField usertext;
    @FXML
    private TextField passtext;
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
         try {
            con = cc.connMethod();
            String sql = "SELECT username,password FROM login WHERE username=? AND password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usertext.getText());
            pst.setString(2, passtext.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
               // con.close();
                JOptionPane.showMessageDialog(null, "Welcome " + usertext.getText());
              
              
      
            } else {
                con.close();
                JOptionPane.showMessageDialog(null, "Please check your username and password and try again!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }  
   
               FXMLLoader fxmlLoader = new FXMLLoader(home.FXMLDocumentController.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
        
    
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
               FXMLLoader fxmlLoader = new FXMLLoader(home.FXMLDocumentController.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
        
    }
    
}
