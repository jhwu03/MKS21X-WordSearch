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
      if(word.length() + col >= data[row].length){
        return false;
      }
      int n = 0;
      for(int i = col; i < col + word.length();i++){
        if(data[row][i] != '_' || data[row][i] != word.charAt(i)){
          return false;
      }else{
        data[row][i] = word.charAt(n);
        n = n + 1;
      }
    }
    return true;
  }
  public boolean addWordVertical(String word,int row, int col){
    if(word.length() + row > data.length){
      return false;
    }else{
      int n = 0;
      for(int i = row; i < row + word.length();i++){
        if(data[i][col] != '_' || data[i][col] != word.charAt(i)){
          return false;
        }else{
          data[i][col] = word.charAt(n);
          n = n + 1;
        }
      }
      return true;
    }
  }

}
