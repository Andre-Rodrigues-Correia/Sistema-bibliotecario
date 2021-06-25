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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


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
        String url = "/sistemaBibliotecario/view/Tela02_Cliente.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleAreaExemplar() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela03_Exemplar.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleAreaEmprestimo() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela04_Emprestimo.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }
    
}
