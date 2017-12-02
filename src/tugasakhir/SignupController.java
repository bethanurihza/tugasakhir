/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Bethaa
 */
public class SignupController {
  

    @FXML
    private JFXButton signup;
    String Nama, Email, Username, Password;

    @FXML
    private JFXPasswordField password;

   @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXButton login;

    
        

    

    
    
    
    @FXML
    void tekanlsignup(ActionEvent event) {
        Connection connection = null;
        PreparedStatement ps;
        try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull", "root","");
           String sql = "INSERT INTO daftar(Nama,Email,Username,Password) VALUES(?,?,?,?)";
           ps=connection.prepareStatement(sql);
           ps.setString(1,nama.getText());
           ps.setString(2,email.getText());
           ps.setString(3,username.getText());
           ps.setString(4,password.getText());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Data success");
           
           try{
               ((Node) (event.getSource())).getScene().getWindow().hide();
               
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("login.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.setTitle("TNBTS");
               stage.show();
               
           
        }catch(Exception e){
           System.out.println ("Failed to create new data" + e);
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
       
    
    
    @FXML
    void tekanlogin(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("login.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    
        
    
    
    public void initialize(URL url,ResourceBundle rb){
    }

   
    

   

    
        
    
}

