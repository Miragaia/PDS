import java.io.IOException;
import java.util.List;

public class PuzzleValidation {
    public boolean isSquare = true, isUpperCased = true, atLeast3Letters = true,
    noEmptyLines = true, noRepeated = true, hasOnlyAlphaChars = true;
    
    private Puzzle puzzle = null; private Words words = null;

    public PuzzleValidation(Puzzle p, Words w) throws IOException{
        p.setPuzzle(); w.setList();
        this.puzzle = p; this.words = w;


    }

    public void has_empty_lines(){
        String line = null; 
        final List<String> puzzle = this.puzzle.getPuzzle(), listofwords = this.words.getList();;


        for(String l : puzzle){
            line = l;
            if(line.isEmpty() == true || line.isBlank()){
                noEmptyLines = false;
                break;
            }
            
        }

        for(String w : listofwords){
            line = w;
            if(line.isEmpty() == true || line.isBlank()){
                noEmptyLines = false;
                break;
            }
            
        }
    }

    public void oneWordMatching(WordsMatchRecord wm){
        HorizontalSearch hs = new HorizontalSearch(this.words, this.puzzle, wm); hs.setwordsFinded();
        VerticalSearch   vs = new VerticalSearch(this.words, this.puzzle, wm); vs.setwordsFinded();
        DiagonalSearch   ds = new DiagonalSearch(this.words, this.puzzle, wm); ds.setGrid(); ds.setwordsFinded();
        //hs.setwordsFinded();
        System.out.println("\n");
        wm.getWordsMatch().forEach(
            (word, matches) ->
            {
                //System.out.println("Word : "+word+" found : "+matches+" times")
                if(matches != 0 && matches != 1){
                    System.out.println("Word : "+word+" found : "+matches+" times");
                    noRepeated = false;
                }
                //else{System.out.println("Word : "+word+ " Position[x,y] : "+wm.getWordsPosition().get(word));}
            }
        );


    }

    public void onlyAlphabeticChars(){
        char[] line;
        final List<String> puzzle = this.puzzle.getPuzzle(), listofwords = this.words.getList();;


        for(String l : puzzle){
            line = l.toCharArray();
            for(char ch : line){
                if(Character.isAlphabetic(ch) == false){
                    hasOnlyAlphaChars = false;
                    //System.out.println(l);
                }
            }
            
        }

        for(String w : listofwords){
            line = w.toCharArray();
            for(char ch : line){
                if(Character.isAlphabetic(ch) == false){
                    hasOnlyAlphaChars = false;
                    //System.out.println("ch:"+ch+"-");
                    //System.out.println("\n Non-alphabetic Word : "+w);
                }
            }
            
        }
    }

    public void is_upperCased()  {
        char[] line;
        final List<String> puzzle = this.puzzle.getPuzzle();
        for(String l : puzzle){
            line = l.toCharArray();
            for(char ch : line){
                if(Character.isUpperCase(ch) == false){
                    isUpperCased = false;
                    //System.out.println(line);
                }
            }
        }
         
       
    }


    public void is_square(){
        final List<String> puzzle = this.puzzle.getPuzzle(), listofwords = this.words.getList();
        String line = null;
        int num_lines = 0, num_collumn = 0;
        //System.out.println("\nSize arr : "+(puzzle.size()));
        for(int index  = 0; index < puzzle.size() ; index++){
            line = puzzle.get(index);
            //System.out.printf("%n L : %,d  C : %,d", num_lines, num_collumn);

            if(num_lines == 0){
                num_collumn = line.length();

                if(num_collumn > 40){
                    isSquare = false ;
                    break;
                }
            }

            if(index != puzzle.size()){
            num_lines ++;}




            if( num_lines > 40  ){
                isSquare = false;
                break;
            }

            if(line.length() < 3){
                atLeast3Letters = false;
            }


        }

        for( String w : listofwords){
            if(w.length() < 3){
                atLeast3Letters = false;
            }
        }

        //System.out.printf("%n L : %,d  C : %,d", num_lines, num_collumn);

        if( num_lines != num_collumn){
            isSquare = false;
            System.out.println("\nNumber of lines (puzzle) : "+ num_lines);
            System.out.println("\nNumber of collmuns puzzle) : "+ num_collumn);
        }

    }


}
