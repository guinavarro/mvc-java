/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.java.model.Usuario;

public class UsuarioDao {
    private Connection connection;
    
    public UsuarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insert(Usuario usuario){
        String strSql = "Insert into usuario (cpf, nome, idTipoUsuario) values ('"+
                usuario.getCpf() + "','" + usuario.getNome() + "'," +
                usuario.getTipoUsuario().getId() + ")";
        
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(strSql);
            stmt.close();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public List<Usuario> findAll(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String strSql = "select id, cpf, nome, idTipoUsuario from usuario"; 
        
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(strSql)
                    
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt(1));
                usuario.setCpf(rs.getString(2));
                usuario.setNome(rs.getString(3));
                usuario.getTipoUsuario().setId(rs.getInt(4));
                
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return usuarios;
    }
}
