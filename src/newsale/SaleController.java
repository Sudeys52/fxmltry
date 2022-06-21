/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsale;

import home.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class SaleController implements Initializable {
    NewClass db = new NewClass();
 Connection con =null;
     int i = 0;
    PreparedStatement pst;
    ResultSet rs;
    Double prodTot;
    @FXML
    private Button addbtn;
    @FXML
    private Button backbtn;
    @FXML
    private Button exitbtn;
    @FXML
    private Button selectbtn;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtquantity;
    @FXML
    private TextField txtprice;
    @FXML
    private TextArea txtarea;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void add(ActionEvent event) {
     String name = txtname.getText();
        String price = txtquantity.getText();
        String quantity = txtprice.getText();
        if (name.equals("") && price.equals("") && quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "please fulfill the requirement!");
        } else {
            i++;
            prodTot = Double.valueOf(txtprice.getText()) * Double.valueOf(txtquantity.getText());
            if (i == 1) {
                txtarea.setText(txtarea.getText() + "*******DRUG ADED TO CART!!!*****\n\n" + "NUM PRODUCT   PRICE    QUANTITY   TOTAL\n" + i + "   "
                        + "     " + txtname.getText() + "     " + txtprice.getText() + "      " + txtquantity.getText() + "       " + prodTot + "\n");
            } else {

     txtarea.setText(txtarea.getText() + i + "      " + txtname.getText() + "             " + txtprice.getText() + "            " +txtquantity .getText() + "           " + prodTot + "\n");

            }
        }     
        
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
        
    }

    @FXML
    private void exit(ActionEvent event) {
         Stage stage = (Stage) exitbtn.getScene().getWindow();
        stage.close(); 
        
    }

    @FXML
    private void select(ActionEvent event) throws ClassNotFoundException {
    
           NewClass db = new NewClass();
        String name = txtname.getText();

        try {
            Connection con = db.connMethod();
            String sql = "select * from Product where Name ='" + name + "' ";
            ResultSet rs = con.createStatement().executeQuery(sql);

            if (rs.next()) {
                txtprice.setText(rs.getString("Price"));
               // txtquantity.setText(rs.getString("Quantity"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    }
    @FXML
    void Clear(ActionEvent event) {

        txtname.setText(null);
        txtquantity.setText(null);
        txtprice.setText(null);

    } 
}
