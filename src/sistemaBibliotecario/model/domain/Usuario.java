
package sistemaBibliotecario.model.domain;

import java.io.Serializable;

/**
 *
 * @author jones
 */
public class Usuario implements Serializable{
    
    private String nome;
    private String senha;
    private int cod_usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

   

    @Override
    public String toString() {
        return String.format("(Código do Usuário: %d, Nome: %s, Senha: %s)",
                cod_usuario, nome, senha);
    }
}

