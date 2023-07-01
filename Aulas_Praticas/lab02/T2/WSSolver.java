import java.io.File;
import java.io.IOException;

public class WSSolver {
    
    public static void main(String[] args) throws IOException {
        
        if(args.length != 1){
            System.err.println("\nError : only one argument accepeted\nOnly the puzzle file");
        }
        else{
            File file = new File(args[0]);

            //FileController fileController = new FileController();

            

            Puzzle puzzle = new Puzzle(file);
            Words words = new Words(file);

            words.setList();


            puzzleController controller = new puzzleController(puzzle, words);

            controller.validate();

            controller.print();

        }

        
    }
}
