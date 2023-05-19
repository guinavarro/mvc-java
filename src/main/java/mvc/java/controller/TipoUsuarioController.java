/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.controller;


import mvc.java.model.TipoUsuario;
import java.util.ArrayList;
import java.util.List;


public class TipoUsuarioController {
    
    private List<TipoUsuario> tiposUsuario;
    
    public TipoUsuarioController(){
        tiposUsuario = new ArrayList<TipoUsuario>();
        
        TipoUsuario tipoAdm = new TipoUsuario();
        tipoAdm.setId(1);
        tipoAdm.setDescricao("Administrador");        
        TipoUsuario tipoFunc = new TipoUsuario();
        tipoFunc.setId(2);
        tipoFunc.setDescricao("Funcionário");
        
        tiposUsuario.add(tipoAdm);
        tiposUsuario.add(tipoFunc);        
    }
    
    public List<TipoUsuario> findAll(){
        return tiposUsuario;
    }
}