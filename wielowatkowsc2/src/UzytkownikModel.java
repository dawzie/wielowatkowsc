public class UzytkownikModel {

    public boolean walidujLogowanie(String user, String pass) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ("admin".equals(user) && "haslo123".equals(pass)) {
            return true;
        } else {
            return false;
        }
    }
}