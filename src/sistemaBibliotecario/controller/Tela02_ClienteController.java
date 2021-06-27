/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemaBibliotecario.model.dao.ClienteDAO;
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.database.Java_derby;
import sistemaBibliotecario.model.domain.Cliente;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 * FXML Controller class
 *
 * @author jones
 */

    

public class Tela02_ClienteController implements Initializable {

    @FXML
    private Label LabelSistema;
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Exemplares, String> tableColumnNome_cliente;
    @FXML
    private TableColumn<Exemplares, Integer> tableColumnCpf_cliente;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private TextField TextFiledNome;
    @FXML
    private TextField TextFiledCpf;

    private List<Cliente> listClientes;
    private ObservableList<Cliente> observableListClientes;
    private ClienteDAO clienteDao = new ClienteDAO();
    
    private final Java_derby java_derby = new Java_derby();
    private final Connection connection = java_derby.conectar();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewClientes();
    }    
    
    public void removerCliente(){
    Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();

        
            clienteDao.remover(cliente);
            carregarTableViewClientes();
    
    }
    
    public void carregarTableViewClientes() {
        
        tableColumnNome_cliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCpf_cliente.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        listClientes = clienteDao.listar();

        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewClientes.setItems(observableListClientes);
    }
    
    public void Cadastrar_cliente() {
        
        
        Cliente cliente = new Cliente(TextFiledNome.getText(), TextFiledCpf.getText());
              
            
            clienteDao.inserir(cliente);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de cadastro!!");
            alert.setHeaderText("Cliente cadastrado com sucesso");
            //alert.setContentText("!");
            alert.show();
            
            carregarTableViewClientes();
    }
}
