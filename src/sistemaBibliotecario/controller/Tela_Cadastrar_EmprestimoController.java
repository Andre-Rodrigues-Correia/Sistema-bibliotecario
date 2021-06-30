/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sistemaBibliotecario.model.dao.EmprestimoDAO;
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.domain.Emprestimo;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela_Cadastrar_EmprestimoController implements Initializable {
    
    //@FXML
    //private TextField textFieldCod_emprestimo;
    @FXML
    private TextField textFieldNome_livro_emprestado;
    @FXML
    private DatePicker textFieldData_emprestimo;
    @FXML
    private DatePicker textFieldData_devolucao;
    @FXML
    private TextField textFieldCpf_usuario;
    @FXML
    private TextField textFieldQtd_livros_emprestados;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void Cadastrar_exemplar() {
        
        EmprestimoDAO emprestimoDao = new EmprestimoDAO();
        
        
        String data_emprestimo = textFieldData_emprestimo.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        String data_devolucao = textFieldData_devolucao.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));

        
        
        Emprestimo emprestimo = new Emprestimo((textFieldNome_livro_emprestado.getText()),
                data_emprestimo, data_devolucao,textFieldCpf_usuario.getText());
        
        
              
            emprestimoDao.inserir(emprestimo);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de empréstimo!!");
            alert.setHeaderText("empréstimo cadastrado com sucesso");
            //alert.setContentText("!");
            alert.show();
            
            
    }
    
}
