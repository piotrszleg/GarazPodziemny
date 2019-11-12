import java.util.Scanner;

public class Widok {
    Scanner scanner=new Scanner(System.in);
    Model model;
    public Widok(Model model){
        this.model=model;
    }
    public void wypisz(Object o){
        System.out.println(o);
    }
    public String zapytanie(String nazwa){
        System.out.print(nazwa+": ");
        return scanner.next();
    }
    Uzytkownik wprowadzenieUzytkownika() {
        while(true){
            wypisz("Wybierz akcje:");
            wypisz("1. Logowanie");
            wypisz("2. Rejestracja");
            try {
                Uzytkownik uzytkownik;
                switch(scanner.nextInt()){
                    case 1:
                        uzytkownik=uzytkownik=model.zaloguj(zapytanie("email"), zapytanie("haslo"));
                        wypisz("Logowanie udane.");
                        return uzytkownik;
                    case 2:
                        uzytkownik=model.zarejestruj(zapytanie("email"), zapytanie("haslo"));
                        wypisz("Utworzono nowe konto.");
                        return uzytkownik;
                }
            } catch(Model.ModelException|Uzytkownik.UzytkownikException e){
                wypisz(e.getMessage());
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
            } catch(Pojazd.NiepoprawnyNumerRejestracyjny e){
                wypisz(e.getMessage());
            }
        }
    }
    public void uruchom(){
        Uzytkownik uzytkownik=wprowadzenieUzytkownika();
        Pojazd pojazd=wprowadzeniePojazdu(uzytkownik);
        try {
            Miejsce miejsce=model.zajmijMiejsce(pojazd);
            wypisz("Mozesz zaparkowac na miejscu "+miejsce+" po wplaceniu kwoty "+pojazd.getCena()+"zl");
        } catch(Model.BrakMiejsc e) {
            wypisz("Przepraszamy, brak miejsc");
        } catch(Model.PojazdJuzZaparkowany e){
            wypisz("Ten pojazd jest juz zaparkowany");
        }
    }
}