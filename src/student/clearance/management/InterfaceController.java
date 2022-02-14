/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package student.clearance.management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author wku-cslab1
 */
public class InterfaceController implements Initializable {

    @FXML
    private RadioButton adminRadio;

    @FXML
    private PasswordField id;

    @FXML
    private Button login_btn;

    @FXML
    private RadioButton staffRadio;

    @FXML
    private RadioButton studRadio;

    @FXML
    private ToggleGroup type;
    @FXML
    private TextField username;

    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;
    String sql;

    @FXML
    public void login(ActionEvent event) throws Exception {
System.out.println("here....");
        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();

        if (studRadio.isSelected()) {
            sql = "SELECT * FROM student WHERE name = '"+username.getText()+"' and id = '"+id.getText()+"'";
        } else if (adminRadio.isSelected()) {
            sql = "SELECT * FROM admin WHERE name = '"+username.getText()+"' and password = '"+id.getText()+"'";
        } else if (staffRadio.isSelected()) {
            sql = "SELECT * FROM staff WHERE name = '"+username.getText()+"' and password = '"+id.getText()+"'";
        }
        System.out.println("here....");
        try {
            result = conn.createStatement().executeQuery(sql);

            while (result.next()) {
                System.out.println("here....");
                if (studRadio.isSelected()) {
                    System.out.println("here....");
                    FXMLLoader fxmlLoader = new FXMLLoader(StudController.class.getResource("Stud.fxml"));
System.out.println("here....");
                    if ((username.getText().equals(result.getString(1))) && (id.getText().equals(result.getString(2)))) {

                        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();
                    }
                } else if (adminRadio.isSelected()) {
                    FXMLLoader fxmlLoader = new FXMLLoader(AdminController.class.getResource("Admin.fxml"));
                    if ((username.getText().equals(result.getString(1))) && (id.getText().equals(result.getString(2)))) {

                        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();
                    }
                } else if (staffRadio.isSelected()) {
                    FXMLLoader fxmlLoader = new FXMLLoader(StaffController.class.getResource("Staff.fxml"));
                    if ((username.getText().equals(result.getString(1))) && (id.getText().equals(result.getString(2)))) {

                        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
