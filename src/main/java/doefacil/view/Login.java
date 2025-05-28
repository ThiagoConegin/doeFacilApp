package doefacil.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static JFrame pageLogin() {
        // Criar o frame (janela)
        JFrame frame = new JFrame("Tela de Login");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centralizar a janela na tela

        // Criar um painel com um layout adequado
        JPanel panel = new JPanel(new GridBagLayout()); // Para centralizar
        panel.setBorder(new EmptyBorder(2, 2, 2, 2)); // Adicionar padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // Espaçamento interno entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Criar os componentes
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField usuarioField = new JTextField(15);
        usuarioField.setPreferredSize(new Dimension(0, 30));

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPasswordField senhaField = new JPasswordField(15);
        senhaField.setPreferredSize(new Dimension(0, 30));

        JButton loginButton = new JButton("Entrar");
        loginButton.setPreferredSize(new Dimension(0, 35));

        // Adicionar componentes ao painel
        panel.add(usuarioLabel, gbc);
        gbc.gridx = 1;
        panel.add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(senhaLabel, gbc);
        gbc.gridx = 1;
        panel.add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Adicionar o painel ao frame
        frame.add(panel);

        // Tornar a janela visível
        frame.setVisible(true);

        // Adicionar ação ao botão
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                // Simples validação de login (substituir por lógica real)
                if (usuario.equals("admin") && senha.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos.");
                }
            }
        });

        return frame;

    }

}
