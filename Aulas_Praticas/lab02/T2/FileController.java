import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileController {
    private File file = null;

    public FileController(File f){
        this.file = f;
    }

    public FileController(){

    }

    public File openFile(File file) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            return this.file;

        } catch (FileNotFoundException e) {
            System.err.println("\nErro : file not found");
            return null;

        }

    }

    
}
