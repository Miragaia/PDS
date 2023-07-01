import java.util.Random;

public class SortWords {
    private Words words = null;
    int size; char[][] grid = null;
    int randomOrientation, randomPosition;
    Random generator = new Random();
    WordsMatchRecord wm = null;
    public  SortWords(Words w, WordsMatchRecord wm, int size, char[][] grid){
        this.words = w;
        this.wm = wm;
        this.size = size;
        this.grid = grid;
    }

    public void sortOrientations(){
        int enumIndex = 0;
        for(String word : this.words.getList()){
            //System.out.println("\nWord : "+word+"\n");
            randomOrientation = generator.nextInt(WordOrientation.values().length);

            for(WordOrientation o : WordOrientation.values()){
                if(enumIndex == randomOrientation){
                    //System.out.println("Word : "+word+" Orientation : "+o);
                    wm.setWordsOrietation(word, o);
                }
                enumIndex++;
            }

            enumIndex = 0;
        }
    }


    public void setPositions(String word){
        int x,xInitial,y,yInitial, wordIndex = 0; boolean validSpace = true;
        char ch ; final int len = word.length();

            switch (wm.getWordsOrietation().get(word)) {

                case LEFT_RIGHT:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(xInitial >= size){
                        while(xInitial >= size){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    if(yInitial >= size || ( yInitial + len ) >= size){
                        while(yInitial >= size || ( yInitial + len ) >= size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    while(wordIndex < word.length()){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        y++;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println();
                    //System.out.println("\nLEFT_RIGHT : ");
                    //System.out.printf("%s : [%,d , %,d] ",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex < len){
                        //stem.out.println("index = "+wordIndex);
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        //grid[x][y] = word.charAt(wordIndex);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        y++;
                        wordIndex++;
                    }

                    break;


                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


                case RIGHT_LEFT:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(xInitial >= size){
                        while(xInitial >= size){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    if(yInitial >= size || ( yInitial - len )  < 0 ){
                        while(yInitial >= size || ( yInitial - len )  < 0 ){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = word.length() - 1;
                    while(wordIndex >= 0){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        y--;
                        wordIndex--;
                        
                    }
                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\nRIGHT_LEFT : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = word.length() - 1;

                    while(wordIndex >= 0){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);

                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));                        
                        y--;
                        wordIndex--;
                    }
                    
                    break;


                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


                case UP_DOWN:
                xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(yInitial >= size){
                        while(yInitial >= size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    if(xInitial >= size || ( xInitial + len )  > size ){
                        while(xInitial >= size || ( xInitial + len )  > size ){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = 0;
                    while(wordIndex < len){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x++;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\nUP_DOWN : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex > len){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x++;
                        wordIndex++;
                    }


                    //System.out.println("\nUP_DOWN");
                    
                break;
                
                case DOWN_UP:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(yInitial >= size){
                        while(yInitial >= size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    if(xInitial >= size || ( xInitial - len )  < 0 ){
                        while(xInitial >= size || ( xInitial - len )  < 0 ){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = word.length() - 1;
                    while(wordIndex >= 0){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x--;
                        wordIndex--;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\nDOWN_UP : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = word.length() - 1;

                    while(wordIndex >= 0){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x--;
                        wordIndex--;
                    }


                    
                    break;    
            
                case TOP_LEFT_BOTTOM_RIGHT:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(yInitial >= size || ( yInitial + len )  > size ){
                        while(yInitial >= size || ( yInitial + len )  > size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    if(xInitial >= size || ( xInitial + len )  > size ){
                        while(xInitial >= size || ( xInitial + len )  > size){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = 0;
                    while(wordIndex < len){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x++; y++;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\nTOP_LEFT_BOTTOM_RIGHT : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex < len){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x++; y++;
                        wordIndex++;
                    }



                    break;

                    case TOP_RIGHT_BOTTOM_LEFT:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(yInitial >= size || ( yInitial - len )  < 0 ){
                        while(yInitial >= size || ( yInitial - len )  < 0){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    if(xInitial >= size || ( xInitial + len )  > size ){
                        while(xInitial >= size || ( xInitial + len )  > size){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = 0;
                    while(wordIndex < len){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x++; y--;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\n TOP_RIGHT_BOTTOM_LEFT : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex < len){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x++; y--;
                        wordIndex++;
                    }


                    break;

                    case  BOTTOM_LEFT_TOP_RIGHT:

                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(xInitial >= size || ( xInitial - len )  < 0 ){
                        while(xInitial >= size || ( xInitial - len )  < 0){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    if(yInitial >= size || ( yInitial + len )  > size ){
                        while(yInitial >= size || ( yInitial + len )  > size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = 0;
                    while(wordIndex < len){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x--; y++;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\n BOTTOM_LEFT_TOP_RIGHT : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex < len){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x--; y++;
                        wordIndex++;
                    }

                    break;

                    case BOTTOM_RIGHT_TOP_LEFT:
                    xInitial = generator.nextInt(size);
                    yInitial = generator.nextInt(size);

                    if(xInitial >= size || ( xInitial - len )  < 0 ){
                        while(xInitial >= size || ( xInitial - len )  < 0){
                            xInitial = generator.nextInt(size);
                        }
                    }

                    if(yInitial >= size || ( yInitial + len )  > size ){
                        while(yInitial >= size || ( yInitial + len )  > size){
                            yInitial = generator.nextInt(size);
                        }
                    }

                    //Primeiro : verificar se todo o word.lenght espaço na linha x
                    //É vazio para preencher a word
                    x = xInitial; y = yInitial;
                    wordIndex = 0;
                    while(wordIndex < len){
                        //System.out.printf("%niteration : %,d %s : [%,d , %,d] ",iteration,word, x, y);
                        //iteration++;

                        ch = grid[x][y];
                        
                        //Se aquele espaço já tiver uma letra
                        //Procuras por outro recursivamente
                        if(ch != '.'){
                            //System.out.println("Exiting space...");
                            setPositions(word);
                            validSpace = false;
                            break;
                        }

                        x--; y++;
                        wordIndex++;
                        
                    }

                    if(validSpace == false){
                        break;
                    }

                    //Segundo: ao achar um espaço totalmente vazio do tamanho
                    //da palavra, inicia-se o preenchimento
                    //System.out.println("\n BOTTOM_RIGHT_TOP_LEFT : ");

                    //System.out.printf("%s : [%,d , %,d] %n",word, xInitial, yInitial);
                    x = xInitial; y = yInitial;
                    wordIndex = 0;

                    while(wordIndex < len){
                        //System.out.print(word.charAt(wordIndex));
                        //System.out.printf("%n [%,d , %,d]", x,y);
                        grid[x][y] = Character.toUpperCase(word.charAt(wordIndex));
                        x--; y++;
                        wordIndex++;
                    }


                    break;
                
                    default:
                    break;
            }

        }
    
    
    }
