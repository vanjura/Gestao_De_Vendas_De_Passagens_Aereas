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
    public boolean inserir(Usuario usuario) {
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
    
    //Busca cada um dos usuarios e armazena em um ArrayList
    public List<Usuario> buscaTodos(){
        //comando sql
        String sql = "SELECT * FROM USUARIO";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //criando o ArrayLista para armazenar os dados encontrados para um posterior teste de validação
        List<Usuario> usuarios = new ArrayList<>();
        try {
            
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            //Tratamento para cada dado encontrado ir para seu devido lugar
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                //os gets recebem uma string com o mesmo nome da coluna respectiva no banco
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNivel(rs.getInt("NIVEL"));
                usuarios.add(usuario);
            }
        
        } catch (SQLException ex) {
            //Erro seguido do código
            System.err.println("Erro: " + ex);
        } finally{
            //Finalizando a Conexão, Statement e o ResultSet
            Conexao.fecharConexao(con, stmt, rs);
        }
        //Retorna o ArrayList
        return usuarios;
    }
    public boolean procurarUsuario(String usuario){
        boolean result = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
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
