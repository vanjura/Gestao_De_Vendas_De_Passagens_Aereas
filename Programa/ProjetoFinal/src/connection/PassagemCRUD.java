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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql = "insert into passagem (tipo, origem, destino, data, plataforma, valor, rg, cpf, nome,hora) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, passagem.getTipo());
            stmt.setString(2, passagem.getOrigem());
            stmt.setString(3, passagem.getDestino());
            stmt.setDate(4, passagem.getData());
            stmt.setString(5, passagem.getPlataforma());
            stmt.setFloat(6, passagem.getValor());
            stmt.setString(7, passagem.getRg());
            stmt.setString(8, passagem.getCpf());
            stmt.setString(9, passagem.getNome());
            stmt.setString(9, passagem.getNome());
            stmt.setString(10, passagem.getHora());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void exclusao(int id_passagem){
        PreparedStatement stmt = null;
        String sql = "delete from passagem where id_passagem = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_passagem);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Passagem> buscaTudo(){
        List<Passagem> passagens = new ArrayList<>();
        String sql = "select * from passagem";
        PreparedStatement stmt = null;
        ResultSet rs;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Passagem passagem = new Passagem(
                        rs.getInt("id_passagem"), 
                        rs.getString("tipo"), 
                        rs.getString("origem"), 
                        rs.getString("destino"), 
                        rs.getDate("data"),
                        rs.getString("plataforma"), 
                        rs.getFloat("valor"), 
                        rs.getString("rg"), 
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("hora")
                );
                passagens.add(passagem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            Conexao.fecharConexao(con, stmt);
        }
        return passagens;
    }
    
}
