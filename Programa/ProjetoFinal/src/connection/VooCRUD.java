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
import java.util.Date;
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
        String sql = "insert into voo (rota, aviao, data) VALUES(?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, voo.getRota());
            stmt.setString(2, voo.getAviao());
            stmt.setDate(3, voo.getData());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
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
