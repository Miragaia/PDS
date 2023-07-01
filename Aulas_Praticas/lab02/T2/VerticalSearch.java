import java.util.ArrayList;
import java.util.List;

public class VerticalSearch {
    private int nwords = 0;
    private List<String> words = null;
    private List<String> wordsFinded = new ArrayList<>();
    private ArrayList<String> collumns = new ArrayList<>();
    private WordsMatchRecord wm = null;
    private List<String> puzzle = null;
    private String reverseCollumn = null;
    private String upperCasedWord = null;
    private StringBuilder StrbldreverseCollum = new StringBuilder(""), 
    collumbuilder =  new StringBuilder(""), wordBuilder = new StringBuilder("");

    public VerticalSearch(Words w, Puzzle p, WordsMatchRecord wm){
        this.words  = w.getList();  this.puzzle = p.getPuzzle();
        this.wm = wm;
        this.nwords = w.numOfwords;

        setCollumns();
    }
    

    public List<String> getwordsFinded() {
        return this.wordsFinded;
    }

    public void setCollumns(){
        int collumn = 0;
        final int numofcollumn = this.puzzle.get(0).length();
        //System.out.println("\nNum of collumns : "+numofcollumn);
        while(collumn != numofcollumn){
            for(String line : this.puzzle){
                collumbuilder.append(line.charAt(collumn));
            }
            
            //System.out.println("\n"+collumn+" : "+collumbuilder);

            this.collumns.add(collumbuilder.toString());
            collumbuilder.setLength(0);
            collumn++;
        }
    }

    public void setwordsFinded(){
        //System.out.println("\n---Searching words by collumns---");
        String w = null;
        for(String word : this.words){
            int pos_line = 0, pos_collumn = 0;
            upperCasedWord = word.toUpperCase();
            for(String line : this.collumns){
            pos_line++;
            StrbldreverseCollum.append(line); StrbldreverseCollum.reverse();
            reverseCollumn = StrbldreverseCollum.toString();
            //System.out.println("\nNormal c : "+line + " Reverse : "+reverseCollumn);
                if(line.contains(this.upperCasedWord) == true ){
                    this.nwords++;
                    pos_collumn = (line.indexOf(upperCasedWord) + 1 );
                    //System.out.println("\n"+this.nwords+" : "+word);
                    //System.out.print("\nWord : "+word);
                    //System.out.print(" Linha : "+pos_collumn);
                    //System.out.print(" Coluna : "+pos_line+"\n");
                    WordOrientation wordOrientation = WordOrientation.UP_DOWN;
                    wm.setWordsMatch(word); wm.setWordsPosition(word, pos_collumn, pos_line); ; wm.setWordsOrietation(word, wordOrientation);
                    wordsFinded.add(word);
                }
                else if(reverseCollumn.contains(this.upperCasedWord) == true){
                    this.nwords++;
                    wordBuilder.append(word.toUpperCase()); wordBuilder.reverse();
                    w = wordBuilder.toString();
                    pos_collumn = pos_line;
                    pos_line = (line.indexOf(w) + w.length());
                    //System.out.print("\nWord : "+word);
                    //System.out.print(" Linha : "+pos_line);
                    //System.out.print(" Coluna : "+pos_collumn+"\n");

                    //System.out.println("\n"+this.nwords+" : "+word);
                    WordOrientation wordOrientation = WordOrientation.DOWN_UP;
                    wm.setWordsMatch(word); wm.setWordsPosition(word, pos_line, pos_collumn); ; wm.setWordsOrietation(word, wordOrientation);
                    wordsFinded.add(word);
                }
                StrbldreverseCollum.setLength(0);
                wordBuilder.setLength(0);
            }
        }
    }
}

