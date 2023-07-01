import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleVerify {
    public boolean isSquare = true, puzzlecapitalized = true, noEmptyLines = true, noRepeated = true;
    private File file =  null;
    
    public PuzzleVerify(File file){
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void is_square(File file) throws FileNotFoundException{
        String line = null;
        Scanner sc = new Scanner(file);
       
        int num_lines = 0, num_collumn = 0;

       while (sc.hasNextLine()) {
        num_lines ++;

        
        line  = sc.nextLine();
        System.out.println(line);
    }

    }
}
