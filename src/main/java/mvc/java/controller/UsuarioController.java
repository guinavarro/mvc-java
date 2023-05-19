package mvc.java.controller;

import java.util.List;
import mvc.java.dao.UsuarioDao;
import mvc.java.model.Usuario;


public class UsuarioController {
    
    public void insert(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();        
        usuarioDao.insert(usuario);
        
        System.out.println("Usuario cadastrado com sucesso");
    }
    
    public List<Usuario> findAll(){
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.findAll();
    }
}
