public class Motocykl extends Pojazd {
    public int getCena(){
        return 2;
    }
    public Motocykl(Uzytkownik posiadacz, String numerRejestracyjny){
        super(posiadacz, numerRejestracyjny);
    }
}