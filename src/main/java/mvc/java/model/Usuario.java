/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.model;

/**
 *
 * @author Aluno
 */
public class Usuario {
        private int id;
        private String cpf;
        private String nome;
        private TipoUsuario tipoUsuario;
        
        public Usuario(){
            tipoUsuario = new TipoUsuario();
        }
        
        public int getId(){
            return id;
        }
        
         public void setId(int id){
             this.id = id;
         }
         
         public String getCpf(){
             return cpf;
         }
         
         public void setCpf(String cpf){
             this.cpf = cpf;
         }
         
         public String getNome(){
             return nome;
         }
         
         public void setNome(String nome){
             this.nome = nome;
         }
         
         public TipoUsuario getTipoUsuario(){
             return tipoUsuario;
         }
         
         public void setTipoUsuario(TipoUsuario tipoUsuario){
             this.tipoUsuario = tipoUsuario;
         }
            
}
