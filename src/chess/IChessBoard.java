package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IChessBoard implements ChessBoard{
  Map<IChessPosition,IChessPiece> myPieces = new HashMap<IChessPosition,IChessPiece>();

  /**
   * Adds a chess piece to the chessboard
   *
   * @param position where to add the piece to
   * @param piece    the piece to add
   */
  @Override
  public void addPiece(ChessPosition position, ChessPiece piece){
    myPieces.put((IChessPosition) position, (IChessPiece) piece);
  }

  @Override
  public ChessPiece getPiece(ChessPosition position) {
    return myPieces.get(position);
  }

  public void removePiece(ChessPosition pos, ChessPiece pie){
    myPieces.remove(pos, pie);
  }

  //do once pieces types are set
  @Override
  public void resetBoard() {

  }
}
