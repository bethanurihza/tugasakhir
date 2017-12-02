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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class loginController {

    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXButton login;

    @FXML
    private void tekansignup(ActionEvent event) throws IOException {
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("signup.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void tekanlogin(ActionEvent event) throws IOException {
        Connection connection;
        PreparedStatement st;
        try{
           connection = DriverManager.getConnection ("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull","root","");
           st = connection .prepareStatement("SELECT * FROM `daftar` WHERE `username` = ? AND `password` =  ? ");
           st.setString(1, username.getText());
           st.setString(2, password.getText());
           ResultSet result = st.executeQuery();
           if (result.next()) {
               
               JOptionPane.showMessageDialog(null,"Login success !!");
               ((Node) (event.getSource())).getScene().getWindow().hide();
               
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("pilihan.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.setTitle("TNBTS");
               stage.show();
               
            } else {
               JOptionPane.showMessageDialog(null,"Username and Password Wrong !!");
               username.setText("");
               username.requestFocus();
               password.setText("");
           }
           
        } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Failed !!");
               
           }
           
        }
    

    private void tekanlsignup(ActionEvent event) throws IOException{
        
       ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("signup.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    }

    
