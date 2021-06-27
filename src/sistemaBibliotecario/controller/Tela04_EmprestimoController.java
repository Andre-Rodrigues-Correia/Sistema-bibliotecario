/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sistemaBibliotecario.model.dao.EmprestimoDAO;
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.database.Java_derby;
import sistemaBibliotecario.model.domain.Emprestimo;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela04_EmprestimoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label labelData_devolucao;
    @FXML
    private Label labelCodigo;
    @FXML
    private Label labelLivro;
    @FXML
    private Label labelCpf_usuario;
    @FXML
    private Label labelData_emprestimo;
    @FXML
    private TableView<Emprestimo> tableViewEmprestimos;
    @FXML
    private TableColumn<Emprestimo, Integer> tableColumnCod_emprestimo;
    @FXML
    private TableColumn<Emprestimo, String> tableColumnNome_livro_emprestimo;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    
    private List<Emprestimo> listEmprestimos;
    private ObservableList<Emprestimo> observableListEmprestimos;
    private EmprestimoDAO emprestimoDao = new EmprestimoDAO();
    
    private final Java_derby java_derby = new Java_derby();
    private final Connection connection = java_derby.conectar();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emprestimoDao.setConnection(connection);
        carregarTableViewEmprestimos();
    }    
    public void handleCadastrosEmprestimos() throws IOException {
       
         Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela_Cadastrar_Emprestimo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void carregarTableViewEmprestimos(){
        tableColumnCod_emprestimo.setCellValueFactory(new PropertyValueFactory<>("cod_emprestimo"));
        tableColumnNome_livro_emprestimo.setCellValueFactory(new PropertyValueFactory<>("nome_livro"));
        
        listEmprestimos = emprestimoDao.listar();

        observableListEmprestimos = FXCollections.observableArrayList(listEmprestimos);
        tableViewEmprestimos.setItems(observableListEmprestimos);
        
        tableViewEmprestimos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemListView(newValue));
    }
    
    public void removerEmprestimo(){
    Emprestimo emprestimo = tableViewEmprestimos.getSelectionModel().getSelectedItem();

        
            emprestimoDao.remover(emprestimo);
            carregarTableViewEmprestimos();
    
    }
    
    @FXML
    public void selecionarItemListView(Emprestimo emprestimo){
    
        labelCodigo.setText(Integer.toString(emprestimo.getCod_emprestimo()));
        labelLivro.setText(emprestimo.getNome_livro());
        labelCpf_usuario.setText(emprestimo.getCpf_cliente());
        labelData_emprestimo.setText(emprestimo.getData_emprestimo());
        labelData_devolucao.setText(emprestimo.getData_devolucao());
    }
}
