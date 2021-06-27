
package sistemaBibliotecario.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
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
    
    public EmprestimoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/BD_sistema_bibliotecario";
            String usuario = "aajw";
            String senha = "1234";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean inserir(Emprestimo emprestimos) {
        String sql = "INSERT INTO emprestimos (nome_livro_emprestado, cpf_cliente_emprestimo, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //stmt.setInt(1, emprestimos.getCod_emprestimo());
            stmt.setString(1, emprestimos.getCpf_cliente());
            stmt.setString(2, emprestimos.getNome_livro());
            stmt.setString(3, (emprestimos.getData_emprestimo()));
            stmt.setString(4, (emprestimos.getData_devolucao()));
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Emprestimo emprestimos) {
        String sql = "DELETE FROM emprestimos WHERE cod_emprestimo=?";
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
        String sql = "SELECT * FROM emprestimos";
        List<Emprestimo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Emprestimo emprestimos = new Emprestimo();
                emprestimos.setCod_emprestimo(resultado.getInt("cod_emprestimo"));
                emprestimos.setNome_livro(resultado.getString("nome_livro_emprestado"));
                emprestimos.setCpf_cliente(resultado.getString("cpf_cliente_emprestimo"));
                emprestimos.setData_emprestimo(resultado.getString("data_emprestimo"));
                emprestimos.setData_devolucao(resultado.getString("data_devolucao"));
                //emprestimos.setQtd_livros(resultado.getInt("qtd_livros_emprestados"));
                retorno.add(emprestimos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
