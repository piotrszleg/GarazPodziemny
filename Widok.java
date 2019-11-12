public class Widok {
    SimpleIO io=new SimpleIO();
    Garaz garaz;
    public Widok(Garaz garaz){
        this.garaz=garaz;
    }
    public void uruchom(){
        io.print("Wybierz akcje:");
        io.print("1. Logowanie");
        io.print("2. Rejestracja");
        io.print("3. Widok dewelopera");
    }
}