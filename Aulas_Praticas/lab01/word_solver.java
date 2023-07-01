package lab01;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class word_solver {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);

        if (args.length==0){                                                    //verificação se existem argumentos
            System.out.println("Error: no arguments");
            System.exit(0);
        }

        List<String> sopa = Files.readAllLines(path);
        ArrayList<String> palavras = new ArrayList<String>(); 
        long longnumlines = Files.lines(path).count();
        int numlinessopa = 0;
        for ( int k = 0; k < sopa.size(); k++){
            if(sopa.get(k).equals(sopa.get(k).toUpperCase())){
                numlinessopa++;
            }
        }
        int numlineswords = (int) longnumlines - numlinessopa;
        int numlines = (int) longnumlines - numlineswords;
        char[][] caracter= new char[numlines][numlines];

        
        
        for (int i = 0; i < sopa.size(); i++) {
            String line = sopa.get(i);
            if (i < numlines) {
                char[] letras = line.toCharArray();
                caracter[i] = letras;
            } else {
                String[] lineWords = line.split("[; ,]+");
                palavras.addAll(Arrays.asList(lineWords));
            }
        }
        palavras.removeAll(Collections.singleton(""));
        
        if (isEmpty(sopa)){
            System.out.println("Existe uma linha em branco");
            System.exit(1);
        }

        for (int k = 0; k < numlines; k++) { 
            for (int n = 0; n < numlines; n++){
               System.out.printf("%2s",caracter[k][n]);
            }
            System.out.printf("\n");
        }
        
        for (int i = 0; i < palavras.size(); i++){
            for (int j =i+1; j < palavras.size(); j++){
                String palavra1= palavras.get(i);
                String palavra2= palavras.get(j);
                if (palavra1.contains(palavra2) || palavra2.contains(palavra1)){
                    if (palavra1.length()>palavra2.length()){
                        palavras.remove(j);
                        j--;
                    }
                    else{
                        palavras.remove(i);
                        i--;
                    }
                }   
            }
        }
        
        if (numlines> 40 || numlines < 0){
            System.out.println("A palavra nao esta no intervalo de 0 a 40, ultrapassou o limite");
        }

        if (square(caracter) == false){
            System.out.println("A sopa de letras nao e quadrada, nao tem tamanho  x*x");
            System.exit(1);
        }
        
        if (isUpper(numlines,caracter) == false){
            System.out.println("As letras nao estao em maiusculas"); 
            System.exit(1);
        }

        if (isAlphabetic(palavras) == false){
            System.out.println("As letras nao sao alfabeticas");
            System.exit(1);
        }   

        if (isLower(palavras) == false){
            System.out.println("Existe uma palavra com letras maiusculas");
            System.exit(1);
        }

        if (BiggerThan3(palavras) == false){
            System.out.println("O numero de caracteres em algumas palavras e menor que 3");
            System.exit(1);
        }

        for(int i= 0;i < palavras.size(); i++){
            palavras.set(i, palavras.get(i).toUpperCase());
        }
        System.out.println("\n");
        System.out.println("As coordenadas comecam no 0,0");
        System.out.println("\n");
        char[][] resultado = new char[numlines][numlines];
        for (int i = 0; i < numlines; i++) {
            for (int j = 0; j < numlines; j++) {
                resultado[i][j] ='.';
            }
        }
        


        System.out.println("\n");
        for (String palavra : palavras){
            for (int linha = 0; linha < numlines; linha++) { 
                for (int coluna = 0; coluna < numlines; coluna++){
                   if (caracter[linha][coluna] == palavra.charAt(0)){
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, 0)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha+k][coluna] = caracter[linha+k][coluna];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, 1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down-Rigth");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha+k][coluna+k] = caracter[linha+k][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 0, 1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Right");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha][coluna+k] = caracter[linha][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, 1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Up-Right");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna+k] = caracter[linha-k][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, 0)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Up");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna] = caracter[linha-k][coluna];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, -1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Left-Up");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna-k] = caracter[linha-k][coluna-k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 0, -1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Left");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha][coluna-k] = caracter[linha][coluna-k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, -1)){
                            System.out.println(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down-Left");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha+k][coluna-k] = caracter[linha+k][coluna-k];
                            }
                            continue;
                        }
                   }
                }
            }
        }
        System.out.println("\n");
        for (int i = 0; i < numlines; i++) {
            for (int j = 0; j < numlines; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
        String number = "";
        for (int i = 0; i < args[0].length(); i++) {
            if (args[0].charAt(i)>='0' && args[0].charAt(i)<='9') {
                number += args[0].charAt(i);
            }
        }
        String fileName = "sopa"+number.charAt(2)+"_result.txt";

    try (FileWriter fw = new FileWriter("lab01/" + fileName, true)) {
        // Limpa o arquivo, caso já exista
        new FileWriter(fileName, false).close();
    
        // Escreve as letras da sopa de letras
        for (char[] row : caracter) {
            for (char letter : row) {
                fw.write(letter + " ");
            }
            fw.write(System.lineSeparator());
        }
        fw.write(System.lineSeparator());
    
        fw.write("\n");


        // Escreve as palavras a encontrar
        fw.write("Palavras a encontrar: " + System.lineSeparator());
        for (String word : palavras) {
            fw.write(word + System.lineSeparator());
        }
        fw.write(System.lineSeparator());



        fw.write("\n");
        fw.write("As coordenadas comecam no 0,0");
        fw.write("\n");
        fw.write("\n");
        for (String palavra : palavras){
            for (int linha = 0; linha < numlines; linha++) { 
                for (int coluna = 0; coluna < numlines; coluna++){
                   if (caracter[linha][coluna] == palavra.charAt(0)){
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, 0)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down");
                            fw.write("\n");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha+k][coluna] = caracter[linha+k][coluna];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, 1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down-Rigth");
                            fw.write("\n");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha+k][coluna+k] = caracter[linha+k][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 0, 1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Right");
                            fw.write("\n");
                            for (int k = 0; k < palavra.length(); k++) {
                                resultado[linha][coluna+k] = caracter[linha][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, 1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Up-Right");
                            fw.write("\n");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna+k] = caracter[linha-k][coluna+k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, 0)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Up");
                            fw.write("\n");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna] = caracter[linha-k][coluna];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, -1, -1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Left-Up");
                            fw.write("\n");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha-k][coluna-k] = caracter[linha-k][coluna-k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 0, -1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Left");
                            fw.write("\n");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha][coluna-k] = caracter[linha][coluna-k];
                            }
                            continue;
                        }
                        if (isInside(numlines, caracter, palavra, linha, coluna, 1, -1)){
                            fw.write(palavra + " " + palavra.length() + " " + linha + "," + coluna + " " + "Down-Left");
                            fw.write("\n");
                            for(int k = 0; k < palavra.length(); k++){
                                resultado[linha+k][coluna-k] = caracter[linha+k][coluna-k];
                            }
                            continue;
                        }
                   }
                }
            }
        }
        fw.write("\n");
        for (int i = 0; i < numlines; i++) {
            for (int j = 0; j < numlines; j++) {
                fw.write(resultado[i][j] + " ");
            }
            fw.write("\n");
        }
    } catch (IOException e) {
        // Tratar a exceção, se necessário
    }

    
    }        

    public static boolean isInside(int numlines, char[][] caracter, String palavra, int linha, int coluna, int incrementoLinha, int incrementoColuna){
        for(int i= 0; i < palavra.length(); i++){
            if (linha < 0 || linha >= numlines || coluna < 0 || coluna >= numlines || caracter[linha][coluna] != palavra.charAt(i)){
                return false;
            }
            
            linha+=incrementoLinha;
            coluna+=incrementoColuna;
        }
        return true;
    }

    public static boolean square(char[][] array) { 
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length) {
                return false;
            }     
        }
        return true;
    }
   
  
    public static boolean isUpper(int numlines, char[][] caracter){
        for (int i = 0; i < numlines; i++) {
            for (int j = 0; j < numlines; j++) {
                if (Character.isLowerCase(caracter[i][j])){  
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLower(ArrayList<String> palavras){
        for (int i = 0; i < palavras.size(); i++) {
            if (palavras.get(i) == palavras.get(i).toUpperCase()) {
                return false;
              }
            }
        
        return true;
    }

    
    public static boolean isAlphabetic(ArrayList<String> palavras){
        for (int i = 0; i < palavras.size(); i++) {
            for(int j= 0; j < palavras.get(i).length(); j++){
                if (!Character.isAlphabetic(palavras.get(i).charAt(j))){         
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean BiggerThan3(ArrayList<String> palavras){
        for (int i = 0; i < palavras.size(); i++) {
            int length = palavras.get(i).length();
            if (length < 3){
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(List<String> sopa){
        for (String linha : sopa){
            if (linha.isEmpty()){
                return true;
            }
        }
        return false;
    }
}

