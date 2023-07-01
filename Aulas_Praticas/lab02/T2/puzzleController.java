import java.io.IOException;

public class puzzleController {
    Puzzle puzzle = null; Words words = null;
    PuzzleValidation validation = null; 
    WordsMatchRecord wm = null;
    puzzlePrint puzzlePrint = null;


    public puzzleController(Puzzle p, Words w) throws IOException{
        this.puzzle = p; this.words = w;
        this.puzzle.setPuzzle(); this.words.setList();
        this.wm = new WordsMatchRecord(this.words.getList());
        this.validation = new PuzzleValidation(puzzle, words);
        this.puzzlePrint = new puzzlePrint(puzzle, wm, w);
    }
    
    public void validate(){
        validation.is_square();

        if(validation.isSquare == false){
            System.out.println("\nError  : puzzle is not square");
        }

        if(validation.atLeast3Letters == false){
            System.out.println("\nError : one line of puzzle or one word of the list\nDoesnt hava (at least) 3 characters");
        }
                
        validation.is_upperCased();

        if(validation.isUpperCased == false){
            System.out.println("\nError : puzzle line arent uppercased");
        }

        validation.onlyAlphabeticChars();

        if(validation.hasOnlyAlphaChars == false){
            System.out.println("\nError : puzzle or line has a non-alphabetic char");
        }
        
        validation.has_empty_lines();

        if(validation.noEmptyLines == false){
            System.out.println("\nError : puzzle or line have an empty space");
        }


        if(validation.isSquare == true && validation.atLeast3Letters == true && validation.hasOnlyAlphaChars == true && validation.isUpperCased ==  true){
            validation.oneWordMatching(this.wm);
            if(validation.noRepeated == false){
                System.out.println("\nError : some words repeated in the puzzle");
            }
        }


        if(validation.isSquare == false || validation.atLeast3Letters == false || validation.hasOnlyAlphaChars == false || 
        validation.isUpperCased == false || validation.noRepeated == false ){
            System.err.println("\nPuzzle not valid");
        }
    }

    public void print(){
        puzzlePrint.createTable();
        puzzlePrint.createArray();
    }

    


}
