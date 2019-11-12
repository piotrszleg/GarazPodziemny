public class Motocykl extends Pojazd implements java.io.Serializable {
    public int getCena(){
        return 2;
    }
    public Motocykl(Uzytkownik posiadacz, String numerRejestracyjny) throws NiepoprawnyNumerRejestracyjny{
        super(posiadacz, numerRejestracyjny);
    }
}