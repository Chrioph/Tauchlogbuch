package control;

import model.Program;

import java.io.*;

public class IOController {

    private static final String filename = "saved";

    public static void save (Program program){

        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
            stream.writeObject(program);
            stream.close();
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern des Program-Objektes aufgetreten");
            e.printStackTrace();
        }

    }

    public static Program load (){
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename));
            Program program = (Program) stream.readObject();
            stream.close();
            return program;
        } catch (IOException e) {
            System.err.println("Die Klasse des geladenen Objekts konnte nicht gefunden werden.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Das Objekt konnte nicht geladen werden.");
            e.printStackTrace();
        }
        return null;
    }
}
