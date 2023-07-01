import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiagonalSearch {
    private List < String > words = null;
    private char[][] grid;
    private List < String > wordsFinded = new ArrayList < > ();
    private Set < String > topLeftBottomRight = new HashSet < String > ();
    private Set < String > topRightBottomLeft = new HashSet < String > ();
    private Set < String > BottomRightTopLeft = new HashSet < String > ();
    private Set < String > bottomLeftTopRight = new HashSet < String > ();
    private WordsMatchRecord wm = null;
    private List < String > puzzle = null;

    public DiagonalSearch(Words w, Puzzle p, WordsMatchRecord wm) {
        this.words = w.getList();
        this.puzzle = p.getPuzzle();
        this.grid = new char[this.puzzle.size()][this.puzzle.size()];

        this.wm = wm;
        setGrid();
    }

    public List < String > getWordsFinded() {
        return wordsFinded;
    }


    public void setGrid() {
        char ch; int lineIndex = 0; String diagonal = null, d = null;
        List < String > list = this.puzzle; String[] listofDiagonals = null;
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < list.size(); line++) {
            for (int collumn = 0; collumn < list.size(); collumn++) {
                ch = puzzle.get(line).charAt(collumn);
                //System.out.println("\nCh : "+ch);
                this.grid[line][collumn] = ch;
            }
        }


        //TopLeft_BottomRight
        /* 
        int colIndex = 0;

        for(coluna = 0; coluna < len - colIndex;  coluna ++){
            for(linha =0 ;... ){
                ch = grid[linha][colIndex]
                append ch

                colIndex++;
            }
            colIndex = col;
        }

        */

        

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                int k = 0;
                while (i + k < this.grid.length && j + k < this.grid[0].length) {
                    sb.append(grid[i + k][j + k]);
                    k++;
                }
                this.topLeftBottomRight.add(sb.toString());
                //System.out.println(sb.toString());
                sb.setLength(0);
            }

        }
        

        

        //TopRight_BottomLeft

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = this.grid[0].length - 1; j >= 0; j--) {
                int k = 0;
                while (i + k < this.grid.length && j - k >= 0) {
                    sb.append(grid[i + k][j - k]);
                    k++;
                }
                this.topRightBottomLeft.add(sb.toString());
                sb.setLength(0);
            }
        }

        
    }





    public void setwordsFinded() {
        String upperCasedWord = null, reverseDiagonal = null;
        StringBuilder sb = new StringBuilder("");
        int line = 0, collumn = 0;
        List < Integer > startingPosition = new ArrayList < > ();
        for (String word: this.words) {
            line = 0;
            collumn = 0;
            upperCasedWord = word.toUpperCase();
            for (String diagonal: topLeftBottomRight) {
                sb.append(diagonal);
                sb.reverse();
                reverseDiagonal = sb.toString();
                if (diagonal.contains(upperCasedWord) == true) {
                    //System.out.println(this.grid.length);
                    wm.setWordsMatch(word);
                    //System.out.println(diagonal);
                    //System.out.println(diagonal.length());
                    //System.out.println(this.grid.length);
                    //System.out.println(diagonal.indexOf(upperCasedWord));
                    for (int i = 0; i < this.grid.length; i++) {
                        for (int j = 0; j < this.grid[0].length; j++) {
                            if (grid[i][j] == upperCasedWord.charAt(0)) {
                                boolean match = true;
                                int k = 1;
                                while (match && k < upperCasedWord.length()) {
                                    int rowOffset = k;
                                    int colOffset = k;
                                    line = i + rowOffset;
                                    collumn = j + colOffset;
                                    if (line < 0 || line >= this.grid.length || collumn < 0 || collumn >= this.grid.length) {
                                        match = false;
                                    } else if (grid[line][collumn] == upperCasedWord.charAt(k)) {
                                        k++;
                                    } else {
                                        match = false;
                                    }
                                }
                                if (match) {
                                    startingPosition.add(i);
                                    startingPosition.add(j);
                                }
                            }
                        }
                    }
                    wm.setWordsPosition(word, startingPosition.get(0) + 1, startingPosition.get(1) + 1);
                    startingPosition.clear();
                    WordOrientation wordOrientation = WordOrientation.TOP_LEFT_BOTTOM_RIGHT;
                    wm.setWordsOrietation(word, wordOrientation);

                } else if (reverseDiagonal.contains(upperCasedWord) == true) {
                    //System.out.println(this.grid.length);
                    //System.out.println("\nBOTTOM_RIGHT_TOP_LEFT : "+word);
                    //System.out.println("\nOn diagonal  : "+reverseDiagonal);
                    wm.setWordsMatch(word);
                    //System.out.println(reverseDiagonal.indexOf(upperCasedWord));
                    for (int i = this.grid.length - 1; i >= 0; i--) {
                        for (int j = this.grid[0].length - 1; j >= 0; j--) {
                            if (grid[i][j] == upperCasedWord.charAt(0)) {
                                boolean match = true;
                                int k = 1;
                                while (match && k < upperCasedWord.length()) {
                                    int rowOffset = -k;
                                    int colOffset = -k;
                                    line = i + rowOffset;
                                    collumn = j + colOffset;
                                    if (line < 0 || line >= this.grid.length || collumn < 0 || collumn >= this.grid.length) {
                                        match = false;
                                    } else if (grid[line][collumn] == upperCasedWord.charAt(k)) {
                                        k++;
                                    } else {
                                        match = false;
                                    }
                                }
                                if (match) {
                                    startingPosition.add(i);
                                    startingPosition.add(j);
                                }
                            }
                        }
                    }
                    wm.setWordsPosition(word, startingPosition.get(0) + 1, startingPosition.get(1) + 1);
                    startingPosition.clear();
                    WordOrientation wordOrientation = WordOrientation.BOTTOM_RIGHT_TOP_LEFT;
                    wm.setWordsOrietation(word, wordOrientation);
                    startingPosition.clear();
                }
                sb.setLength(0);
            }
            for (String diagonal: topRightBottomLeft) {
                sb.append(diagonal);
                sb.reverse();
                reverseDiagonal = sb.toString();
                if (diagonal.contains(upperCasedWord) == true) {
                    wm.setWordsMatch(word);
                    for (int i = 0; i < this.grid.length; i++) {
                        for (int j = this.grid[0].length - 1; j >= 0; j--) {
                            if (grid[i][j] == upperCasedWord.charAt(0)) {
                                boolean match = true;
                                int k = 1;
                                while (match && k < upperCasedWord.length()) {
                                    int rowOffset = k;
                                    int colOffset = -k;
                                    line = i + rowOffset;
                                    collumn = j + colOffset;
                                    if (line < 0 || line >= this.grid.length || collumn < 0 || collumn >= this.grid.length) {
                                        match = false;
                                    } else if (grid[line][collumn] == upperCasedWord.charAt(k)) {
                                        k++;
                                    } else {
                                        match = false;
                                    }
                                }
                                if (match) {
                                    startingPosition.add(i);
                                    startingPosition.add(j);
                                }
                            }
                        }
                    }
                    wm.setWordsPosition(word, startingPosition.get(0) + 1, startingPosition.get(1) + 1);
                    startingPosition.clear();
                    WordOrientation wordOrientation = WordOrientation.TOP_RIGHT_BOTTOM_LEFT;
                    wm.setWordsOrietation(word, wordOrientation);
                } else if (reverseDiagonal.contains(upperCasedWord) == true) {
                    wm.setWordsMatch(word);
                    for (int i = this.grid.length - 1; i >= 0; i--) {
                        for (int j = 0; j < this.grid[0].length; j++) {
                            if (grid[i][j] == upperCasedWord.charAt(0)) {
                                boolean match = true;
                                int k = 1;
                                while (match && k < upperCasedWord.length()) {
                                    int rowOffset = -k;
                                    int colOffset = k;
                                    line = i + rowOffset;
                                    collumn = j + colOffset;
                                    if (line < 0 || line >= this.grid.length || collumn < 0 || collumn >= this.grid.length) {
                                        match = false;
                                    } else if (grid[line][collumn] == upperCasedWord.charAt(k)) {
                                        k++;
                                    } else {
                                        match = false;
                                    }
                                }
                                if (match) {
                                    startingPosition.add(i);
                                    startingPosition.add(j);
                                }
                            }
                        }
                    }
                    wm.setWordsPosition(word, startingPosition.get(0) + 1, startingPosition.get(1) + 1);
                    startingPosition.clear();
                    WordOrientation wordOrientation = WordOrientation.BOTTOM_LEFT_TOP_RIGHT;
                    wm.setWordsOrietation(word, wordOrientation);
                }
                sb.setLength(0);
            }
        }
    }
}