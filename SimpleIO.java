import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class SimpleIO {
    Scanner scanner=new Scanner(System.in).useLocale(Locale.ENGLISH);

    public void print(Object message){
        System.out.println(message);
    }

    void incorrectInputPrompt(){
        print("Podano niepoprawną liczbę.");
    }

    void variablePrompt(String name){
        System.out.print(name+"=");
    }

    public double[] getDoubleArray(String name){
        System.out.println("Wprowadz tablicę "+name);
        int count=getInt("długość tablicy=");
        double[] array=new double[count];
        for(int i=0; i<count; i++){
            array[i]=getDouble("tablica["+i+"]");
        }
        return array;
    }

    public int[] getIntArray(String name){
        System.out.println("Wprowadz tablicę "+name);
        int count=getInt("długość tablicy=");
        int[] array=new int[count];
        for(int i=0; i<count; i++){
            array[i]=getInt("tablica["+i+"]");
        }
        return array;
    }

    public double getDouble(String name){
        variablePrompt(name);
        try {
            return scanner.nextDouble();
        } catch(InputMismatchException e){
            incorrectInputPrompt();
            System.exit(0);
            return -1;
        }
    }

    public int getInt(String name){
        variablePrompt(name);
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e){
            incorrectInputPrompt();
            System.exit(0);
            return -1;
        }
    }
}