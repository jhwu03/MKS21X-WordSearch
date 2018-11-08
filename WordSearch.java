public class WordSearch{
  private char[][]data;

  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    for(int i = 0; i < data.length;i++){
      for(int n = 0; n < data[i].length;n = n + 1){
        data[i][n] = '_';
      }
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
        for (int n = 0; n < data[i].length; n++){
          ans = ans + " " + data[i][n];
        }
        ans = ans + "\n";
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

}
