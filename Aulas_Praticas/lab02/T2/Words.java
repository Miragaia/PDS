import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Words {
    public File file = null;
    private List<String> lines = new ArrayList<>();
    public Map<String, Integer> WordLenght = new HashMap<String, Integer>();
    int numOfwords = 0;

    public Words(File file){
        this.file = file;
    }

    public List<String> getList(){
        return this.lines;
    }

    public void setList() throws IOException {
        List<String> listOfWords = new ArrayList<>();
        String line = null; StringBuilder wordbuild = new StringBuilder("");
        String[] Line = null; boolean allCharsUpperCased = true;
        String word = null; 
        char[] fullLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while((line = br.readLine()) != null){
                //line = sc.nextLine();
                //wordbuild = new StringBuilder("");

                if(line.contains(";") == true || line.contains(".") == true || 
                line.contains(",") == true || line.contains(" ") == true ){
                    //System.out.println("Line : "+line+"\n");

                    fullLine = line.toCharArray();
                    

                    for(char ch : fullLine){
                        //System.out.print(ch);
                        if( ch == ';' || ch == ',' || 
                        ch == '.' || ch == ' '){
                            //System.out.println(ch);
                            word = wordbuild.toString();
                            //System.out.print(" word : "+word+"\n");
                            //System.out.println(word.length());
                            listOfWords.add(word);
                            //System.out.println("word : "+word+"\n");
                            wordbuild.setLength(0);
                            this.numOfwords++;
                            continue;
                        }
                        
                        //System.out.println(ch);
                        wordbuild.append(ch);

                    }
                    wordbuild.setLength(0);

                    

                }
                else if(line.contains(";") != true && line.contains(".") != true || 
                line.contains(",") != true && line.contains(" ") != true){
                    
                    Line = line.split("\\s+");
                    if(Line.length == 1){
                        //System.out.println("Single line : "+Line[0]);
                        fullLine = line.toCharArray();

                        for(char ch : fullLine){
                            //System.out.print(ch);
                            if(Character.isLowerCase(ch) == true){
                                allCharsUpperCased = false;
                                this.numOfwords++;
                                continue;
                            }
                            
                            //System.out.println(ch);

                        }

                        if(allCharsUpperCased == false){
                            listOfWords.add(line);
                        }

                        allCharsUpperCased = true;
                        

                            
                    }
                        
                        //System.out.println(ch);

                }

            }
            this.lines = listOfWords;
            String w = null;
            for(int windex = 0; windex < listOfWords.size(); windex++){
                w = listOfWords.get(windex);
                //System.out.println("\nWord to find : "+w+"\n");
                for(int index = 0; index < listOfWords.size(); index++){
                    word = listOfWords.get(index);
                    if(word.contains(w) && word.length() > w.length()){
                        //System.out.printf("%n %s > %s", word, w);
                        listOfWords.remove(w);
                    }
                }
            }

            


           // return listOfWords;

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
        /* 
        for(String w : listOfWords){
            System.out.println(w);
            
            for(int i = 0 ; i < listOfWords.size(); i++){
                word = listOfWords.get(i);
                if(word.contains(w) == true ){
                    //System.out.printf("%n %s > %s", word, w);
                    //listOfWords.remove(w);
                }
            }

        }*/


        this.lines = listOfWords;

    }

    public void getWordsByFile() throws IOException{
        List<String> listOfWords = new ArrayList<>();
        String line = null; StringBuilder wordbuild = new StringBuilder("");
        String word = null; 
        char[] fullLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while((line = br.readLine()) != null){
                //line = sc.nextLine();
                //System.out.println("Line : "+line);
                //wordbuild = new StringBuilder("");

                if(line.contains(";") == true || line.contains(".") == true || 
                line.contains(",") == true || line.contains(" ") == true ){
                    //System.out.println("Line : "+line);
                    
                    word = wordbuild.toString();

                    if(word.length() >= 3){
                        //System.out.println("word : "+word+"\n");
                        //System.out.println(word.length());
                        listOfWords.add(word);
                    }

                    wordbuild.setLength(0);
                    fullLine = line.toCharArray();

                    for(char ch : fullLine){
                        if( ch == ';' || ch == ',' || 
                        ch == '.' || ch == ' '){
                            word = wordbuild.toString();
                            //System.out.println("word : "+word+"\n");
                            listOfWords.add(word);
                            wordbuild = new StringBuilder("");
                            this.numOfwords++;
                            continue;
                        }
                        
                        //System.out.println(ch);
                        wordbuild.append(ch);
                    }   

                }

                else{

                    word = line;
                    //System.out.printf("%n Word %s lenght : %,d", word, word.length());
                    WordLenght.put(word, word.length());
                    //System.out.println("word : "+word+"\n");

                        //System.out.println("word : "+word+"\n");
                        //System.out.println(word.length());
                        listOfWords.add(word);

                    

                }

            }
            this.lines = listOfWords;
           // return listOfWords;

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }


        this.lines = listOfWords;
    }
    
}
