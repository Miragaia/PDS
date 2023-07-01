import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;

public class WSGenerator {
    public static void main(String[] args) throws IOException {
        int OptArg = 0, puzzleSize = 0;
        boolean containsI = false, containsS = false;
        char grid[][] = null; char ch;
        String WordsListFileName = null, fileOutputName = null;
        List<String> listOfWords = null;
        File outputFile = null;

        for(int index = 0; index < args.length ; index++ ){
            //indicando uma option : 
            if(args[index].charAt(0) == '-'){
                switch (args[index]) {
                    case "-i":
                        OptArg = index + 1;
                        WordsListFileName = args[OptArg];
                        containsI = true;
                        //System.out.println(WordsListFileName);
                        break;
                    case "-s":
                        OptArg = index + 1;
                        puzzleSize =  Integer.parseInt(args[OptArg]);
                        containsS = true;
                        //System.out.println(puzzleSize);
                        break;

                    case "-o":
                        OptArg = index + 1;
                        fileOutputName =  args[OptArg];
                        //System.out.println(puzzleSize);
                        break;

                
                    default:
                        break;
                }
            }
        }

        if(containsI == false){
            System.out.println("\nError : Need to specify the wordslist file name (-i filename.txt) ");
        }

        if(containsS == false){
            System.out.println("\nError : Need to specify the size (dimension) of the puzzle (-s 12) ");
        }

        if(containsI == false || containsS == false){
            System.exit(0);
        }


        File file = new File(WordsListFileName);
        if(file.exists() == false){
            System.out.println("\nError : File name, file path or file doesnt exist ");
            System.exit(0);
        }


        if(fileOutputName != null){
            outputFile = new File(fileOutputName);
            if(outputFile.exists() == false){
                System.out.println("\nError : Output file name, output file path or output file doesnt exist (-o filename.txt)");
                System.exit(0);
            }
        }

        grid = new char[puzzleSize][puzzleSize];
        for(int l = 0; l < puzzleSize; l++){
            for(int c = 0; c < puzzleSize; c++){
                grid[l][c] = '.';
            }
        }

        Words words = new Words(file);
        words.setList();
        listOfWords = words.getList();
        final int size = puzzleSize;
        WordsMatchRecord wm = new WordsMatchRecord(listOfWords);

        listOfWords.forEach( (w) -> {
            if(w.length() > size){
                //System.out.println("\nWord : "+w+" lenght = "+w.length()+" < "+size+" = "+"Puzzle Size");
                System.exit(0);
            }
        } );

        SortWords sw = new SortWords(words, wm, puzzleSize, grid);

        sw.sortOrientations();

        
        for(String word : listOfWords){
            //System.out.print("\n--- w : "+word+" ---\n");
            sw.setPositions(word);
        }
        
        
        

        char c, randomChar;
        Random generator =  new Random();
        for(int line = 0; line < grid.length ; line++){
            //System.out.println();
            for(int collumn = 0; collumn < grid[line].length; collumn++){
                c = grid[line][collumn];
                if(c == '.'){
                    randomChar = (char)(generator.nextInt(26)+'a');
                    grid[line][collumn] = Character.toUpperCase(randomChar);
                    //System.out.print(" "+randomChar);
                }
                else{
                    //System.out.print(" "+c);
                    continue;
                }

                //if(Character.isAlphabetic(c) == false){}
                //System.out.print(" "+ch);
            }
        }
        
        if(fileOutputName == null)
        {   
            //System.out.println("\n-------------------------------------------------------------\n");
            for(int line = 0; line < grid.length; line++){
                System.out.println();
                for(int collumn = 0; collumn < grid[line].length; collumn++){
                    ch = grid[line][collumn];
                    System.out.print(" "+ch);
                }
            }
            
        }
        else{
            FileOutputStream fos = new FileOutputStream(outputFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String fullLine = null; 
            StringBuilder lineBuilder = new StringBuilder("");
            for(int line = 0; line < grid.length; line++){
                System.out.println();
                for(int collumn = 0; collumn < grid[line].length; collumn++){
                    ch = grid[line][collumn];
                    lineBuilder.append(ch);
                }
                
                fullLine = lineBuilder.toString();
                lineBuilder.setLength(0);
                bw.write(fullLine);
                bw.newLine();
            }
            bw.close();
        }

       
        
        /* */

            

           
        
        


    }
}
