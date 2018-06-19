/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import passagens_aereas.Aeroporto;
/**
 *
 * @author JVict
 */
public class AeroportoCRUD {
    
      private Connection con = null;

    public AeroportoCRUD() {
        con = Conexao.getConexao();
    }
    
    //Insere novos usuaros ao banco
    public boolean inserir(Aeroporto aeroporto) {
        PreparedStatement stmt = null;
        
        //Comando sql de inserção 
        String sql = "INSERT INTO aeroporto (NOME, CIDADE, ESTADO) VALUES(?,?,?)";
        
        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setString(1, aeroporto.getNome());
            stmt.setString(2, aeroporto.getCidade());
            stmt.setString(3, aeroporto.getEstado());
            //Executa o Update
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //imprime o erro em vermelho no console
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            //fecha a conexão e o Statement
            Conexao.fecharConexao(con, stmt);
        }
    }
    
}
