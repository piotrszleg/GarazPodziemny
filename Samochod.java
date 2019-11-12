public class Samochod extends Pojazd implements java.io.Serializable {
    public int getCena(){
        return 5;
    }
    public Samochod(Uzytkownik posiadacz, String numerRejestracyjny) throws NiepoprawnyNumerRejestracyjny{
        super(posiadacz, numerRejestracyjny);
    }
}