/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package student.clearance.management;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class AdminController implements Initializable {
  
    @FXML
    private TextField Stud_name;

    @FXML
    private Button delete_btn;

    @FXML
    private TextField dep;

    @FXML
    private Button insert_btn;

    @FXML
    private TextField stud_id;

    @FXML
    private Button update_btn;
    
  
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
