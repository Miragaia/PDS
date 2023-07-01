
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageTXT extends ContactsImplement {
    private File file;
    private List<Contact> list = new ArrayList<>();

    public ContactsStorageTXT(File file) {
        super(file);
        this.file = file;
    }

    public List<Contact> loadContacts() {
        try (Scanner sc = new Scanner(new File("./lab06/VI2/" + file.getName()))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split("\t");
                Contact contact = new Contact(line[0], Integer.parseInt(line[1]));
                list.add(contact);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        return list;
    }

    public boolean saveContacts(List<Contact> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./lab06/VI2/" + file))) {
            writer.write("NAME\tPHONE\n");
            for (Contact contact : list) {
                writer.write(contact.getName() + "\t" + contact.getNumber() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
        return false;
    }
    
}
