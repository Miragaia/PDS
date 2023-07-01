import java.io.File;
public class Main {

    public static void main(String[] args) {

        Agenda ag = new Agenda();

        //------------------------------- TXT -------------------------

        File filename = new File("Contactos1.txt");
        ContactsStorageInterface store = new ContactsImplement(filename);
        System.out.println("Opening TXT file...");
        ag.openAndLoad(store);

        System.out.println("\ngetByName: " + ag.getByName("João Passos"));

        System.out.println("\nAdd Tom Cruzeiro...");
        ag.add(new Contact("Tom Cruzeiro", 943456311));
        System.out.println("\ngetByName: " + ag.getByName("Tom Cruzeiro"));

        System.out.println("\nRemoving João Passos...");
        ag.remove(ag.getByName("João Passos"));

        System.out.printf("\nAndré Dias exists?");
        if (ag.exist(ag.getByName("André Dias")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        System.out.printf("\nJoão Passos exists?");
        if (ag.exist(ag.getByName("João Passos")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        //Add João Passos to replace the João Passos that remove before, and so that this works always
        ag.add(new Contact("João Passos", 962317564));

        System.out.println("Save and Close...");
        ag.saveAndClose(store);

        //-------------------------------------------------------------

        System.out.println("Binary file:");
        String file = "contacts"; 
       

        //-------------------------------- BINARY --------------------------

        File file2 = new File(file);
        ContactsStorageInterface csb = new ContactsImplement(file2);
        System.out.println("Opening Binary file...");
        ag.openAndLoad(csb);


        System.out.println("getByName: " + (ag.getByName("André Mitrogolo")));

        System.out.println("Add Mário Jonas");
        ag.add(new Contact("Mário Jonas", 923460275));

        System.out.printf("\nMário Jonas exists?");
        if (ag.exist(ag.getByName("Mário Jonas")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        System.out.printf("\nSimão Saboroso exists?");
        if (ag.exist(ag.getByName("Simão Saboroso")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        System.out.println("\nRemove Simão Saboroso");
        ag.remove(ag.getByName("Simão Saboroso"));

        System.out.printf("\nSimão Saboroso exists?");
        if (ag.exist(ag.getByName("Simão Saboroso")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        System.out.printf("\nMiguel Veloz exists?");
        if (ag.exist(ag.getByName("Miguel Veloz")) == true) {
            System.out.printf(" Yes\n");
        } else {
            System.out.printf(" No\n");
        }

        ag.add(new Contact("Carlos Carl", 936457021));

        System.out.println("Save and Close...");
        ag.saveAndClose(csb);

        //------------------------------------------------------------------
        
    }
}