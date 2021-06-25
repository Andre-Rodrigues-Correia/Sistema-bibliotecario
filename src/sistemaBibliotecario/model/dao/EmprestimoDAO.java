
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
import sistemaBibliotecario.model.domain.Emprestimo;
/**
 *
 * @author jones
 */
public class EmprestimoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Emprestimo emprestimos) {
        String sql = "INSERT INTO emprestimos (cod_emprestimo, nome_livro_emprestado, cpf_cliente_emprestimo, data_emprestimo, data_devolucao, qtd_livros_emprestados) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, emprestimos.getCpf_cliente());
            stmt.setString(2, emprestimos.getNome_livro());
            stmt.setDate(3, (emprestimos.getData_emprestimo()));
            stmt.setDate(4, (emprestimos.getData_devolucao()));
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Emprestimo emprestimos) {
        String sql = "UPDATE emprestimos SET nome_livro_emprestado=?, cpf_cliente_emprestimo=?, data_emprestimo=?, data_devolucao=?, qtd_livros_emprestados=? WHERE cod_emprestimo=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, emprestimos.getNome_livro());
            stmt.setString(2, emprestimos.getCpf_cliente());
            stmt.setInt(3, emprestimos.getCod_emprestimo());
            stmt.setDate(4, (emprestimos.getData_emprestimo()));
            stmt.setDate(5, (emprestimos.getData_devolucao()));
            stmt.setInt(6, emprestimos.getQtd_livros());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Emprestimo emprestimos) {
        String sql = "DELETE FROM emprestimos WHERE cod_emprestimo=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, emprestimos.getCod_emprestimo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Emprestimo> listar() {
        String sql = "SELECT * FROM emprestimos;";
        List<Emprestimo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Emprestimo emprestimos = new Emprestimo();
                emprestimos.setCod_emprestimo(resultado.getInt("cod_emprestimo"));
                emprestimos.setNome_livro(resultado.getString("nome_livro_emprestado"));
                emprestimos.setCpf_cliente(resultado.getString("cpf_cliente_emprestimo"));
                emprestimos.setData_emprestimo(resultado.getDate("data_emprestimo"));
                emprestimos.setData_emprestimo(resultado.getDate("data_devolucao"));
                emprestimos.setQtd_livros(resultado.getInt("qtd_livros_emprestados"));
                retorno.add(emprestimos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Emprestimo buscar(Emprestimo emprestimos) {
        String sql = "SELECT * FROM emprestimos WHERE cod_emprestimo=?;";
        Emprestimo retorno = new Emprestimo();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, emprestimos.getCod_emprestimo());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                emprestimos.setNome_livro(resultado.getString("nome_livro_emprestado"));
                emprestimos.setCpf_cliente(resultado.getString("cpf_cliente_emprestimo"));
                emprestimos.setData_emprestimo(resultado.getDate("data_emprestimo"));
                emprestimos.setData_emprestimo(resultado.getDate("data_devolucao"));
                emprestimos.setQtd_livros(resultado.getInt("qtd_livros_emprestados"));
                retorno = emprestimos;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
