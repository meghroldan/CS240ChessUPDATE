package chess;


import java.util.Objects;

public class IChessMove implements ChessMove{


  ChessPosition start;
  ChessPosition end;
  ChessPiece.PieceType canIt;


  public IChessMove(ChessPosition first, ChessPosition second, ChessPiece.PieceType promotion){
    canIt = promotion;
    start = first;
    end = second;
  }

  @Override
  public ChessPosition getStartPosition() {
    return start;
  }

  @Override
  public ChessPosition getEndPosition() {
    return end;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IChessMove that=(IChessMove) o;
    return Objects.equals(start, that.start) && Objects.equals(end, that.end) && canIt == that.canIt;
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end, canIt);
  }

  //FIX LATER
  @Override
  public ChessPiece.PieceType getPromotionPiece() {
    return null;
  }

  public void changeEndPosition(ChessPosition change){
    end = change;
  }
}
