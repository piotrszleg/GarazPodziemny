import java.util.Scanner;

public class Widok {
    Scanner scanner=new Scanner(System.in);
    SimpleIO io=new SimpleIO();
    Garaz garaz;
    public Widok(Garaz garaz){
        this.garaz=garaz;
    }
    public void wypisz(Object o){
        System.out.println(o);
    }
    public String zapytanie(String nazwa){
        System.out.print(nazwa+": ");
        return scanner.next();
    }
    Uzytkownik wprowadzenieUzytkownika(){
        while(true){
            wypisz("Wybierz akcje:");
            wypisz("1. Logowanie");
            wypisz("2. Rejestracja");
            try {
                Uzytkownik uzytkownik;
                switch(scanner.nextInt()){
                    case 1:
                        uzytkownik=uzytkownik=garaz.zaloguj(zapytanie("email"), zapytanie("haslo"));
                        wypisz("Logowanie udane.");
                        return uzytkownik;
                    case 2:
                        uzytkownik=garaz.zarejestruj(zapytanie("email"), zapytanie("haslo"));
                        wypisz("Utworzono nowe konto.");
                        return uzytkownik;
                }
            } catch(Exception e){
                wypisz("Nastapil blad:");
                wypisz(e);
            }
        }
    }
    Pojazd wprowadzeniePojazdu(Uzytkownik uzytkownik){
        while(true){
            wypisz("Typ pojazdu:");
            wypisz("1. Samochod");
            wypisz("2. Motocykl");
            try {
                switch(scanner.nextInt()){
                    case 1:
                        return new Samochod(uzytkownik, zapytanie("Numer rejestracyjny"));
                    case 2: 
                        return new Motocykl(uzytkownik, zapytanie("Numer rejestracyjny"));
                }
            } catch(Exception e){
                wypisz("Nastapil blad:");
                wypisz(e);
            }
        }
    }
    public void uruchom(){
        try {
            Uzytkownik uzytkownik=wprowadzenieUzytkownika();
            Pojazd pojazd=wprowadzeniePojazdu(uzytkownik);
            Miejsce miejsce=garaz.zajmijMiejsce(pojazd);
            wypisz("Mozesz zaparkowac na miejscu "+miejsce+" po wplaceniu kwoty "+pojazd.getCena()+"zl");
        } catch(Exception e){
            wypisz("Nastapil blad:");
            wypisz(e);
        }
    }
}