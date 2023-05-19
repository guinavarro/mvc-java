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
    
    public void delete(int id){
        String strSql = "Delete from usuario where id = " + id;
        
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(strSql);
            stmt.close();            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
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
    
    public Usuario findById(int id){
        String strSql = "SELECT id, cpf, nome, idTipoUsuario from usuario"
        + " where id = " + id;
        
        Usuario usuario = new Usuario();
        
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(strSql);
            
            while(rs.next()){
                usuario.setId(rs.getInt(1));
                usuario.setCpf(rs.getString(2));
                usuario.setNome(rs.getString(3));
                usuario.getTipoUsuario().setId(rs.getInt(4));
            }
            rs.close();
            stmt.close();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return usuario;
    }
    
    public List<Usuario> findByNomeOuCpf(String nome, String cpf){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String strSql = "select id, cpf, nome, idTipoUsuario from usuario";
        
        if(nome != "" && !cpf.equals("000.000.000-00")){
            strSql = strSql + " where nome like '%" + nome + "%' "
            + "and cpf like '%" + cpf + "%'";
        }else if(nome != ""){
            strSql = strSql + " where nome like '%" + nome + "%'";            
        }else if(cpf != "000.000.000-00"){
            strSql = strSql + " where cpf like '%" + cpf + "%¨'";
        }
          try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(strSql);
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt(1));
                usuario.setCpf(rs.getString(2));
                usuario.setNome(rs.getString(3));
                usuario.getTipoUsuario().setId(rs.getInt(4));
            }
            rs.close();
            stmt.close();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return usuarios;
    }
    
    public List<Usuario> findAll(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String strSql = "select id, cpf, nome, idTipoUsuario from usuario"; 
        
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(strSql);
                    
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
    
    public void update(Usuario usuario){
        String strSql = "Update usuario set cpf = '" + usuario.getCpf() +
        "', nome = '" + usuario.getNome() + "', idTipoUsuario = 1" +
        " where id = " + usuario.getId();
        
         try{
            Statement stmt = connection.createStatement();     
            stmt.execute(strSql);
            stmt.close();          
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
    }
}
