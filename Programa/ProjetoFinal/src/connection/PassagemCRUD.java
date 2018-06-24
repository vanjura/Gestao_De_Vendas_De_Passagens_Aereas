/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import passagens_aereas.Passagem;

/**
 *
 * @author lucas
 */
public class PassagemCRUD {
    private Connection con = null;

    public PassagemCRUD() {
        con = Conexao.getConexao();
    }
    
    public boolean inserir(Passagem passagem) {
        PreparedStatement stmt = null;
        String sql = "insert into passagem (tipo, origem, destino, data) VALUES(?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, passagem.getTipo());
            stmt.setString(2, passagem.getOrigem());
            stmt.setString(3, passagem.getDestino());
            stmt.setDate(3, passagem.getData());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
}
