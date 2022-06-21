/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import CreateUser.CreateUser;
import CreateUser.UserController;
import campanyreg.CampanyController;

import category.FXMLController;

import drugs.DrugController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import newsale.SaleController;


/**
 *
 * @author wku-cslab1
 */
public class FXMLDocumentController implements Initializable {


    
    @FXML
    private Button DRGBTN;
    @FXML
    private Button CAMPBTN;
    @FXML
    private Button USERBTN;
    @FXML
    private Button CATBTN;
    @FXML
    private Button LOGINBTN;
    @FXML
    private ImageView IMAGE;
    @FXML
    private Button SALEREBTN;
    @FXML
    private Button SALEBTN;

    
    @Override
    public void initialize(URL url, ResourceBundle rb)   {
        // TODO
    }    

    @FXML
    private void DRUG(ActionEvent event) throws IOException ,   RuntimeException{
      FXMLLoader fxmlLoader = new FXMLLoader(DrugController.class.getResource("drug.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
  
        
    }

    @FXML
    private void CAMPANY(ActionEvent event) throws IOException,RuntimeException {
                 FXMLLoader fxmlLoader = new FXMLLoader(CampanyController.class.getResource("campany.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
          
        
    }

    @FXML
    private void USER(ActionEvent event) throws IOException,RuntimeException {
       FXMLLoader fxmlLoader = new FXMLLoader(UserController.class.getResource("user.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
 
           
        
        
    }

    @FXML
    private void CATEGORY(ActionEvent event) throws IOException {
              FXMLLoader fxmlLoader = new FXMLLoader(FXMLController.class.getResource("category.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
 
    }

    @FXML
    private void LOGIN(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("fxmltry/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();   
        
        
    }

  
    @FXML
    private void salerecords(ActionEvent event) throws IOException  {
       
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("SALERECORD.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
 
    
        
    }

    @FXML
    private void sale(ActionEvent event) throws IOException {
               FXMLLoader fxmlLoader = new FXMLLoader(SaleController.class.getResource("sale.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
      
        
        
        
    }
    
}
