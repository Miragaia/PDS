package lab01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WSGenerator {
    public static void main(String[] args) throws IOException {

        int argvalue= 0;
        int argtamanho = 0;
        String argficheiroInput = "";
        String argficheiroOutput = "";
        String direcao = "";

        if (args.length==0){                                                    //verificação se existem argumentos
            System.out.println("Error: no arguments");
            System.exit(0);
        }

        for (String arg : args) {
            switch(arg){
                case "-i":
                    argvalue++;
                    argficheiroInput = args[argvalue];
                    break;
                case "-s":
                    argvalue++;
                    argtamanho = Integer.parseInt(args[argvalue]);
                    break;
                case "-o":
                    argvalue++;
                    argficheiroOutput = args[argvalue];
                    break;
                default:
                    argvalue++;
                    break;
            }
        }
        
        Path path = Paths.get(argficheiroInput);
        List<String> ficheiro = Files.readAllLines(path);
        ArrayList<String> argpalavras = new ArrayList<String>();
        for (int k =0; k < ficheiro.size(); k++){
            String line = ficheiro.get(k);
            String[] lineWords = line.split("[,;\\s]+");
            argpalavras.addAll(Arrays.asList(lineWords));
        }
        argpalavras.removeAll(Collections.singleton(""));
        
        for (int i = 0; i < argpalavras.size(); i++) {
            argpalavras.set(i, argpalavras.get(i).toUpperCase());
        } 

        char[][] tabela = new char[argtamanho][argtamanho];

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] posicaoInicial = new int[2]; //0 = linha, 1 = coluna
        
        for(String palavra : argpalavras){
            int attempts = 0;
            while(true){
                attempts++;
                int numdirecao = (int) (Math.random() * ( 8 -1 ) + 1);
                switch(numdirecao){
                    case 1:
                        direcao = "up";
                        break;
                    case 2:
                        direcao = "down";
                        break;
                    case 3:
                        direcao = "left";
                        break;
                    case 4:
                        direcao = "right";
                        break;
                    case 5:
                        direcao = "upleft";
                        break;
                    case 6:
                        direcao = "upright";
                        break;
                    case 7:
                        direcao = "downleft";
                        break;
                    case 8:
                        direcao = "downright";
                        break;
                }
                posicaoInicial = getPosicaoInicial(argtamanho, palavra.length(), direcao);
                if(wordsLimit(palavra.toCharArray(), posicaoInicial, tabela, direcao)){
                    tabela = addWord(palavra.toCharArray(), posicaoInicial, tabela, direcao);
                    break;
                }
                if(attempts == 10000){
                    System.out.println("Error: Could not add word " + palavra + " to the tabela after 10000 attempts");
                    System.exit(1);
                }

            }
            
        }
        
    // Create a random object to generate random letters for empty cells
    Random random = new Random();

    // If no filename is provided, set a default one
    if (argficheiroOutput == null || argficheiroOutput.isEmpty()) {
        argficheiroOutput = "sopa.txt";
    }

    // Write the table to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(argficheiroOutput))) {
        for (int y = 0; y < argtamanho; y++) {
            for (int x = 0; x < argtamanho; x++) {
                if (x % argtamanho == 0 && y != 0) {                             // If it reaches the size, insert a new line
                    writer.write("\n");
                }

                char letter = Character.toUpperCase(tabela[y][x]);              // Use uppercase for all letters

            if (letter == '\u0000') {                                           // If the cell is empty, insert a random uppercase letter
                    letter = Character.toUpperCase(alphabet[random.nextInt(alphabet.length)]);
                }

                writer.write(letter);
            }
        }
        writer.write("\n");

        
        for (String word : argpalavras) {                                          // Write the word list separated by semicolons
            writer.write(word + "\n");
        }
    } catch (IOException e) {
        throw new RuntimeException("Failed to write word soup to file", e);
    }
}


private static int[] getPosicaoInicial(int argtamanho, int tamanhoPalavra, String direcao){
    int[] posicaoInicial = new int[2]; //0 = linha, 1 = coluna
    Random newRandom = new Random();
    switch(direcao){
        case "up":
            posicaoInicial[0] = newRandom.nextInt(argtamanho);
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            break;

        case "down":
            posicaoInicial[0] = newRandom.nextInt(argtamanho);
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            break;

        case "left":
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            posicaoInicial[1] = newRandom.nextInt(argtamanho);
            break;

        case "right":
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            posicaoInicial[1] = newRandom.nextInt(argtamanho);
            break;

        case "upleft":
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            break;

        case "upright":
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            break;

        case "downleft":
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra) + tamanhoPalavra;
            break;

        case "downright":
            posicaoInicial[0] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            posicaoInicial[1] = newRandom.nextInt(argtamanho - tamanhoPalavra);
            break;
    }
    return posicaoInicial;
}

private static boolean wordsLimit(char[] word, int[] posicaoInicial, char[][] tabela, String direction){ //tentei fazer de maneira diferente ns se dá
    int yChange = 0;
    int xChange = 0;

    switch(direction){
        case "up":
            yChange = -1;
            break;
        case "down":
            yChange = 1;
            break;
        case "left":
            xChange = -1;
            break;
        case "right":
            xChange = 1;
            break;
        case "upleft":
            yChange = -1;
            xChange = -1;
            break;
        case "upright":
            yChange = -1;
            xChange = 1;
            break;
        case "downleft":
            yChange = 1;
            xChange = -1;
            break;
        case "downright":
            yChange = 1;
            xChange = 1;
            break;
        default:
            return false;
    }

    for(int i = 0; i < word.length; i++){
        int y = posicaoInicial[1] + (i * yChange);
        int x = posicaoInicial[0] + (i * xChange);
        if(y < 0 || y >= tabela.length || x < 0 || x >= tabela[y].length || tabela[y][x] != '\u0000' && tabela[y][x] != word[i]){
            return false;
        }
    }
    return true;
}

private static char[][] addWord(char[] word, int[] posicaoInicial, char[][] tabela, String direcao){
    switch(direcao){
        case "up":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]-i][posicaoInicial[0]] = word[i];
            }
            break;
        case "down":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]+i][posicaoInicial[0]] = word[i];
            }
            break;
        
        case "left":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]][posicaoInicial[0]-i] = word[i];
            }
            break;

        case "right":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]][posicaoInicial[0]+i] = word[i];
            }
            break;

        case "upleft":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]-i][posicaoInicial[0]-i] = word[i];
            }
            break;

        case "upright":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]-i][posicaoInicial[0]+i] = word[i];
            }
            break;

        case "downleft":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]+i][posicaoInicial[0]-i] = word[i];
            }
            break;

        case "downright":
            for(int i = 0; i < word.length; i++){
                tabela[posicaoInicial[1]+i][posicaoInicial[0]+i] = word[i];
            }
            break;
    }
    return tabela;
}

        
        
}