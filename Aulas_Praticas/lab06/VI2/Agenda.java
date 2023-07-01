
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda implements ContactsInterface {
    List<Contact> list = new ArrayList<>();

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        list = store.loadContacts();
        
    }

    @Override
    public void saveAndClose() {
        if(list.size() < 1) {
            System.out.println("No contacts to save");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Save to file: ");
        String filename = sc.nextLine();
        sc.close();

        try
        {
            ContactsStorageInterface store = new ContactsStorageTXT(new File(filename));
            store.saveContacts(list);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if(list.size() < 1) {
            System.out.println("No contacts to save");
            return;
        }
        store.saveContacts(list);    
    }

    @Override
    public boolean exist(Contact contact) {
        if(list.contains(contact)) {
            return true;
        }
        else {
            return false;
        }    
    }

    @Override
    public Contact getByName(String name) {
       
        for (Contact contact : list) {
            if(contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if(list.contains(contact)) {
            return false;
        }
        else {
            list.add(contact);
            return true;
        }
    }

    @Override
    public boolean remove(Contact contact) {
        if(list.contains(contact)) {
            list.remove(contact);
            return true;
        }
        else {
            System.out.println("Contact not found");
            return false;
        }    
    }
    
    
}
