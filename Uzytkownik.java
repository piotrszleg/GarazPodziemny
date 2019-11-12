import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Uzytkownik {
    public static final String SOL = "losowy tekst uzywany do hashowania hasel";
    String email;
    byte[] hashHasla;

    static byte[] hash(String text) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        return sha.digest((text+SOL).getBytes());
    }
    public Uzytkownik(String email, String haslo) {
        try {
            this.email=email;
            this.hashHasla=hash(haslo);
        } catch(NoSuchAlgorithmException e) {
            // TODO
        }
    }
    public boolean sprawdzHaslo(String haslo){
        try {
            return hash(haslo)==hashHasla;
        } catch(NoSuchAlgorithmException e) {
            return false;
        }
    }
    public String getEmail(){
        return email;
    }
}