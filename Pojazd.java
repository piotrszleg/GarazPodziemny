public abstract class Pojazd implements java.io.Serializable {
    Uzytkownik posiadacz;
    String numerRejestracyjny;
    public String getNumerRejestracyjny(){
        return numerRejestracyjny;
    }
    public class NiepoprawnyNumerRejestracyjny extends Exception {
        public String getMessage() {
            return "Niepoprawny numer rejestracyjny.";
        }
    }
    public Pojazd(Uzytkownik posiadacz, String numerRejestracyjny) throws NiepoprawnyNumerRejestracyjny{
        if(numerRejestracyjny.length()<4){
            throw new NiepoprawnyNumerRejestracyjny();
        }
        this.posiadacz=posiadacz;
        this.numerRejestracyjny=numerRejestracyjny;
    }
    public boolean czyTenSam(Pojazd b){
        return this.numerRejestracyjny.equals(b.numerRejestracyjny);
    }
    public abstract int getCena();
}