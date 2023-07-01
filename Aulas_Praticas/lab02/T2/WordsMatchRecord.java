import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsMatchRecord {
    private  Map<String, Integer> wordsMatch = new HashMap<String, Integer>();
    private  Map<String, WordOrientation> wordsOrietation = new HashMap<String, WordOrientation>();
    private  Map<String, ArrayList<Integer>> wordsPosition = new HashMap<String, ArrayList<Integer>>();

    public WordsMatchRecord(List<String> words){
        for(String word : words){
            wordsMatch.put(word, 0);
        }
    }

    public void setWordsPosition(String word, int Row, int Collumn) {
        ArrayList<Integer> position = new ArrayList<>();

        position.add(Row); position.add(Collumn);

        this.wordsPosition.put(word, position);
    }


    public void setWordsMatch(String word) {
        this.wordsMatch.put(word, wordsMatch.get(word)+1);
    }
    
    public void setWordsOrietation(String word, WordOrientation orientation) {
        wordsOrietation.put(word, orientation);
    }
    
    public Map<String, ArrayList<Integer>> getWordsPosition() {
        return wordsPosition;
    }

    public Map<String, Integer> getWordsMatch() {
        return this.wordsMatch;
    }

    public Map<String, WordOrientation> getWordsOrietation() {
        return wordsOrietation;
    }

    
}
