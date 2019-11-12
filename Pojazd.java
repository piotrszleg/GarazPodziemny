public abstract class Pojazd {
    Uzytkownik posiadacz;
    String numerRejestracyjny;
    public String getNumerRejestracyjny(){
        return numerRejestracyjny;
    }
    public class NiepoprawnyNumerRejestracyjny extends Exception {}
    public Pojazd(Uzytkownik posiadacz, String numerRejestracyjny) throws NiepoprawnyNumerRejestracyjny{
        if(numerRejestracyjny.length()<4){
            throw new NiepoprawnyNumerRejestracyjny();
        }
        this.posiadacz=posiadacz;
        this.numerRejestracyjny=numerRejestracyjny;
    }
    public boolean czyTenSam(Pojazd b){
        return this.numerRejestracyjny==b.numerRejestracyjny;
    }
    public abstract int getCena();
}