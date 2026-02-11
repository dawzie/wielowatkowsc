import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Naprawione extends JFrame {
    private JButton startButton;
    private JLabel statusLabel;

    public Naprawione() {
        setTitle("app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        startButton = new JButton("Start");
        statusLabel = new JLabel("Gotowy", JLabel.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                            publish("Pracuję... " + (i + 1) + "s");
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<String> chunks) {
                        String latestStatus = chunks.get(chunks.size() - 1);
                        statusLabel.setText(latestStatus);
                    }

                    @Override
                    protected void done() {
                        statusLabel.setText("Zakończono pomyślnie");
                    }
                }.execute();
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
                new Naprawione().setVisible(true);
            }
        });
    }
}