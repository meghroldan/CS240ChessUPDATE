package chess;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IChessPosition that=(IChessPosition) o;
    return currRow == that.currRow && currColumn == that.currColumn;
  }

  @Override
  public int hashCode() {
    return Objects.hash(currRow, currColumn);
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
