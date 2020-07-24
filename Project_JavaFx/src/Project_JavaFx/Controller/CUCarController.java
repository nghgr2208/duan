/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import com.sun.javafx.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author lehie
 */
public class CUCarController {
    private Car CreateCar = null;
    
    @FXML
    private TextField txtCarName;

    @FXML
    private TextField txtPrice;

    @FXML
    private ComboBox<String> cbxBrand;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cbxCategor;

    @FXML
    private ComboBox<String> cbxFuel;

    @FXML
    private ComboBox<String> cbxColor;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtSku;

    @FXML
    private ComboBox<Integer> cbxSeat;

    @FXML
    private ComboBox<String> cbxGear;


    @FXML
    void cbxBrand(ActionEvent event) {

    }

    @FXML
    void cbxCategor(ActionEvent event) {

    }

    @FXML
    void cbxColor(ActionEvent event) {

    }

    @FXML
    void cbxFuel(ActionEvent event) {

    }

    @FXML
    void cbxGear(ActionEvent event) {

    }

    @FXML
    void cbxSeat(ActionEvent event) {

    }

    @FXML
    void txtCarName(ActionEvent event) {

    }

    @FXML
    void txtPrice(ActionEvent event) {

    }

    @FXML
    void txtSku(ActionEvent event) {

    }

    @FXML
    void txtYear(ActionEvent event) {

    }

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }
    @FXML
    void btnSave(ActionEvent event) throws  SQLException{
       Car insertCar = extractCarFromField();
           insertCar = Car.insert(insertCar);
         
        
    }
    final ObservableList<String> options = FXCollections.observableArrayList("HANoi","HCM");
    public void intialize(URL location, ResourceBundle resource){
        cbxBrand.setItems(options);
    }
    
//    public void fillcomboBox(){
//        String sql = "INSERT into car(sku,carName, brand, categoryName, yearOfManufacture, gear, color, price, seat, fuelUsed)";
//        try {
//             Connection conn = DbService.getConnection();
//             PreparedStatement pst = conn.prepareStatement(sql);
//             ResultSet rs = pst.executeQuery(); 
//               
//            while (rs.next()) {
//                options.add(rs.getString("brand"));
//                
//            }
//                        
//        } catch (Exception e) {
//            
//          
//        }
//    }
    private Car extractCarFromField(){
        Car car = new Car();
        car.setSku(txtSku.getText());
        car.setCarName(txtCarName.getText());
        car.setBrand(cbxBrand.getValue());
        car.setCategory(cbxCategor.getValue());
        car.setSeat(cbxSeat.getValue());
        car.setFuelUsed(cbxFuel.getValue());
        car.setYearOfManufacture(Integer.parseInt(txtYear.getText()));
        car.setColor(cbxColor.getValue());        
        car.setGear(cbxGear.getValue());
        car.setPrice(Integer.parseInt(txtPrice.getText()));
        
        return car;
        
    }
    
    public void initialize(Car editCar){
        this.CreateCar = editCar;
        String msg = "";
        if(this.CreateCar == null){
            msg = "Create a new Car";
            
        }else{
           msg = "Update  an existing car";
           txtSku.setText(CreateCar.getSku());
           txtCarName.setText(CreateCar.getCarName());
           txtYear.setText(Integer.toString(CreateCar.getYearOfManufacture()));
           cbxBrand.setValue(CreateCar.getBrand());
           cbxCategor.setValue(CreateCar.getCategory());
           cbxColor.setValue(CreateCar.getColor());
           cbxSeat.setValue(CreateCar.getSeat());
           cbxGear.setValue(CreateCar.getGear());
           cbxFuel.setValue(CreateCar.getFuelUsed());
           txtPrice.setText(Integer.toString(CreateCar.getPrice()));
           
        }
    }

   
    
}
