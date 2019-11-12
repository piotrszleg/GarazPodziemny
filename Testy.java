import java.lang.Runnable;
import java.lang.Exception;

public class Testy {
    @FunctionalInterface
    interface ThrowingFunction {
        void run() throws Exception;
    }
    public static void assertException(ThrowingFunction wyrazenie, Class<? extends Exception> expectedException){
        boolean zaistnialo=false;
        try {
            wyrazenie.run();
        } catch(Exception e){
            zaistnialo=true;
            assert(expectedException.isInstance(e));
        }
        assert(zaistnialo);
    } 
    public static void main(String [] args) throws Exception {
        Model model=new Model(10, 10);

        assertException(
           ()->model.zarejestruj("jan.kowalski@email.pl", "h"), 
           Uzytkownik.NiepoprawneHaslo.class);
        assertException(
           ()->model.zarejestruj("jan.kowalski", "haslo"), 
           Uzytkownik.NiepoprawnyEmail.class);
    
        Uzytkownik uzytkownik=model.zarejestruj("jan.kowalski@email.pl", "haslo");
        assert(uzytkownik!=null);
    
        assert(model.zaloguj("jan.kowalski@email.pl", "haslo")!=null);
        assert(model.znajdzMiejsce()!=null);

        assertException(
            ()->new Samochod(uzytkownik, "ABC"), 
            Pojazd.NiepoprawnyNumerRejestracyjny.class);
            Samochod samochod=new Samochod(uzytkownik, "ABC123");
        assert(model.zajmijMiejsce(samochod)!=null);

        assertException(
            ()->model.zajmijMiejsce(samochod), 
            Model.PojazdJuzZaparkowany.class);

        Model modelBezMiejsc=new Model(0, 0);
        assert(modelBezMiejsc.znajdzMiejsce()==null);
        assertException(
            ()->modelBezMiejsc.zajmijMiejsce(samochod), 
            Model.BrakMiejsc.class);

        System.out.println("testy zakonczone");
    }
}