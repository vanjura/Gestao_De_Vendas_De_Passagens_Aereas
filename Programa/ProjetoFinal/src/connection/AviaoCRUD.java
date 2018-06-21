/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import passagens_aereas.Aviao;

/**
 *
 * @author lucas_nuze0yo
 */
public class AviaoCRUD {

    private Connection con = null;

    public AviaoCRUD() {
        con = Conexao.getConexao();
    }

    public boolean inserir(Aviao aviao) {
        PreparedStatement stmt = null;

        //Comando sql de inserção 
        String sql = "INSERT INTO AVIAO (registro, modelo, qtd_assentos, qtd_assentos_esp) VALUES(?,?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setString(1, aviao.getRegistro());
            stmt.setString(2, aviao.getRegistro());
            stmt.setInt(3, aviao.getQtd_assentos());
            stmt.setInt(4, aviao.getQtd_assentos_esp());
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

    public boolean procuraRegistro(String registro) {
        boolean result = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aviao where registro = ?";
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, registro);
            
            rs = stmt.executeQuery();
            if(rs.next()){
                result = true;
            }else{
                result = false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return result;
    }
}
