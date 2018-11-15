import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class WordSearch{
  private char[][]data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;

  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    for(int i = 0; i < data.length;i++){
      for(int n = 0; n < data[i].length;n = n + 1){
        data[i][n] = '_';
      }
    }
  }

  public WordSearch( int rows, int cols, String fileName, int rseed){
    data = new char[rows][cols];
    clear();
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    try{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        String word = in.next();
        word = word.toUpperCase();
        wordsToAdd.add(word);
      }
    }catch(FileNotFoundException e){
      System.out.println("file" + fileName + "not found");
      System.exit(1);
    }
    randgen = new Random(rseed);
    seed = rseed;
    //addAllWords();
  }

  public WordSearch( int rows, int cols, String fileName){
    data = new char[rows][cols];
    clear();
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    try{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word);
      }
    }catch(FileNotFoundException e){
      System.out.println("file" + fileName + "not found");
      System.exit(1);
    }
    seed = (int)(Math.random()*100000);
    randgen = new Random(seed);
    //addAllWords();
  }

  private void clear(){
      for (int i = 0; i < data.length; i++){
        for (int n = 0; n < data[i].length; n++){
          data[i][n] = '_';
        }
      }
    }

   public String toString(){
      String ans = "";
      for (int i = 0; i < data.length; i++){
        ans += "|";
        for (int n = 0; n < data[i].length - 1; n++){
          ans = ans + data[i][n] + " ";
        }
        ans = ans + data[i][data[i].length - 1] + "|\n";
      }
      return ans + "\n" + "seed:" + seed + " ";
    }

    public boolean addWordHorizontal(String word,int row, int col){
      if(word.length() > data[row].length - col){
        return false;
      }
      int n = col;
      for(int i = 0; i < word.length();i++){
        if(data[row][n] != '_' && data[row][n] != word.charAt(i)){
          return false;
        }
        n = n + 1;
      }
      for(int i = 0; i < word.length(); i++){
        data[row][col] = word.charAt(i);
        col = col + 1;
      }
      return true;
    }

  public boolean addWordVertical(String word,int row, int col){
    if(word.length() > data.length - row ){
      return false;
    }
    int n = row;
    for(int i = 0; i < word.length();i++){
      if(data[n][col] != '_' && data[n][col] != word.charAt(i)){
        return false;
      }
      n = n + 1;
    }
    for(int i = 0; i < word.length(); i++){
      data[row][col] = word.charAt(i);
      row = row + 1;
    }
    return true;
  }

  public boolean addWordDiagonal(String word, int row, int col){
    if ( word.length() > data.length - row || word.length() > data[0].length - col){
      return false;
    }
    int n = col;
    int j = row;
    for(int i = 0; i < word.length();i++){
      if(data[j][n] != '_' && data[j][n] != word.charAt(i)){
        return false;
      }
      n = n + 1;
      j = j + 1;
    }
    for(int i = 0; i < word.length(); i++){
      data[row][col] = word.charAt(i);
      row = row + 1;
      col = col + 1;
    }
    return true;
  }
  public boolean addWord( String word, int r, int c, int rowIncrement, int colIncrement){
    word = word.toUpperCase();
    if(rowIncrement == 0 && colIncrement == 0){
      return false;
    }
    if(rowIncrement == 1 && data.length < word.length() + r){
         return false;
       }
    if (colIncrement == 1 && data[r].length < word.length() + c){
         return false;
       }
    if (rowIncrement == -1 && r < word.length() - 1 ){
         return false;
       }
    if (colIncrement == -1 && c < word.length() - 1 ){
         return false;
       }
    for (int i = 0; i < word.length(); i ++){
     int r1 = r + (i * rowIncrement);
     int c1 = c + (i * colIncrement);
     if (data[r1][c1] != word.charAt(i) && data[r1][c1] != '_') {
       return false;
     }
   }
    for(int i = 0; i < word.length(); i ++){
      int r1 = r + (i * rowIncrement);
      int c1 = c + (i * colIncrement);
      data[r1][c1] = word.charAt(i);
    }
    return true;
  }
  public void addAllWords(){
    int a = 0;
    while(a < 1000 && wordsToAdd.size() > 0){
      int rowi = randgen.nextInt(3) - 1;
      int coli = randgen.nextInt(3) - 1;
      int row = Math.abs(randgen.nextInt() % data.length);
      int col = Math.abs(randgen.nextInt() % data[0].length);
      String word = wordsToAdd.get(Math.abs(randgen.nextInt() % wordsToAdd.size()));
      if(!addWord(word,row,col,rowi,coli)){
        a = a + 1;
      }else{
        a = 0;
        wordsToAdd.remove(word);
        wordsAdded.add(word);
      }
    }
  }

  public static void main(String[] args) {

  }

}
