package chess;

public class IChessPosition implements ChessPosition{
  int currRow;
  int currColumn;

  public IChessPosition(int row, int col){
    currRow = row;
    currColumn = col;
  }

  @Override
  public int getRow() {
    return currRow;
  }

  @Override
  public int getColumn() {
    return currColumn;
  }

  @Override
  public void setPosition(int row, int column) {
    currColumn = column;
    currRow = row;
  }

  public String toString(){
    StringBuilder temp = new StringBuilder();
    temp.append('(');
    temp.append(currRow);
    temp.append(',');
    temp.append(currColumn);
    temp.append(')');
    return temp.toString();
  }
}
