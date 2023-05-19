/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal {
    
    public void criarMenu(){
        JFrame frame = new JFrame();
        JMenuBar menu = new JMenuBar();
        
        JMenu menuCadastro = new JMenu();
        menuCadastro.setText("Cadastro");
        
        JMenuItem menuCadastroUsuario = new JMenuItem();
        menuCadastroUsuario.setText("Usuário");
        
        menuCadastroUsuario.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame.getContentPane().removeAll();
               frame.getContentPane().add(menu, BorderLayout.NORTH);
               
               CadastroUsuario cadastroUsuarioView = new CadastroUsuario();
               cadastroUsuarioView.setFrame(frame);
               
               cadastroUsuarioView.criarCadastroUsuario();
           }
        });
        
        menuCadastro.add(menuCadastroUsuario);
        menu.add(menuCadastro);
        
        JMenu menuProcura = new JMenu();
        menuProcura.setText("Procura");
        
        JMenuItem menuProcuraUsuario = new JMenuItem();
        menuProcuraUsuario.setText("Usuário");
        
        menuProcuraUsuario.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frame.getContentPane().removeAll();
               frame.getContentPane().add(menu, BorderLayout.NORTH);
               
               ProcuraUsuario procuraUsuario = new ProcuraUsuario();
               procuraUsuario.setFrame(frame);
               procuraUsuario.criarProcuraUsuario();
           }
            
        });
        
        menuProcura.add(menuProcuraUsuario);
        menu.add(menuProcura);
        
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(menu, BorderLayout.NORTH);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
    
}
