import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Zawieszanie extends JFrame {
    private JButton startButton;
    private JLabel statusLabel;

    public Zawieszanie() {
        setTitle("app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        startButton = new JButton("Start");
        statusLabel = new JLabel("Gotowy", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        statusLabel.setText("Pracuję... " + (i + 1) + "s");
                    }
                    statusLabel.setText("Zakończono blokadę.");
                } catch (InterruptedException ex) {

                }
            }
        });

        panel.add(startButton, BorderLayout.NORTH);
        panel.add(statusLabel, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Zawieszanie().setVisible(true);
            }
        });
    }
}