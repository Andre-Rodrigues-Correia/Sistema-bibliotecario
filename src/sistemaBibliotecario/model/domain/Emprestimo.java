
package sistemaBibliotecario.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jones
 */
public class Emprestimo implements Serializable{
    
    private String nome_livro;
    private String cpf_cliente;
    private int cod_emprestimo;
    private int qtd_livros;
    private Date data_emprestimo;
    private Date data_devolucao;

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    
    public int getCod_emprestimo() {
        return cod_emprestimo;
    }

    public void setCod_emprestimo(int cod_emprestimo) {
        this.cod_emprestimo = cod_emprestimo;
    }
    
    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }
    
    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    public int getQtd_livros() {
        return qtd_livros;
    }

    public void setQtd_livros(int qtd_livros) {
        this.qtd_livros = qtd_livros;
    }

   

    @Override
    public String toString() {
        return String.format("(Código do Emprestimo: %d, Nome do Livro: %s, CPF do Cliente: %s, data_emprestimo: %d, data_devolucao: %d)",
                cod_emprestimo, nome_livro, cpf_cliente, data_emprestimo, data_devolucao);
    }
}
