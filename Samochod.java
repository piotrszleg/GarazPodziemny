public class Samochod extends Pojazd {
    public int getCena(){
        return 5;
    }
    public Samochod(Uzytkownik posiadacz, String numerRejestracyjny){
        super(posiadacz, numerRejestracyjny);
    }
}