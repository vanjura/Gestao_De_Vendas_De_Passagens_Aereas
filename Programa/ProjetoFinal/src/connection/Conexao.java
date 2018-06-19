/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author JVict
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_unicorn";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConexao() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de Conexão com o Banco!" + ex.getMessage());
        }
    }
    
    public static void fecharConexao(Connection con){
        
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
     }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt){
        
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
        
        fecharConexao(con);
     }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs){
        
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
        
        fecharConexao(con, stmt);
     }
}
