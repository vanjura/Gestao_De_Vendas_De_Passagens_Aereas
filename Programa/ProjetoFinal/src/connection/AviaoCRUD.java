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

    //Executa uma inserção na tabela aviao
    public boolean inserir(Aviao aviao) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO AVIAO (registro, modelo, qtd_assentos, qtd_assentos_esp) VALUES(?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aviao.getRegistro());
            stmt.setString(2, aviao.getModelo());
            stmt.setInt(3, aviao.getQtd_assentos());
            stmt.setInt(4, aviao.getQtd_assentos_esp());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    //Executa um update no na tabela de aviao
    public boolean atualizar(Aviao aviao, String registroOld) {
        PreparedStatement stmt = null;
        String sql = "update aviao set registro = ?, modelo = ?, qtd_assentos = ?, qtd_assentos_esp = ? where registro = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aviao.getRegistro());
            stmt.setString(2, aviao.getModelo());
            stmt.setInt(3, aviao.getQtd_assentos());
            stmt.setInt(4, aviao.getQtd_assentos_esp());
            stmt.setString(5, registroOld);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    
    public void exclusao(String registro) {
        PreparedStatement stmt = null;
        String sql = "delete from aviao where registro = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, registro);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public List<Aviao> buscaTudo() {
        List<Aviao> avioes = new ArrayList<>();
        String sql = "select * from aviao";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aviao aviao = new Aviao(
                        rs.getString("registro"),
                        rs.getString("modelo"),
                        rs.getInt("qtd_assentos"),
                        rs.getInt("qtd_assentos_esp")
                );
                avioes.add(aviao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return avioes;
    }

    //detecta se um registro já existe no banco
    public boolean procuraRegistro(String registro) {
        boolean result = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aviao where registro = ?";
        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, registro);

            rs = stmt.executeQuery();
            result = rs.next();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return result;
    }

    //retorna os registros de aviões cadastrados no banco
    public List<String> selecionaRegistro() {
        List<String> avioes = new ArrayList<>();
        String sql = "select registro from aviao";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                avioes.add(rs.getString("registro"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return avioes;
    }

    //retorna o numero de assentos utilizando o registro
    public int retornaAssentosC(String registro) {
        int assentosC = 0;
        String sql = "select qtd_assentos from aviao where registro = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, registro);
            rs = stmt.executeQuery();
            if (rs.next()) {
                assentosC = rs.getInt("qtd_assentos");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return assentosC;
    }

    //retorna o numero de assentos utilizando o registro
    public int retornaAssentosE(String registro) {
        int assentosE = 0;
        String sql = "select qtd_assentos_esp from aviao where registro = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, registro);
            rs = stmt.executeQuery();
            if (rs.next()) {
                assentosE = rs.getInt("qtd_assentos_esp");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return assentosE;
    }
}
