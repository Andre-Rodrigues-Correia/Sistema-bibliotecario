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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaBibliotecario.model.dao.ExemplarDAO;
import sistemaBibliotecario.model.database.Java_derby_SQL;
import sistemaBibliotecario.model.domain.Cliente;
import sistemaBibliotecario.model.domain.Exemplares;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela03_ExemplarController implements Initializable {

    @FXML
    private TableView<Exemplares> tableView_listar_exemplares;
 
    @FXML
    private Label label_codigo_livro;
    
    @FXML
    private Label label_nome_livro;
    
    @FXML
    private Label label_descricao_livro;
    
    @FXML
    private Label label_qtd_livro;
    
    @FXML
    private TableColumn<Exemplares, Integer> table_collum_codigo_livro;
    @FXML
    private TableColumn<Exemplares, String> table_column_nome_livro;
    @FXML
    private TableColumn<Exemplares, String> table_column_descricao_livro;
    @FXML
    private TableColumn<Exemplares, Integer> table_column_quantidade_livro;


    private List<Exemplares> listaExemplares;
    private ObservableList<Exemplares> observableListExemplares;
    
    
    private final Java_derby_SQL java_derby = new Java_derby_SQL();
    private final Connection connection = java_derby.conectar();
    private ExemplarDAO exemplarDao = new ExemplarDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        exemplarDao.setConnection(connection);
        carregar_exemplares();
    }    

    public void carregar_exemplares() {
        
        table_collum_codigo_livro.setCellFactory(new PropertyValueFactory<>("codigo_livro"));
        table_column_nome_livro.setCellFactory(new PropertyValueFactory<>("nome_livro"));
        table_column_descricao_livro.setCellFactory(new PropertyValueFactory<>("descricao_livro"));
        table_column_quantidade_livro.setCellFactory(new PropertyValueFactory<>("qtd_livros"));
        
        listaExemplares = exemplarDao.listar();
        
        observableListExemplares = FXCollections.observableArrayList(listaExemplares);
        tableView_listar_exemplares.setItems(observableListExemplares);
        
    }
    
    public void mostrar_tela_cadastro(Exemplares exemplares) throws IOException{
        // Carrega o fxml ClientesDialog
        FXMLLoader loader = new FXMLLoader();
        String url = "/sistemaBibliotecario/view/Tela_CadastrarExemplar.fxml";
        loader.setLocation(Tela_CadastrarExemplarController.class.getResource(url));
        AnchorPane page = (AnchorPane) loader.load();

        // Cria uma cena com ClientesDialog
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastros de exemplares");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Define o dialogStage e o cliente
        Tela03_ExemplarController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setExemplares(exemplares);

        // Mostra o ClientesDialog e espera
        dialogStage.showAndWait();

        // Retorna true se o botao confirmar for clicado
        return controller.isButtonConfirmarClicked();
    }
    
    @FXML
    public void Botao_inserir() throws IOException {
        Exemplares exemplares = new Exemplares();

        // Obtem verdadeiro se o cliente for inserido
        boolean buttonConfirmarClicked = showCadastrosClientesDialog(exemplares);
        if (buttonConfirmarClicked) {
            // Insere o cliente no banco de dados
            ExemplarDAO.inserir(exemplares);
            // Recarrega os dados do cliente
            carregar_exemplares();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();

        if (cliente != null) {
            boolean buttonConfirmarClicked = showCadastrosClientesDialog(cliente);

            if (buttonConfirmarClicked) {
                clienteDao.alterar(cliente);
                carregarTableViewCliente();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, selecione um cliente ...");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();

        if (cliente != null) {
            clienteDao.remover(cliente);
            carregarTableViewCliente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, selecione um cliente ...");
            alert.show();
        }
    }
}
