package sistemaBibliotecario.controller;

import java.io.IOException;
//import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //String dir = "../view/Tela01_Opcao_Area.fxml";
        Parent root = FXMLLoader.load(getClass().getResource("../view/Tela_Login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/sistemaBibliotecario/view/Tela01_Opcao_Area.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
       /*stage.setTitle("Sistema Bibliotecario");
        stage.setResizable(false);*/
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
