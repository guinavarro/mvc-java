/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import mvc.java.model.Usuario;

public class UsuarioDao {
    private Connection connection;
    
    public UsuarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void Insert(Usuario usuario){
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
}
