/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campanyreg;

import home.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class CampanyController implements Initializable {
  Database cc = new Database();
   PreparedStatement pst = null;
    ResultSet rs = null;
    Connection con = null;
    
    
    @FXML
    private Button updatebtn;
    @FXML
    private Button insertbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button backbtn;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtcountry;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtcno;
    private TextField txtaddress;
    @FXML
    private  TableView<NewClass> table;
    @FXML
    private TableColumn<NewClass, String> colcname;
    @FXML
    private TableColumn<NewClass, String> colcountry;
    @FXML
    private TableColumn<NewClass, String> colemail;
    @FXML
    private TableColumn<NewClass, Integer> colcno;
    @FXML
    private TableColumn<NewClass, String> coladdress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) {
                          Connection con = null;
    try{
        con=cc.connMethod();
    String query = "UPDATE  campany set Country = ?, E_Mail=?,C_No = ?, Address = ? where C_Name  = ? ";
           pst = con.prepareStatement(query);
          String country = txtcountry.getText();
          String email = txtemail.getText();
          String cno = txtcno.getText();
          String address = txtaddress.getText();
          String name = txtname.getText();
           pst = con.prepareStatement(query);
       
           pst.setString(1, country);
            pst.setString(2, email);
            pst.setString(3, cno);
             pst.setString(4, address);
            pst.setString(5, name);
            int i  =pst.executeUpdate();
            if(i==1){
            JOptionPane.showMessageDialog(null, "updated");
            }
            showTable();
    }catch(Exception ex){
    
      ex.printStackTrace();
    }
    }

    @FXML
    private void insert(ActionEvent event) {
        
                    Connection con = null;
        
       try{
           con = cc.connMethod();
         String query = "INSERT INTO campany VALUES ('" + txtname.getText() + "','" + txtcountry.getText() + "','" + txtemail.getText() + "','"
                + txtcno.getText() + "','" + txtaddress.getText() + "')";
       PreparedStatement pst = con.prepareStatement(query);
                        
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null, "inserted");
      
       
       }catch(Exception ex){
       
        ex.printStackTrace();
       } 
        showTable();     
    }  
        
    

    @FXML
    private void delete(ActionEvent event) {
             Connection con = null;
     try{
     con = cc.connMethod();
       String query = "DELETE FROM campany where C_Name ='" + txtname.getText() + "'";
       PreparedStatement pst = con.prepareStatement(query);
                        
               pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "deleted");
                
     }
     catch(Exception ex){
       ex.printStackTrace();
     
     }   
          showTable();   
    }

    @FXML
    private void back(ActionEvent event) throws IOException  {
           FXMLLoader fxmlLoader = new FXMLLoader(FXMLDocumentController.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
    }
 
      public ObservableList<NewClass> getTableList(){
        ObservableList<NewClass> tableList = FXCollections.observableArrayList();
       
         Database cc = new Database();
         
     
         ResultSet rs;
        
        
        try{
              Statement st;
            
            con =cc.connMethod();
             String query = "SELECT * FROM campany";
           rs = con.createStatement().executeQuery(query);
         
        
            NewClass tables;
            while(rs.next()){
                tables = new NewClass(rs.getString("C_Name"), rs.getString("Country"), rs.getString("E_Mail"), rs.getInt("C_No"),rs.getString("Address"));
                tableList.add(tables);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return tableList;
    }
    
    public void showTable(){
        ObservableList<NewClass> list = getTableList();
       
         
     colcname.setCellValueFactory( new PropertyValueFactory<NewClass,String>("C_Name "));
        colcountry.setCellValueFactory(new PropertyValueFactory<NewClass, String>("Country"));
        colemail.setCellValueFactory(new PropertyValueFactory<NewClass, String>("E_Mail"));
        colcno.setCellValueFactory(new PropertyValueFactory<NewClass, Integer>("C_No"));
        coladdress.setCellValueFactory(new PropertyValueFactory<NewClass, String>("Address"));
        
        table.setItems(list);    
        
    }


}
