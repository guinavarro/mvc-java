package mvc.java.controller;

import mvc.java.dao.UsuarioDao;
import mvc.java.model.Usuario;


public class UsuarioController {
    
    public void insert(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();        
        usuarioDao.Insert(usuario);
        
        System.out.println("Usuario cadastrado com sucesso");
    }
}
