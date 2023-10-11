package chess;

import java.util.Map;
import java.util.TreeMap;

public class IChessBoard implements ChessBoard{
  Map<ChessPosition,ChessPiece> myPieces = new TreeMap<ChessPosition,ChessPiece>();

  /**
   * Adds a chess piece to the chessboard
   *
   * @param position where to add the piece to
   * @param piece    the piece to add
   */
  @Override
  public void addPiece(ChessPosition position, ChessPiece piece){
    myPieces.put(position, piece);
  }

  @Override
  public ChessPiece getPiece(ChessPosition position) {
    return myPieces.get(position);
  }

  //do once pieces types are set
  @Override
  public void resetBoard() {

  }
}
