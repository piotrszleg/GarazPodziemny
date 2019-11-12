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
	   Garaz garaz=new Garaz(10, 10);

	   assertException(
		   ()->garaz.zarejestruj("jan.kowalski@email.pl", "h"), 
		   Uzytkownik.NiepoprawneHaslo.class);
		assertException(
		   ()->garaz.zarejestruj("jan.kowalski", "haslo"), 
		   Uzytkownik.NiepoprawnyEmail.class);
	
	   Uzytkownik uzytkownik=garaz.zarejestruj("jan.kowalski@email.pl", "haslo");
	   assert(uzytkownik!=null);
	
	   assert(garaz.zaloguj("jan.kowalski@email.pl", "haslo")!=null);
	   assert(garaz.znajdzMiejsce()!=null);

	   assertException(
		   ()->new Samochod(uzytkownik, "ABC"), 
		   Pojazd.NiepoprawnyNumerRejestracyjny.class);
	   Samochod samochod=new Samochod(uzytkownik, "ABC123");
	   assert(garaz.zajmijMiejsce(samochod)!=null);

	   assertException(
		   ()->garaz.zajmijMiejsce(samochod), 
		   Garaz.PojazdJuzZaparkowany.class);

	   Garaz zerowyGaraz=new Garaz(0, 0);
	   assert(zerowyGaraz.znajdzMiejsce()==null);
	   assertException(
		   ()->zerowyGaraz.zajmijMiejsce(samochod), 
		   Garaz.BrakMiejsc.class);

	   System.out.println("testy zakonczone");
	}
}