public class Miejsce {
    public final int rzad;
    public final int kolumna;
    Miejsce(int rzad, int kolumna){
        this.rzad=rzad;
        this.kolumna=kolumna;
    }
    public String toString(){
        return ""+(rzad+1)+":"+(kolumna+1);
    }
}