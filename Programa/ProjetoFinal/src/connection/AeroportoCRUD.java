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
    
    public boolean inserir(Aeroporto aeroporto) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO aeroporto (NOME, CIDADE, ESTADO) VALUES(?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aeroporto.getNome());
            stmt.setString(2, aeroporto.getCidade());
            stmt.setString(3, aeroporto.getEstado());
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
    
    public void exclusao(int registro){
        PreparedStatement stmt = null;
        String sql = "delete from aeroporto where registro = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, registro);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void atualizar(Aeroporto aeroporto){
        PreparedStatement stmt = null;
        String sql = "update aeroporto set nome = ?, cidade = ?, estado = ? where registro = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aeroporto.getNome());
            stmt.setString(2, aeroporto.getCidade());
            stmt.setString(3, aeroporto.getEstado());
            stmt.setInt(4, aeroporto.getRegistro());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Aeroporto> buscaTudo(){
        List<Aeroporto> aeroportos = new ArrayList<>();
        String slq = "select * from aeroporto";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(slq);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aeroporto aeroporto = new Aeroporto();
                aeroporto.setRegistro(rs.getInt("registro"));
                aeroporto.setNome(rs.getString("nome"));
                aeroporto.setCidade(rs.getString("cidade"));
                aeroporto.setEstado(rs.getString("estado"));
                aeroportos.add(aeroporto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return aeroportos;
    }

    public List<Aeroporto> buscaNome() {
        List<Aeroporto> aeroportoNomes = new ArrayList<>();
        String slq = "select nome from aeroporto";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(slq);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aeroporto aeroporto = new Aeroporto();
                aeroporto.setNome(rs.getString("nome"));
                aeroportoNomes.add(aeroporto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return aeroportoNomes;
    }

    public int buscaRegistroComNome(String nome) {
        int registro = 0;
        String slq = "select registro from aeroporto where nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(slq);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if (rs.next()) {
                registro = rs.getInt("registro");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return registro;
    }

    public String buscaCidade(String nome) {
        String cidade = "";
        String slq = "select cidade from aeroporto where nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(slq);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cidade = rs.getString("cidade");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return cidade;
    }
}
