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
        String sql = "insert into rota (origem, destino, preco_c, preco_e) VALUES(?,?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setString(1, rota.getOrigem());
            stmt.setString(2, rota.getDestino());
            stmt.setFloat(3, rota.getPreco_c());
            stmt.setFloat(4, rota.getPreco_e());
            
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
    
    public void exclusao(int id){
        PreparedStatement stmt = null;
        String sql = "delete from aeroporto where id_rota = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Rota> buscaTudo(){
        ArrayList<Rota> rotas = new ArrayList<>();
        String sql = "select * from rota";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Rota rota = new Rota();
                
                rota.setId(rs.getInt("id_rota"));
                rota.setOrigem(rs.getString("origem"));
                rota.setDestino(rs.getString("destino"));
                rota.setPreco_c(rs.getInt("preco_c"));
                rota.setPreco_e(rs.getInt("preco_e"));
                rotas.add(rota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.fecharConexao(con, stmt, rs);
        }
        return rotas;
    }
    
    public float procuraPrecoC(int id){
        float preco = 0;
        String sql = "select preco_c from rota where id_rota = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                preco = rs.getFloat("preco_c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.fecharConexao(con, stmt, rs);
        }
        return preco;
    }
    public float procuraPrecoE(int id){
        float preco = 0;
        String sql = "select preco_e from rota where id_rota = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                preco = rs.getFloat("preco_e");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.fecharConexao(con, stmt, rs);
        }
        return preco;
    }
    
     public String procuraOrigem(int id){
        String or = "";
        String sql = "select origem from rota where id_rota = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                or = rs.getString("origem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.fecharConexao(con, stmt, rs);
        }
        return or;
    }
     public String procuraDestino(int id){
        String de = "";
        String sql = "select destino from rota where id_rota = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                de = rs.getString("destino");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.fecharConexao(con, stmt, rs);
        }
        return de;
    }
}
