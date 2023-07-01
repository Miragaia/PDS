import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements FilterInterface{
    public Scanner sc;

    public TextReader(String filename) {
        File file = new File(filename);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.exit(1);
        }
    }

    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }

    @Override
    public String next() {
        return sc.nextLine();
    }
    
}
