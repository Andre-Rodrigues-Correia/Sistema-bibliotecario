/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 * FXML Controller class
 *
 * @author jones
 */
public class Tela_CadastrarExemplarController implements Initializable {

    @FXML
    private TextField textField_cod_livro;
    @FXML
    private TextField textField_nome;
    @FXML
    private TextField textField_descricao;
    @FXML
    private TextField textField_qtd_livros;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Exemplares exemplares ;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage stage) {
        dialogStage = stage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmar) {
        buttonConfirmarClicked = buttonConfirmar;
    }

    public Exemplares getExemplares() {
        return exemplares;
    }

    public void setExemplares (Exemplares exemplares) {
        this.exemplares = exemplares;

        if(exemplares == null){
            textField_cod_livro.setEditable(false);
        }else{
            textField_cod_livro.setText((exemplares.getCod_livro()));
            textField_nome.setText(exemplares.getNome());
            textField_descricao.setText(exemplares.getDescricao());
            textField_qtd_livros.setText((exemplares.getQtd_livro()));
        }
}

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            exemplares.setNome(textField_nome.getText());
            exemplares.setCod_livro(textField_cod_livro.getInt());
            exemplares.setDescricao(textField_descricao.getText());
            exemplares.setQtd_livro(Integer.toString(textField_qtd_livros.getInt()));


            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    // Valida a entrada de dados
    public boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldNome.getText() == null ||
                textFieldNome.getText().length() == 0 ||
                textFieldNome.getText().length() >= 100) {
            errorMessage += "Nome inválido\n";
        }

        if (textFieldNascimento.getText() == null ||
                textFieldNascimento.getText().length() == 0
                || !Pattern.matches("((\\d){4}\\-(\\d){2}\\-(\\d){2})", textFieldNascimento.getText())) {
            errorMessage += "Data de Nascimento inválida\n";
        }

        if (textFieldCpf.getText() == null || textFieldCpf.getText().length() == 0
                || !Pattern.matches("((\\d){3}\\.(\\d){3}\\.(\\d){3}\\-(\\d){2})", textFieldCpf.getText())) {
            errorMessage += "CPF inválido\n";
        }

        if (textFieldCidade.getText() == null ||
                textFieldCidade.getText().length() == 0 ||
                textFieldCidade.getText().length() >= 100) {
            errorMessage += "Campo de cidade inválido\n";
        }

        if (textFieldUf.getText() == null || textFieldUf.getText().length() == 0 
                || textFieldUf.getText().length() != 2) {
            errorMessage += "Campo UF inválido\n";
        }

        if (errorMessage.equals("")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no Cadastro");
            alert.setHeaderText("Campos Inválidos, corrija ...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
}
