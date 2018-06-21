/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import passagens_aereas.Rota;

/**
 *
 * @author lucas_nuze0yo
 */
public class RotaCRUD {

    private Connection con = null;

    public RotaCRUD() {
        con = Conexao.getConexao();
    }

    public boolean inserir(Rota rota) {
        PreparedStatement stmt = null;

        //Comando sql de inserção 
        String sql = "insert into rota (origem, destino, duracao, preco_c, preco_e) VALUES(?,?,?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setInt(1, rota.getOrigem());
            stmt.setInt(2, rota.getDestino());
            stmt.setString(3, rota.getDuracao());
            stmt.setFloat(4, rota.getPreco_c());
            stmt.setFloat(5, rota.getPreco_e());
            
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
