import java.util.List;
import java.util.ArrayList;

public class Garaz {
    Pojazd[][] miejsca;
    List<Uzytkownik> uzytkownicy=new ArrayList<Uzytkownik>();
    public Garaz(int iloscRzedowMiejsc, int iloscKolumnMiejsc){
        miejsca=new Pojazd[iloscRzedowMiejsc][iloscKolumnMiejsc];
    }
    public class EmailZajety extends Exception {}
    public Uzytkownik zarejestruj(String email, String haslo) throws EmailZajety, Uzytkownik.BladTworzenia, Uzytkownik.NiepoprawneHaslo, Uzytkownik.NiepoprawnyEmail {
        for(Uzytkownik uzytkownik : uzytkownicy){
            if(uzytkownik.getEmail()==email){
                throw new EmailZajety();
            }
        }
        Uzytkownik uzytkownik=new Uzytkownik(email, haslo);
        uzytkownicy.add(uzytkownik);
        return uzytkownik;
    }
    public class BrakUzytkownika extends Exception {}
    public class NiepoprawneHaslo extends Exception {}
    public Uzytkownik zaloguj(String email, String haslo) throws BrakUzytkownika, NiepoprawneHaslo {
        for(Uzytkownik uzytkownik : uzytkownicy){
            if(uzytkownik.getEmail()==email){
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