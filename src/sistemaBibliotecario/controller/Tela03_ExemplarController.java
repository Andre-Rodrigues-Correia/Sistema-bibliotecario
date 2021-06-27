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
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.database.Java_derby;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela03_ExemplarController implements Initializable {
    
    @FXML
    private Label labelCodigo;
    @FXML
    private Label labelLivro;
    @FXML
    private Label labelDescricao;
    @FXML
    private Label labelQtd_livros;
    @FXML
    private Button bt_Cadastrar_Exemplares;
    @FXML
    private Button bt_Remover_Exemplares;
    @FXML
    private TableView<Exemplares> tableViewExemplares;
    @FXML
    private TableColumn<Exemplares, String> tableColumnNome_Exemplares;
    @FXML
    private TableColumn<Exemplares, Integer> tableColumnCod_Exemplares;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;

    private List<Exemplares> listExemplares;
    private ObservableList<Exemplares> observableListExemplares;
    private ExemplarDAO exemplarDao = new ExemplarDAO();
    
    private final Java_derby java_derby = new Java_derby();
    private final Connection connection = java_derby.conectar();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exemplarDao.setConnection(connection);
        carregarTableViewExemplares();
    }

     public void carregarTableViewExemplares() {
        
        tableColumnNome_Exemplares.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCod_Exemplares.setCellValueFactory(new PropertyValueFactory<>("cod_livro"));
        
        listExemplares = exemplarDao.listar();
        
        observableListExemplares = FXCollections.observableArrayList(listExemplares);
        tableViewExemplares.setItems(observableListExemplares);
        
        tableViewExemplares.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemListView(newValue));
    }
    
    @FXML
    public void handleCadastrosExemplares() throws IOException {
       
        
        Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela_CadastrarExemplar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        //carregarTableViewExemplares();
    }
    
    
    @FXML
    public void selecionarItemListView(Exemplares exemplar){
    
        labelCodigo.setText(Integer.toString(exemplar.getCod_livro()));
        labelLivro.setText(exemplar.getNome());
        labelDescricao.setText(exemplar.getDescricao());
        labelQtd_livros.setText(Integer.toString(exemplar.getQtd_livro()));
    }
    
    public void removerExemplar(){
        
        
        Exemplares exemplar = tableViewExemplares.getSelectionModel().getSelectedItem();

        
            exemplarDao.remover(exemplar);
            carregarTableViewExemplares();
            
            
    }
    
}
