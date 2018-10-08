/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 04014985229
 */
public class ListagemHistoricoController implements Initializable {

    @FXML
    private TableView<?> tbhistorico;
    @FXML
    private Button btnvoltar;
    @FXML
    private AnchorPane ac;
    @FXML
    private Button btnmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Historico as a");
        List<Historico> historico = query.getResultList();
        ObservableList oAlunos = FXCollections.observableArrayList(historico);                                 
        tbhistorico.setItems(oAlunos);
      
    
}

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("TelaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),320,320);
        Stage stage = new Stage();
        stage.setTitle("Tela Principal");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,291);
        Stage stage = new Stage();
        stage.setTitle("TelaPrincipal");
        stage.setScene(scene);
        stage.show();
    }

    
}
