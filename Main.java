import java.io.*;

public class Main {
   static final String PLIK="Model.ser";

   static Model zaladujModel() throws IOException, ClassNotFoundException, FileNotFoundException {
      FileInputStream fileIn=new FileInputStream(PLIK);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      Model Model=(Model)in.readObject();
      in.close();
      fileIn.close();
      return Model;
   }
   static void zapiszModel(Model Model) throws IOException {
      FileOutputStream fileOut =
      new FileOutputStream(PLIK);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(Model);
      out.close();
      fileOut.close();
   }
   public static void main(String [] args) throws IOException, ClassNotFoundException {
      Model Model;

      try {
         Model=zaladujModel();
      } catch(FileNotFoundException e) {
         Model=new Model(10, 10);
      }

      new Widok(Model).uruchom();

      zapiszModel(Model);
   }
}