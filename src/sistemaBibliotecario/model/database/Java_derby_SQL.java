/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBibliotecario.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class Java_derby_SQL {
    private Connection connection;
    
    public Connection conectar(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String user = System.getenv("aajw");
            String password = System.getenv("1234");
            this.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/BD_sistema_bibliotecario", user, password);
            return this.connection;
        }
        catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Java_derby_SQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
