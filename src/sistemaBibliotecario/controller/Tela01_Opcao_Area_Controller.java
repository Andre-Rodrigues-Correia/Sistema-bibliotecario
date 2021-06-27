/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela01_Opcao_Area_Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView ImageView_Clientes;
    
    @FXML
    private ImageView ImageView_Exemplar;
    
    @FXML
    private ImageView ImageView_Emprestimo;
    
    
    @FXML
    private AnchorPane anchorPane;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    public void handleAreaCliente() throws IOException {
       
        Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela02_Cliente.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    public void handleAreaExemplar() throws IOException {
            
        Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela03_Exemplar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void handleAreaEmprestimo() throws IOException {
        Stage stage = new Stage();
                
        Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela04_Emprestimo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
