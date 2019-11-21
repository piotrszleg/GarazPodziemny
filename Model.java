import java.util.List;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.InputStream;

public class Model implements java.io.Serializable {
    Pojazd[][] miejsca;
    List<Uzytkownik> uzytkownicy=new ArrayList<Uzytkownik>();
    public Model(int iloscRzedowMiejsc, int iloscKolumnMiejsc){
        miejsca=new Pojazd[iloscRzedowMiejsc][iloscKolumnMiejsc];
    }
    public class ModelException extends Exception {}
    public class EmailZajety extends ModelException {
        public String getMessage() {
            return "Email zajety.";
        }
    }
    public Uzytkownik zarejestruj(String email, String haslo) throws EmailZajety, Uzytkownik.BladTworzenia, Uzytkownik.NiepoprawneHaslo, Uzytkownik.NiepoprawnyEmail {
        for(Uzytkownik uzytkownik : uzytkownicy){
            if(uzytkownik.getEmail().equals(email)){
                throw new EmailZajety();
            }
        }
        Uzytkownik uzytkownik=new Uzytkownik(email, haslo);
        uzytkownicy.add(uzytkownik);
        return uzytkownik;
    }
    public class BrakUzytkownika extends ModelException {
        public String getMessage() {
            return "Brak uzytkownika.";
        }
    }
    public class NiepoprawneHaslo extends ModelException {
        public String getMessage() {
            return "Wprowadzono niepoprawne haslo.";
        }
    }
    public Uzytkownik zaloguj(String email, String haslo) throws BrakUzytkownika, NiepoprawneHaslo {
        for(Uzytkownik uzytkownik : uzytkownicy){
            if(uzytkownik.getEmail().equals(email)){
                if(uzytkownik.sprawdzHaslo(haslo)){
                    return uzytkownik;
                } else {
                    throw new NiepoprawneHaslo();
                }
            }
        }
        throw new BrakUzytkownika();
    }
    public Miejsce znajdzMiejsce(){
        for(int r=0; r<miejsca.length; r++){
            for(int k=0; k<miejsca[r].length; k++){
                if(miejsca[r][k]==null){
                    return new Miejsce(r, k);
                }
            }
        }
        return null;
    }
    public class BrakMiejsc extends Exception {}
    public class PojazdJuzZaparkowany extends Exception {}
    public Miejsce zajmijMiejsce(Pojazd pojazd) throws PojazdJuzZaparkowany, BrakMiejsc {
        for(int r=0; r<miejsca.length; r++){
            for(int k=0; k<miejsca[r].length; k++){
                if(miejsca[r][k]==null){
                    miejsca[r][k]=pojazd;
                    return new Miejsce(r, k);
                } else if(miejsca[r][k].czyTenSam(pojazd)){
                    throw new PojazdJuzZaparkowany();
                }
            }
        }
        throw new BrakMiejsc();
    }
}