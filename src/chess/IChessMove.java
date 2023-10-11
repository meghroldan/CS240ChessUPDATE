package chess;


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

  //FIX LATER
  @Override
  public ChessPiece.PieceType getPromotionPiece() {
    return null;
  }

  public void changeEndPosition(ChessPosition change){
    end = change;
  }
}
