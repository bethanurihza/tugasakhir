/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Bethaa
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField ktp;
    @FXML
    private JFXTextField umur;
    @FXML
    private JFXTextField negara;
    @FXML
    private JFXRadioButton perempuan;
    @FXML
    private JFXRadioButton laki;
    @FXML
    private JFXTextField telfon;
    @FXML
    private JFXTextField days;
    @FXML
    private JFXDatePicker mulaimendaki;
    
    @FXML
    private JFXDatePicker selesaimendaki;
   
    @FXML
    private JFXTextField rekening;
    @FXML
    private TextArea hasil;
    @FXML
    private JFXButton reset;


    @FXML
    private JFXButton proses;
    @FXML
    private JFXButton back;
    @FXML
    private JFXTextField friend;
    @FXML
    private JFXButton check;
    @FXML
    private JFXButton out;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mulaimendaki.setValue(LocalDate.now());
        selesaimendaki.setValue(LocalDate.now());
    }    

    
   
        
        
        

    
    String gender;
    @FXML
    void tekanproses(ActionEvent event) {
        Connection connection = null;
        PreparedStatement betha;
        try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull", "root","");
         
            if(perempuan.isSelected()){
             gender = "Women";
         }
         else if(laki.isSelected()){
             gender = "Men";
         }
         else{
             gender="";
        }
           
           String sql = "INSERT INTO formbromo(id, nama, adress, ktp, region, phone, age, gender, Days, start, finish, friend, rekening) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
          betha=connection.prepareStatement(sql);
           betha.setString(1,"");
           betha.setString(2,name.getText());
           betha.setString(3,alamat.getText());
           betha.setString(4,ktp.getText());
           betha.setString(5,negara.getText());
           betha.setString(6,telfon.getText());
           betha.setString(7,umur.getText());
           betha.setString(8,gender);
           betha.setString(9,days.getText());
           betha.setString(10,mulaimendaki.getValue().toString() );
           betha.setString(11,selesaimendaki.getValue().toString() );
           betha.setString(12,friend.getText());
           betha.setString(13,rekening.getText());
           betha.executeUpdate();
           JOptionPane.showMessageDialog(null,"Data success");
           try{
               ((Node) (event.getSource())).getScene().getWindow().hide();
               
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("tugasakhir.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.setTitle("TNBTS");
               stage.show();
           
        }catch(Exception e){
           System.out.println ("Failed to create new data" + e);
        }
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
     @FXML
            
    void tekanreset(ActionEvent event) {
            name.setText("");
            alamat.setText("");
            ktp.setText("");
            negara.setText("");
            telfon.setText("");
            umur.setText("");
            days.setText("");
            friend.setText("");
            rekening.setText("");
            mulaimendaki.setValue(LocalDate.now());
            selesaimendaki.setValue(LocalDate.now());

            perempuan.setSelected(false);
            laki.setSelected(false);
            
    }

    @FXML
    private void tekanback(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("lanjut2.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void tekancheck(ActionEvent event) {
         String Nama = name.getText();
         String Alamat = alamat.getText();
         String KTP = ktp.getText();
         String Negara = negara.getText();
         String Telfon = telfon.getText();
         String Umur = umur.getText(); 
         String Days = days.getText();
         String Rekening = rekening.getText();
         String Start = mulaimendaki.getValue().toString();
         String Finish = selesaimendaki.getValue().toString();
         String Friend = friend.getText();
          if(perempuan.isSelected()){
             gender = "Women";
         }
         else if(laki.isSelected()){
             gender = "Men";
         }
         else{
             gender="";
        }
          
          if(Rekening.isEmpty() || Nama.isEmpty() || Alamat.isEmpty() || KTP.isEmpty() || Negara.isEmpty() || Telfon.isEmpty() || Umur.isEmpty() || Days.isEmpty()||  Start.isEmpty() || Finish.isEmpty() || gender.isEmpty()){
              JOptionPane.showMessageDialog(null,"Empty !!");
         }
                  
         hasil.setText("\nYour Data In Semeru:"+
                 
                 "\n\nName\t\t=" +Nama+
                 "\nAddres\t\t=" +Alamat+
                 "\nRegion\t\t= "+Negara+
                 "\nID / KTP number\t= " +KTP+
                 "\nPhone Number\t= "+Telfon+
                 "\nRekening Number\t= "+Rekening+
                 "\nAge\t\t\t= "+Umur+
                 "\nFriends\t\t= "+Friend+
                 "\nDays\t\t= "+Days+
                 "\nStart Hike\t= "+Start+
                 "\nFinish Hike\t= "+Finish+
                 "\nGender\t\t="+gender);

    }

    @FXML
    private void tekanlogout(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader=new FXMLLoader();
        
        fxmlLoader.setLocation(getClass().getResource("login.fxml"));
        Scene scene=new
        Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    }
    

    
    
