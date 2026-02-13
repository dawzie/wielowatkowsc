import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton zalogujButton;
    private JLabel statusLabel;

    public GlownyView() {
        setTitle("System Logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Nazwa użytkownika:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        userField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userField, gbc);

        JLabel passLabel = new JLabel("Hasło:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        passField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passField, gbc);

        zalogujButton = new JButton("Zaloguj");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(zalogujButton, gbc);

        statusLabel = new JLabel("Gotowy do logowania", JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(statusLabel, gbc);

        add(panel);
    }

    public String getNazwaUzytkownika() {
        return userField.getText();
    }

    public String getHaslo() {
        return new String(passField.getPassword());
    }

    public JButton getZalogujButton() {
        return zalogujButton;
    }

    public void ustawStatus(String status) {
        statusLabel.setText(status);
    }
}