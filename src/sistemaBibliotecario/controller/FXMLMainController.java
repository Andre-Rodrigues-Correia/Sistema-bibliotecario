package sistemaBibliotecario.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FXMLMainController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleTela_Login() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela_Login.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleSeletorOpcao() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela01_Opcao_Area.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
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

    @FXML
    public void handleCadastrosExemplares() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela_CadastrarExemplar.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleCadastrosEmprestimos() throws IOException {
        String url = "/sistemaBibliotecario/view/Tela_Cadastrar_Emprestimo.fxml";
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        anchorPane.getChildren().setAll(a);
    }
}
