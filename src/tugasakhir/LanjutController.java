/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bethaa
 */
public class LanjutController implements Initializable {

    @FXML
    private JFXButton get;
    @FXML
    private JFXButton back;

    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tekanget(ActionEvent event) throws IOException {
      
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("tugasakhirbromo.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void tekanback(ActionEvent event) throws IOException {
       
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("pilihan.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    }
    

