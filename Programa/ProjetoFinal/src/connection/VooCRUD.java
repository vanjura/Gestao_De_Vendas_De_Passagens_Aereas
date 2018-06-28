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
import passagens_aereas.Voo;

/**
 *
 * @author lucas_nuze0yo
 */
public class VooCRUD {

    private Connection con = null;

    public VooCRUD() {
        con = Conexao.getConexao();
    }
    
    public void inserir(Voo voo) {
        PreparedStatement stmt = null; 
        String sql = "insert into voo (origem, destino, aviao, data, ass_c, ass_esp, preco_c, preco_e, rota,hora) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, voo.getOrigem());
            stmt.setString(2, voo.getDestino());
            stmt.setString(3, voo.getAviao());
            stmt.setDate(4, voo.getData());
            stmt.setInt(5, voo.getAss_c());
            stmt.setInt(6, voo.getAss_e());
            stmt.setFloat(7, voo.getPreco_c());
            stmt.setFloat(8, voo.getPreco_e());
            stmt.setInt(9, voo.getRota());
            stmt.setString(10, voo.getHora());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public boolean atualizar(Voo voo, int idOld) {
        PreparedStatement stmt = null;
        String sql = "update voo set origem = ?, destino = ?, aviao = ?, data = ?, ass_c = ?, ass_esp = ?, preco_c = ?, preco_e = ?, rota= ? ,hora = ? where id_voo = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, voo.getOrigem());
            stmt.setString(2, voo.getDestino());
            stmt.setString(3, voo.getAviao());
            stmt.setDate(4, voo.getData());
            stmt.setInt(5, voo.getAss_c());
            stmt.setInt(6, voo.getAss_e());
            stmt.setFloat(7, voo.getPreco_c());
            stmt.setFloat(8, voo.getPreco_e());
            stmt.setInt(9, voo.getRota());
            stmt.setString(10, voo.getHora());
            stmt.setInt(11, idOld);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void exclusao(int id){
        PreparedStatement stmt = null;
        String sql = "delete from voo where id_voo = ?";
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
    
    public List<Voo> buscaTudo(){
        List<Voo> voos = new ArrayList<>();
        String sql = "select * from voo";
        PreparedStatement stmt = null;
        ResultSet rs;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Voo voo = new Voo();
                voo.setId(rs.getInt("id_voo"));
                voo.setRota(rs.getInt("rota"));
                voo.setAviao(rs.getString("aviao"));
                voo.setData(rs.getDate("data"));
                voo.setAss_c(rs.getInt("ass_c"));
                voo.setAss_e(rs.getInt("ass_esp"));
                voo.setPreco_c(rs.getFloat("preco_c"));
                voo.setPreco_e(rs.getFloat("preco_e"));
                voo.setOrigem(rs.getString("origem"));
                voo.setDestino(rs.getString("destino"));
                voo.setHora(rs.getString("hora"));
                voos.add(voo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            Conexao.fecharConexao(con, stmt);
        }
        return voos;
    }

    public List<Voo> procuraAvioesUtilizados(java.sql.Date data) {
        List<Voo> voos = new ArrayList<>();
        String sql = "select aviao from voo where data = ?";
        PreparedStatement stmt = null;
        ResultSet rs;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (java.sql.Date) data);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Voo voo = new Voo();
                voo.setAviao(rs.getString("aviao"));
                voos.add(voo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            Conexao.fecharConexao(con, stmt);
        }
        return voos;
    }
}
