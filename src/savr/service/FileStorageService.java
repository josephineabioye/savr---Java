package savr.service;

import savr.model.AutoDebit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {
    private static final String FILE_NAME = "autodebits.txt";

    public void save(List<AutoDebit> autoDebits) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(autoDebits);
        } catch (IOException e) {
            System.out.println("Error saving auto-debits");
        }
    }

    public List<AutoDebit> load() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<AutoDebit>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
