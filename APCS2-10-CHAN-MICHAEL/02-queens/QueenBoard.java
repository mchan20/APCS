public class QueenBoard {
  private int[][]board;
  private int size;
  //number = -1 (queen)
  //number = 0 (empty)
  //number > 0 (the number of queens that attack the space)
  private boolean addQueen(int r, int c)  {
    int tempr = r-1;
    int tempc = c-1;
    if (board[r][c] == 0) {
      for (int i=0; i<board.length;i++) {
        board[r][i]++;
        board[i][c]++;
      }
      while(tempr >= 0 && tempc >= 0) {
        board[tempr][tempc]++;
        tempr--;
        tempc--;
      }
      tempr = r+1;
      tempc = c+1;
      while(tempr < board.length && tempc < board.length) {
        board[tempr][tempc]++;
        tempr++;
        tempc++;
      }
      tempr = r+1;
      tempc = c-1;
      while(tempr < board.length && tempc >= 0) {
        board[tempr][tempc]++;
        tempr++;
        tempc--;
      }
      tempr = r-1;
      tempc = c+1;
      while(tempr >= 0 && tempc < board.length) {
        board[tempr][tempc]++;
        tempr--;
        tempc++;
      }
      board[r][c] = -1;
      return true;
    }
    else {
      return false;
    }
  }

  private void removeQueen(int r, int c) {
    int tempr = r-1;
    int tempc = c-1;
    for (int i=0; i<board.length;i++) {
      board[r][i]--;
      board[i][c]--;
    }
    while(tempr >= 0 && tempc >= 0) {
      board[tempr][tempc]--;
      tempr--;
      tempc--;
    }
    tempr = r+1;
    tempc = c+1;
    while(tempr < board.length && tempc < board.length) {
      board[tempr][tempc]--;
      tempr++;
      tempc++;
    }
    tempr = r+1;
    tempc = c-1;
    while(tempr < board.length && tempc >= 0) {
      board[tempr][tempc]--;
      tempr++;
      tempc--;
    }
    tempr = r-1;
    tempc = c+1;
    while(tempr >= 0 && tempc < board.length) {
      board[tempr][tempc]--;
      tempr--;
      tempc++;
    }
    board[r][c] = 0;
  }

  public QueenBoard(int size){
    this.size = size;
    board = new int[size][size];
    // for (int i=0;i<size;i++) {
    //   for (int j=0;j<size;j++) {
    //     board[i][j] = 0;
    //   }
    // }
  }

  public String toString(){
    String result = "";
    for (int i=0;i<size;i++) {
      for (int j=0;j<size;j++) {
        if (board[i][j] == -1) result = result + ("Q");
        else result = result + "_";
        if (j != (size-1)) result = result + (" ");
        else if (i != size-1) {
          result = result + "\n";
        }
      }
    }
    return result;
  }

  public boolean solve(){
    if (isNotEmpty()) throw new IllegalStateException("The board is not empty.");
    return solve(0);
  }

  public boolean solve(int col){
    if (col == size) {
      return true;
    }
    for (int i = 0; i < size; i++) {
      if (addQueen(i,col)) {
        if (solve(col+1)) return true;
        removeQueen(i,col);
      }
    }
    return false;
  }

  public int countSolutions(){
    if (isNotEmpty()) throw new IllegalStateException("The board is not empty.");
    return countSolutions(0);
  }

  public int countSolutions(int col){
    int count = 0;
    if (col == size) {
      return 1;
    }
    for (int i = 0; i < size; i++) {
      if (addQueen(i,col)) {
        count += countSolutions(col+1);
        removeQueen(i,col);
      }
    }
    return count;
  }

  public boolean isNotEmpty() {
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board.length;j++) {
        if (board[i][j] != 0) return true;
      }
    }
    return false;
  }

  // public static void main(String[] args) {
  //   QueenBoard thing = new QueenBoard(5);
  //   // thing.addQueen(0,0);
  //   // thing.addQueen(7,8);
  //   // thing.addQueen(2,7);
  //   System.out.println(thing.toString());
  //   // System.out.println();
  //   // thing.removeQueen(7,8);
  //   // System.out.println(thing.solve());
  //   thing.solve();
  //   // System.out.println(thing.countSolutions());
  //   System.out.println(thing.toString());
  //   // thing.solve();
  // }
}
