public abstract class Pojazd {
    Uzytkownik posiadacz;
    String numerRejestracyjny;
    public String getNumerRejestracyjny(){
        return numerRejestracyjny;
    }
    public Pojazd(Uzytkownik posiadacz, String numerRejestracyjny){
        this.posiadacz=posiadacz;
        this.numerRejestracyjny=numerRejestracyjny;
    }
    public abstract int getCena();
}