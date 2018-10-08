/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 04014985229
 */
public class MenuController implements Initializable {

    @FXML
    private MenuItem btnhistorico;
    @FXML
    private MenuItem btncalculadora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void historico(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("listagemHistorico.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),530,326);
        Stage stage = new Stage();
        stage.setTitle("Historico");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void calculadora(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("TelaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),320,320);
        Stage stage = new Stage();
        stage.setTitle("TelaPrincipal");
        stage.setScene(scene);
        stage.show();
    }
    
}
