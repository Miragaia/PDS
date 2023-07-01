import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class puzzlePrint {
    private List<String> puzzle = null;
    WordsMatchRecord wm = null;
    List <String> words = null;
    char [][] array = null;

    public puzzlePrint(Puzzle p, WordsMatchRecord wm, Words w) {
        this.puzzle = p.getPuzzle();
        this.wm = wm;
        this.words = w.getList();
    }

    public void createTable(){
        for (String word : words) {
            System.out.printf("%s %s %s %s", word, word.length(), wm.getWordsPosition().get(word), wm.getWordsOrietation().get(word));
            System.out.println();
        }
    }

    public void createArray(){
        int puzzleSize = puzzle.size();
        char[][] array = new char[puzzleSize][puzzleSize];
        for (int i = 0; i < puzzleSize; i++) {
            for (int j = 0; j < puzzleSize; j++) {
                array[i][j] = '.';
            }
        }
        putWordInArray(array, wm.getWordsPosition(), wm.getWordsOrietation());
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public char[][] putWordInArray(char[][] array, Map<String, ArrayList<Integer>> wordsPosition, Map<String, WordOrientation> wordsOrietation) {
        System.out.println("\n--------------------------------------------------------\n");
        for (Map.Entry<String, ArrayList<Integer>> entry : wordsPosition.entrySet()) {
            String word = entry.getKey();
            //System.out.println(word);
            ArrayList<Integer> position = entry.getValue();
            //System.out.println(word.charAt(0));
            //System.out.println("\n"+position.get(0)+" | "+position.get(1));
            int y = position.get(1), x = position.get(0);
            if(x != 0){
                x--;
            }
            if(y != 0){
                y--;
            }
            array[x][y] = word.charAt(0);
            //System.out.println("\n"+x+" | "+y); System.out.println(word);
            
            switch (wordsOrietation.get(word)) {
                case RIGHT_LEFT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x][y - i] = word.charAt(i);
                    }
                    break;

                case LEFT_RIGHT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x][y + i] = word.charAt(i);
                    }
                    break;

                case UP_DOWN:
                    for (int i = 1; i < word.length(); i++) {
                        array[x + i][y] = word.charAt(i);
                    }
                    break;

                case DOWN_UP:
                    for (int i = 1; i < word.length(); i++) {
                        array[x - i][y] = word.charAt(i);
                    }
                    break;

                case TOP_LEFT_BOTTOM_RIGHT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x + i][y + i] = word.charAt(i);
                    }
                    break;

                case TOP_RIGHT_BOTTOM_LEFT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x + i][y - i] = word.charAt(i);
                    }
                    break;

                case BOTTOM_LEFT_TOP_RIGHT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x - i][y + i] = word.charAt(i);
                    }
                    break;

                case BOTTOM_RIGHT_TOP_LEFT:
                    for (int i = 1; i < word.length(); i++) {
                        array[x - i][y - i] = word.charAt(i);
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Invalid direction: " + wordsOrietation.get(word));
            }
        }
        return array;
    }

}