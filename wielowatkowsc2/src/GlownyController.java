import javax.swing.*;
import java.awt.event.*;

public class GlownyController {
    private UzytkownikModel model;
    private GlownyView view;

    public GlownyController(UzytkownikModel model, GlownyView view) {
        this.model = model;
        this.view = view;

        view.getZalogujButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rozpocznijLogowanie();
            }
        });
    }

    private void rozpocznijLogowanie() {
        final String user = view.getNazwaUzytkownika();
        final String pass = view.getHaslo();

        view.getZalogujButton().setEnabled(false);
        view.ustawStatus("Prosze czekać");

        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return model.walidujLogowanie(user, pass);
            }

            @Override
            protected void done() {
                view.getZalogujButton().setEnabled(true);
                try {
                    boolean wynik = get();
                    if (wynik) {
                        view.ustawStatus("Logowanie pomyślne!");
                    } else {
                        view.ustawStatus("Błędny login lub hasło!");
                    }
                } catch (Exception e) {
                    view.ustawStatus("Błąd: " + e.getMessage());
                }
            }
        }.execute();
    }
}