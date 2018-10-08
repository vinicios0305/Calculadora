/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 *
 * @author 01118108256
 */
public class TelaPrincipalController implements Initializable {
    
    @FXML
    private Label lblNumero1;
    
    @FXML
    private TextField txtNumero1;
    
    @FXML
    private Label lblNumero2;
    
    @FXML
    private TextField txtNumero2;
    
    
    @FXML
    private Label lblResultado;
    
    @FXML
    private TextField txtResultado;
    @FXML
    private Label label;
    @FXML
    private Button btnSomar;
    @FXML
    private Button btnhistorico;
    @FXML
    private Button bntmenu;
    
    @FXML
    private void somar(ActionEvent event) {
        Double num1, num2,rslt;
        num1 = Double.parseDouble(txtNumero1.getText());
        num2 = Double.parseDouble(txtNumero2.getText());
        rslt = num1 + num2;
        txtResultado.setText(rslt.toString()); 
        
        gravar("+");
        
        
    }
    
    private void gravar(String operador) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        Historico calc = new Historico();
        
        calc.setNumero1(txtNumero1.getText());
        calc.setNumero2(txtNumero2.getText());
        calc.setResultado(txtResultado.getText());
        //setOperador
        calc.setOperador(operador);
        
         em.getTransaction().begin();
        em.persist(calc);
        em.getTransaction().commit();
    }
    
    @FXML
    private void dividir(ActionEvent event) {
        Double num1, num2,rslt;
        num1 = Double.parseDouble(txtNumero1.getText());
        num2 = Double.parseDouble(txtNumero2.getText());
        rslt = num1 / num2;
        txtResultado.setText(rslt.toString()); 
        
          gravar("/");
    }
    
    @FXML
    private void subtrair(ActionEvent event) {
        Double num1, num2,rslt;
        num1 = Double.parseDouble(txtNumero1.getText());
        num2 = Double.parseDouble(txtNumero2.getText());
        rslt = num1 - num2;
        txtResultado.setText(rslt.toString()); 
                  gravar("-");
    }
    
    @FXML
    private void multiplicar (ActionEvent event) {
        Double num1, num2,rslt;
        num1 = Double.parseDouble(txtNumero1.getText());
        num2 = Double.parseDouble(txtNumero2.getText());
        rslt = num1 * num2;
        txtResultado.setText(rslt.toString()); 
                  gravar("*");
    }
    
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
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),530,326);
        Stage stage = new Stage();
        stage.setTitle("Historico");
        stage.setScene(scene);
        stage.show();
    }

}
