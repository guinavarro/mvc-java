/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.java.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import mvc.java.controller.UsuarioController;
import mvc.java.model.Usuario;

/**
 *
 * @author Navarro
 */
public class ProcuraUsuario {
    private JFrame frame;
    
    public JFrame getFrame(){
        return frame;
    }
    
    public void setFrame(JFrame frame){
        this.frame = frame;
    }
    
    public void criarProcuraUsuario(){
        JPanel panelBuscaUsuario = new JPanel();
        JPanel panelBuscaBotoes = new JPanel();
        JPanel panelProcuraUsuario = new JPanel();
        
        JLabel labelNome = new JLabel();
        labelNome.setText("Nome");
        
        JTextField textNome = new JTextField();
        textNome.setText("Nome");
        
        JLabel labelCpf = new JLabel();
        labelCpf.setText("CPF");
        
        MaskFormatter mascaraCpf = null;
        
          try{
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholder("0");
                        
        }catch(ParseException ex){
            System.err.println("Erro na formatação: " + ex.getMessage());
            System.exit(-1);
        }
        
        JFormattedTextField jFormattedCpf = new JFormattedTextField(mascaraCpf);
        jFormattedCpf.setText("000.000.000-00");
        
        JButton buttonProcurar = new JButton();
        buttonProcurar.setText("Procurar");
        
        JButton buttonAlterar = new JButton();
        buttonAlterar.setText("Alterar");
        
        JButton buttonExcluir = new JButton();
        buttonExcluir.setText("Excluir");
        
        JButton buttonFechar = new JButton();
        buttonFechar.setText("Fechar");
        
        buttonFechar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");
        tableModel.addColumn("TipoUsuario");
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        
        UsuarioController usuarioController = new UsuarioController();
        
        tableModel.setNumRows(0);
        
        for(Usuario usuario: usuarioController.findAll()){
            tableModel.addRow(new Object[]{
               usuario.getId(), usuario.getNome(), usuario.getCpf(),
                usuario.getTipoUsuario().getId()
            });
        }
        
        panelBuscaUsuario.add(labelNome);
        panelBuscaUsuario.add(textNome);
        
        panelBuscaUsuario.add(labelCpf);
        panelBuscaUsuario.add(jFormattedCpf);
        
        panelBuscaBotoes.add(buttonProcurar);
        panelBuscaBotoes.add(buttonAlterar);
        panelBuscaBotoes.add(buttonExcluir);
        panelBuscaBotoes.add(buttonFechar);
        
        panelProcuraUsuario.add(BorderLayout.NORTH, panelBuscaUsuario);
        panelProcuraUsuario.add(BorderLayout.CENTER, panelBuscaBotoes);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 100));
        panelProcuraUsuario.add(BorderLayout.SOUTH, scroll);
        
        frame.getContentPane().add(panelProcuraUsuario, BorderLayout.CENTER);
        frame.setVisible(true);    
        
    }
}
