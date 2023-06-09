/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import mvc.java.controller.TipoUsuarioController;
import mvc.java.controller.UsuarioController;
import mvc.java.model.TipoUsuario;
import mvc.java.model.Usuario;

public class CadastroUsuario {

    private JFrame frame;
    private Usuario usuarioAlteracao;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public void criarCadastroUsuario() {
        TipoUsuarioController tipoUsuarioController = new TipoUsuarioController();
        JPanel panelCadastroUsuario = new JPanel();

        JLabel labelId = new JLabel();
        labelId.setText("Id");
        labelId.setBounds(10, 10, 50, 20);

        JTextField textId = new JTextField();

        if (usuarioAlteracao == null) {
            textId.setText("Id");
        } else {
            textId.setText(String.valueOf(usuarioAlteracao.getId()));
        }

        textId.setBounds(110, 10, 200, 20);
        textId.setEnabled(false);

        JLabel labelNome = new JLabel();
        labelNome.setText("Nome");
        labelNome.setBounds(10, 40, 50, 20);

        JTextField textNome = new JTextField();

        if (usuarioAlteracao == null) {
            textNome.setText("Nome");
        } else {
            textNome.setText(String.valueOf(usuarioAlteracao.getNome()));
        }

        textNome.setBounds(110, 40, 200, 20);

        JLabel labelCpf = new JLabel();
        labelCpf.setText("CPF");
        labelCpf.setBounds(10, 70, 50, 20);

        MaskFormatter mascaraCpf = null;

        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholder("0");

        } catch (ParseException ex) {
            System.err.println("Erro na formatação: " + ex.getMessage());
            System.exit(-1);
        }

        JFormattedTextField jFormattedCpf = new JFormattedTextField(mascaraCpf);
        jFormattedCpf.setText("000.000.000-00");
        jFormattedCpf.setBounds(110, 70, 200, 20);

        JLabel labelTipoUsuario = new JLabel();
        labelTipoUsuario.setText("Tipo Uusário");
        labelTipoUsuario.setBounds(10, 100, 100, 20);

        JComboBox comboTipoUsuario = new JComboBox();

        for (TipoUsuario tipoUsuario : tipoUsuarioController.findAll()) {
            comboTipoUsuario.addItem(tipoUsuario);
        }

        comboTipoUsuario.setBounds(110, 100, 200, 20);

        var buttonCadastrar = new JButton();
        if (usuarioAlteracao == null) {
            buttonCadastrar.setText("Cadastrar");
        } else {
            buttonCadastrar.setText("Alterar");
        }

        buttonCadastrar.setBounds(10, 200, 90, 25);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController usuarioController = new UsuarioController();
                Usuario usuario = new Usuario();

                usuario.setCpf(jFormattedCpf.getText());
                usuario.setNome(textNome.getText());
                usuario.setTipoUsuario((TipoUsuario) comboTipoUsuario.getSelectedItem());

                if (usuarioAlteracao == null) {
                    usuarioController.insert(usuario);
                    JOptionPane.showMessageDialog(null,
                            "Usuário cadastrado com sucesso!");
                } else {
                    usuario.setId(usuarioAlteracao.getId());
                    usuarioController.update(usuario);
                    JOptionPane.showMessageDialog(null,
                            "Usuário alterado com sucesso!");
                }
            }
        }
        );
        
        JButton buttonFechar = new JButton();
        buttonFechar.setText("Fechar");
        buttonFechar.setBounds(110, 150, 90, 25);
        
        buttonFechar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        panelCadastroUsuario.setLayout(null);
        panelCadastroUsuario.add(labelId);
        panelCadastroUsuario.add(textId);

        panelCadastroUsuario.add(labelNome);
        panelCadastroUsuario.add(textNome);

        panelCadastroUsuario.add(labelCpf);
        panelCadastroUsuario.add(jFormattedCpf);

        panelCadastroUsuario.add(labelTipoUsuario);
        panelCadastroUsuario.add(comboTipoUsuario);

        panelCadastroUsuario.add(buttonCadastrar);

        frame.add(panelCadastroUsuario, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
