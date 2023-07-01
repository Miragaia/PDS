import java.util.ArrayList;
import java.util.List;

public class HorizontalSearch {
    private int nwords = 0;
    private List<String> words = null;
    private List<String> wordsFinded = new ArrayList<>();
    private WordsMatchRecord wm = null;
    private List<String> puzzle = null;
    private String reverseLine = null;
    private String upperCasedWord = null;
    private StringBuilder StrbldreverseLine = new StringBuilder("");

    public HorizontalSearch(Words w, Puzzle p, WordsMatchRecord wm2){
        this.words  = w.getList();  this.puzzle = p.getPuzzle();
        this.wm = wm2;
        this.nwords = w.numOfwords;
    }

    public List<String> getwordsFinded() {
        return this.wordsFinded;
    }

    public  void setwordsFinded(){
        int pos_line = 0, pos_collumn = 0;
        //System.out.println("\n---Searching words by lines---");
        for(String word : this.words){
            pos_line = 0;
            upperCasedWord = word.toUpperCase();
            for(String line : this.puzzle){
                pos_line++;
                //System.out.println("\nWord : "+this.upperCasedWord);
                StrbldreverseLine.append(line); StrbldreverseLine.reverse(); 
                reverseLine = StrbldreverseLine.toString();
                //System.out.println("\nNormal c : "+line + " Reverse : "+reverseLine);
                if(line.contains(this.upperCasedWord) == true){
                    this.nwords++;
                    pos_collumn = (line.indexOf(upperCasedWord) + 1 );
                    //System.out.print("\nWord : "+word);
                    //System.out.print(" Coluna : "+pos_collumn);
                    //System.out.print(" Linha : "+pos_line+"\n");
                    //System.out.println("\n"+this.nwords+" : "+word);
                    //System.out.println("\nNormal c : "+line + " Reverse : "+reverseLine);
                    WordOrientation wordOrientation = WordOrientation.LEFT_RIGHT;
                    wm.setWordsMatch(word); wm.setWordsPosition(word, pos_line, pos_collumn); ; wm.setWordsOrietation(word, wordOrientation);
                    wordsFinded.add(word);
                }
                else if(reverseLine.contains(this.upperCasedWord) == true){
                    this.nwords++;
                    pos_collumn = (this.puzzle.size()  - (reverseLine.indexOf(upperCasedWord)));
                    //System.out.print("\nWord : "+word);
                    //System.out.print(" Coluna : "+pos_collumn);
                    //System.out.print(" Linha : "+pos_line+"\n");
                    //System.out.println("\n"+this.nwords+" : "+word);
                    //System.out.println("\nNormal c : "+line + " Reverse : "+reverseLine);
                    WordOrientation wordOrientation = WordOrientation.RIGHT_LEFT;
                    wm.setWordsMatch(word); wm.setWordsPosition(word, pos_line, pos_collumn); wm.setWordsOrietation(word, wordOrientation);
                    wordsFinded.add(word);
                }
                

                StrbldreverseLine.setLength(0);
            }
        }

        
    }




}
