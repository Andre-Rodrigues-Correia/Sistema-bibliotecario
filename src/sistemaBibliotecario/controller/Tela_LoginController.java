/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaBibliotecario.model.domain.Usuario;
import sistemaBibliotecario.model.dao.UsuarioDAO;



/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela_LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextField TextField_Usuario;
    
    @FXML
    private TextField TextField_Senha;
    
    @FXML
    private Button bt_Entrar;
    
    @FXML
    private Button bt_Cadastrar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    public void handleSeletorOpcao() throws IOException {
       

        String user;
        String pass;
        
        user = TextField_Usuario.getText();
        pass = TextField_Senha.getText();
        
        
        if (user.equals("admin") && (pass.equals("admin"))){
            
            System.out.println("certo");
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela01_Opcao_Area.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Falha no login!");
            alert.setHeaderText("Senha ou Usuario incorretos!");
            //alert.setContentText("!");
            alert.show();
        }
        
        
        
    }
    
    /**/
    /*public void BotaoEntrar(){
        Tela01_Opcao_Area tl = new Tela01_Opcao_Area(); 

   */




}
       

        
    
