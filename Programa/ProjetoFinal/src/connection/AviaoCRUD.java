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

    public boolean inserir(Aviao aviao) {
        PreparedStatement stmt = null;

        //Comando sql de inserção 
        String sql = "INSERT INTO AVIAO (registro, modelo, qtd_assentos, qtd_assentos_esp) VALUES(?,?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setString(1, aviao.getRegistro());
            stmt.setString(2, aviao.getModelo());
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
    
    public List<Aviao> buscaTudo(){
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
