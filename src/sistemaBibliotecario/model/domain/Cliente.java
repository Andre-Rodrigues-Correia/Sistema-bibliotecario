
package sistemaBibliotecario.model.domain;

import java.io.Serializable;

/**
 *
 * @author jones
 */
public class Cliente implements Serializable{
    
    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    @Override
    public String toString() {
        return String.format("(CPF: %s, Nome: %s)",
                cpf, nome);
    }
}

