import java.util.List;
import java.util.ArrayList;

public class Garaz {
    Pojazd[][] pojazdy;
    List<Uzytkownik> uzytkownicy=new ArrayList<Uzytkownik>();
    public Garaz(int iloscRzedowMiejsc, int iloscKolumnMiejsc){
        pojazdy=new Pojazd[iloscRzedowMiejsc][iloscKolumnMiejsc];
    }
    public Uzytkownik zarejestruj(String email, String haslo){
        Uzytkownik uzytkownik=new Uzytkownik(email, haslo);
        uzytkownicy.add(uzytkownik);
        return uzytkownik;
    }
    public Uzytkownik zaloguj(String email, String haslo){
        for(Uzytkownik uzytkownik : uzytkownicy){
            if(uzytkownik.getEmail()==email && uzytkownik.sprawdzHaslo(haslo)){
                return uzytkownik;
            }
        }
        return null;
    }
}