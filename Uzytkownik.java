import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Uzytkownik {
    public static final String SOL = "losowy tekst uzywany do hashowania hasel";
    static Pattern wzorzecEmaila = Pattern.compile("\\S+@\\S+");
    String email;
    byte[] hashHasla;

    public class BladTworzenia extends Exception {}
    public class NiepoprawneHaslo extends Exception {}
    public class NiepoprawnyEmail extends Exception {}

    static byte[] hash(String text) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        return sha.digest((text+SOL).getBytes());
    }
    public Uzytkownik(String email, String haslo) throws BladTworzenia, NiepoprawneHaslo, NiepoprawnyEmail {
        if(haslo.length()<4){
            throw new NiepoprawneHaslo();
        }
        if(!wzorzecEmaila.matcher(email).matches()){
            throw new NiepoprawnyEmail();
        }
        this.email=email;
        try {
            this.hashHasla=hash(haslo);
        } catch(NoSuchAlgorithmException e) {
            throw new BladTworzenia();
        }
    }
    public boolean sprawdzHaslo(String haslo){
        try {
            return Arrays.equals(hash(haslo), hashHasla);
        } catch(NoSuchAlgorithmException e) {
            return false;
        }
    }
    public String getEmail(){
        return email;
    }
}