/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaBibliotecario.model.domain.Exemplares;

/**
 *
 * @author jones
 */
public class ExemplarDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Exemplares exemplares) {
        String sql = "INSERT INTO exemplares (cod_livro, nome_livro, descricao_livro, qtd_livros) VALUES (?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exemplares.getCod_livro());
            stmt.setString(2, exemplares.getNome());
            stmt.setString(3, exemplares.getDescricao());
            stmt.setInt(4, exemplares.getQtd_livro());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Exemplares exemplares) {
        String sql = "UPDATE cliente SET nome_livro=?, descricao_livro=?, qtd_livros=? WHERE cod_livro=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, exemplares.getNome());
            stmt.setString(2, exemplares.getDescricao());
            stmt.setInt(3, exemplares.getQtd_livro());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Exemplares exemplares) {
        String sql = "DELETE FROM exemplares WHERE cod_livro=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exemplares.getCod_livro());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Exemplares> listar() {
        String sql = "SELECT * FROM exemplares;";
        List<Exemplares> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Exemplares exemplares = new Exemplares();
                exemplares.setCod_livro(resultado.getInt("cod_livro"));
                exemplares.setNome(resultado.getString("nome_livro"));
                exemplares.setDescricao(resultado.getString("descricao_livro"));
                exemplares.setQtd_livro(resultado.getInt("qtd_livros"));
                retorno.add(exemplares);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Exemplares buscar(Exemplares exemplares) {
        String sql = "SELECT * FROM exemplares WHERE cod_livro=?;";
        Exemplares retorno = new Exemplares();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exemplares.getCod_livro());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                exemplares.setNome(resultado.getString("nome_livro"));
                exemplares.setDescricao(resultado.getString("descricao_livro"));
                exemplares.setQtd_livro(resultado.getInt("qtd_livros"));
                retorno = exemplares;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
