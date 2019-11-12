public class Tests {
   public static void main(String [] args) {
       Garaz garaz=new Garaz(10, 10);
       Uzytkownik uzytkownik=garaz.zarejestruj("jan.kowalski@email.pl", "haslo");
       assert(uzytkownik!=null);
       assert(garaz.zaloguj("jan.kowalski@email.pl", "haslo")!=null);
       System.out.println("testy zakonczone");
   }
}