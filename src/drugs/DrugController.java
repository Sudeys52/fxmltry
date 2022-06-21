/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

import CreateUser.connection;
import home.FXMLDocumentController;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class DrugController implements Initializable {
     
      NewClass nw = new NewClass();
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = null;
    @FXML
    private TextField txtpname;
    @FXML
    private TextField txtpcategory;
    @FXML
    private TextField txtquantity;
    @FXML
    private Button updatebtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button backbtn;
    @FXML
    private TableView<drug> table;
    @FXML
    private TableColumn<drug, String> colpname;
    @FXML
    private TableColumn<drug, String> colcategory;
    @FXML
    private TableColumn<drug, String> colquantity;
    
   
    @FXML
    private Button insertbtn;
    @FXML
   
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

      
    } 
    public ObservableList<drug> getdrugList() throws ClassNotFoundException, SQLException {
        ObservableList<drug> drugList = FXCollections.observableArrayList();
    
        NewClass nw = new NewClass();
          
            
       Connection con=null;
       String query = "SELECT * FROM products";
        con=nw.connMethod();
        Statement st;
        ResultSet rs;
        
        try{ 
      PreparedStatement pst = con.prepareStatement(query);
                        
            // rs  =  pst.execute();
           // st = conn.createStatement();
            rs = pst.executeQuery(query);
            drug drugs;
            while(rs.next()){
                drugs = new drug(rs.getString("P_Name"), rs.getString("p_Category"), rs.getInt("P_Quantity"));
                drugList.add(drugs);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return drugList;
    }
     
    public void showdrugs() throws ClassNotFoundException, SQLException{
        ObservableList<drug> list = getdrugList();
        
        colpname.setCellValueFactory(new PropertyValueFactory<drug, String>("P_Name"));
        colcategory.setCellValueFactory(new PropertyValueFactory<drug, String>("p_Category"));
        colquantity.setCellValueFactory(new PropertyValueFactory<drug, String>("P_Quantity"));
     
        
        table.setItems(list);
    }
//      private void insertRecord() throws ClassNotFoundException, SQLException{
//        String query = "INSERT INTO products VALUES (" + txtpname.getText() + ",'" + txtpcategory.getText() + "','" + txtquantity.getText() + ")";
//         
//       
//        showdrugs();
//    }
//    

   


    
    
  
          @FXML
    private void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        
           Connection con = null;
            NewClass nw = new NewClass();
              Statement st;
      
   try{
        con=nw.connMethod();
    String query = "UPDATE  products set p_Category = ?, P_Quantity=? where P_Name  = ? ";
           pst = con.prepareStatement(query);
          String category = txtpcategory.getText();
          String quantity = txtquantity.getText();
          String name = txtpname.getText();
          
           pst = con.prepareStatement(query);
       
           pst.setString(1, category);
            pst.setString(2, quantity);
          
            pst.setString(3, name);
            int i  =pst.executeUpdate();
            if(i==1){
            JOptionPane.showMessageDialog(null, "updated");
            }
            //showTable();
    }catch(Exception ex){
    
      ex.printStackTrace();
    } 

 showdrugs();
 cleardata();
        }   
    

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException, SQLException {
        Connection con = null;
            NewClass nw = new NewClass();
                Statement st;
      try{
           con=nw.connMethod();
      String query = "DELETE FROM products where P_Name =?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, txtpname.getText());
         pst.execute();
         //st = con.createStatement();
          //  st.executeUpdate(query);
     JOptionPane.showMessageDialog(null, "data deleted from table");
      
      }catch(Exception ex){
             ex.printStackTrace();
          
             
             
      } 
            showdrugs();
            cleardata();
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
    private void insert(ActionEvent event) throws ClassNotFoundException, SQLException   {
     Connection con = null;
            NewClass nw = new NewClass();
    
   
        try{ 
       
             con=nw.connMethod();
             String query = "INSERT INTO products VALUES('"+txtpname.getText()+"','"+txtpcategory.getText()+"','"+txtquantity.getText()+"')";
        PreparedStatement pst = con.prepareStatement(query);
                        
               pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "inserted");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        showdrugs();
        cleardata();
    
    }
  public void cleardata(){
  
      
         txtpname.setText("");
         txtpcategory.setText("");
         txtquantity.setText("");
     
  }


    }
