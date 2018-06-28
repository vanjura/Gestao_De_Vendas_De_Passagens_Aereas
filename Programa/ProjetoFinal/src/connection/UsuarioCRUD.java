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
import passagens_aereas.Usuario;

/**
 *
 * @author lucas_nuze0yo
 */
public class UsuarioCRUD {

    private Connection con = null;

    public UsuarioCRUD() {
        con = Conexao.getConexao();
    }

    //Insere novos usuaros ao banco
    public void inserir(Usuario usuario) {
        PreparedStatement stmt = null;

        //Comando sql de inserção 
        String sql = "INSERT INTO USUARIO (NOME, SENHA, NIVEL) VALUES(?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            // cada numero do setString ou setInt corresponde a um ? (interrogação) do comando sql
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getNivel());
            //Executa o Update
            stmt.executeUpdate();
        } catch (SQLException ex) {
            //imprime o erro em vermelho no console
            System.err.println("Erro: " + ex);
        } finally {
            //fecha a conexão e o Statement
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public boolean atualizar(Usuario usuario, String nomeOld) {
        PreparedStatement stmt = null;
        String sql = "update usuario set nome = ?, senha = ?, nivel = ? where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getNivel());
            stmt.setString(1, nomeOld);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void excluir(String nome){
        PreparedStatement stmt = null;
        String sql = "delete from usuario where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    //Busca cada um dos usuarios e armazena em um ArrayList
    public List<Usuario> buscaTodos() {
        String sql = "SELECT * FROM USUARIO";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNivel(rs.getInt("NIVEL"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            //Erro seguido do código
            System.err.println("Erro: " + ex);
        } finally {
            //Finalizando a Conexão, Statement e o ResultSet
            Conexao.fecharConexao(con, stmt, rs);
        }
        //Retorna o ArrayList
        return usuarios;
    }

    public boolean procurarUsuario(String usuario) {
        boolean result = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return result;
    }

    public List<Usuario> listarUsuarios() {
        Connection conn = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarioLista = new ArrayList<>();
        String sql = "Select nome, nivel from usuario";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setNome(rs.getString("nome"));
                usuario.setNivel(rs.getInt("nivel"));
                usuarioLista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro!" + ex);
        } finally {
            Conexao.fecharConexao(conn, stmt, rs);
        }

        return usuarioLista;
    }
}
