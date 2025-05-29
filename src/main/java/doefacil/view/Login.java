package doefacil.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private static final String URL = "jdbc:mysql://localhost:3306/doefacil";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static boolean validarLogin(String usuario, String senha) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, usuario);
                stmt.setString(2, senha);

                stmt.executeQuery();

                try (ResultSet result = stmt.executeQuery()) {
                    return result.next();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
        }

        return false;

    }

    public static Frame telaLogin() {

        // Criar o frame (janela)
        JFrame frame = new JFrame("Tela de Login");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centralizar a janela na tela

        // Criar um painel com um layout adequado
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
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

        loginButton.addActionListener(e -> {
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword());

            if (validarLogin(usuario, senha)) {
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos.");
            }
        });

        return frame;

    }
}