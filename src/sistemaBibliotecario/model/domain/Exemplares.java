package sistemaBibliotecario.model.domain;

import java.io.Serializable;

/**
 *
 * @author jones
 */
public class Exemplares implements Serializable{
    
    private String nome;
    private String descricao;
    private int cod_livro;
    private int qtd_livro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getCod_livro() {
        return cod_livro;
    }

    public void setCod_livro(int cod_livro) {
        this.cod_livro = cod_livro;
    }
    
    public int getQtd_livro() {
        return qtd_livro;
    }

    public void setQtd_livro(int qtd_livro) {
        this.qtd_livro = qtd_livro;
    }

   

    @Override
    public String toString() {
        return String.format("(Código do Livro: %d, Nome: %s, Descrição: %s, Qtd de Livros: %d)",
                cod_livro, nome, descricao, qtd_livro);
    }
}

