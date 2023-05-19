package mvc.java.controller;

import java.util.List;
import mvc.java.dao.UsuarioDao;
import mvc.java.model.Usuario;


public class UsuarioController {
    
    public void delete(int id){
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.delete(id);
        System.out.println("Usuário excluído com sucesso");
    }
    
    public void insert(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();        
        usuarioDao.insert(usuario);
        
        System.out.println("Usuario cadastrado com sucesso");
    }
    
    public Usuario findById(int id){
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.findById(id);
    }
    
    public List<Usuario> findByNomeOuCpf(String nome, String cpf){
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.findByNomeOuCpf(nome, cpf);
    }
    
    public List<Usuario> findAll(){
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.findAll();
    }
    
    public void update(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.update(usuario);
    }
}
