/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.model.database;

/**
 *
 * @author Andre
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java_derby{
    private Connection connection;
    
    public Connection conectar(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/BD_sistema_bibliotecario";
            String usuario = "aajw";
            String senha = "1234";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
            return this.connection;
        }
        catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Java_derby.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void desconectar(Connection connection){
        try{
            connection.close();
        }
        catch(SQLException ex){
            Logger.getLogger(Java_derby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}