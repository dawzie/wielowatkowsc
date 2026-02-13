import javax.swing.*;

public class SystemLogowania {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UzytkownikModel model = new UzytkownikModel();
                GlownyView view = new GlownyView();
                GlownyController controller = new GlownyController(model, view);

                view.setVisible(true);
            }
        });
    }
}