package chess;

public class IChessPosition implements ChessPosition{
  int currRow;
  int currColumn;
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
}
