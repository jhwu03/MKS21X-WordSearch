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
  public WordSearch( int rows, int cols, String fileName){
    data = new char[rows][cols];
    for(int i = 0; i < data.length;i++){
      for(int n = 0; n < data[i].length;n = n + 1){
        data[i][n] = '_';
      }
    }
    try{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
    }catch(FileNotFoundException e){
      System.out.println("file" + fileName + "not found");
      System.exit(1);
    }
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
          ans = ans + " " + data[i][n];
        }
        ans = ans + data[i][data[i].length - 1] + "|\n";
      }
      return ans;
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
}
