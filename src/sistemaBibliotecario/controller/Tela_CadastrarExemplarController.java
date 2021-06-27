/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.domain.Exemplares;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import sistemaBibliotecario.model.database.Java_derby;
//import sistemaBibliotecario.model.database;
/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela_CadastrarExemplarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField textFieldCod_livro;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldDescricao;
    @FXML
    private TextField textFieldQtd_livros;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;
   
    //private Stage dialogStage;
    //private boolean buttonConfirmarClicked = false;
    //private Exemplares exemplar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    }
    
    @FXML
    public void Cadastrar_exemplar(){
        
        
        ExemplarDAO exemplaresDao = new ExemplarDAO();
        
        Exemplares exemplar = new Exemplares((Integer.parseInt(textFieldCod_livro.getText())),textFieldNome.getText(),
                    textFieldDescricao.getText(),(Integer.parseInt(textFieldQtd_livros.getText())));
              
            
            exemplaresDao.inserir(exemplar);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de cadastro!!");
            alert.setHeaderText("Livro cadastrado com sucesso");
            //alert.setContentText("!");
            alert.show();
            
            
    }
}
