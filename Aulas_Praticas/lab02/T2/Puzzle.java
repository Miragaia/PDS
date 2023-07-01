import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Puzzle {
 
    private List<String> lines = new ArrayList<>();
    public File file = null;

    private int numOfLines = 0;

    public Puzzle(File file){
        this.file = file;
    }

    public List<String>  getPuzzle(){
        return this.lines;
    }

    public void setPuzzle(){
        List<String> puzzle = new ArrayList<>();
        String line = null; boolean foundInvalidChar = false;
        try (Scanner sc = new Scanner(this.file)) {

            while(sc.hasNext()){
                line = sc.nextLine();

                if(line.contains(";") == true || line.contains(".") == true || 
                line.contains(",") == true || line.contains(" ") == true ){
                    continue;
                }

                char[] Fullline;
                Fullline = line.toCharArray();
                for(char ch : Fullline){
                    if(foundInvalidChar == true){
                        break;
                    }
                    if(Character.isUpperCase(ch) == false || Character.isAlphabetic(ch) == false){
                        //System.out.println(ch);
                        foundInvalidChar = true;
                        continue;
                        //System.out.println(line);
                    }
                    
                }

                if(foundInvalidChar == false){
                    numOfLines++;
                    //System.out.println("\nLine"+line);
                    puzzle.add(line);
                }
                foundInvalidChar = false;
            }

            this.lines = puzzle;
            //return puzzle;

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

        this.lines = puzzle;

        //return puzzle;

    }


        

}
