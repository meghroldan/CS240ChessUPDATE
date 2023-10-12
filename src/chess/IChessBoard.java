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
    myPieces.clear();
    for(int column = 1; column <= 8; column++){
      IChessPiece tempW = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
      IChessPiece tempB = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
      IChessPosition white = new IChessPosition(2, column);
      IChessPosition black = new IChessPosition(7, column);
      myPieces.put(white, tempW);
      myPieces.put(black, tempB);
      if(column == 1 || column == 8){
        IChessPiece tempWR = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        IChessPiece tempBR = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        IChessPosition whiteR = new IChessPosition(1, column);
        IChessPosition blackR = new IChessPosition(8, column);
        myPieces.put(whiteR, tempWR);
        myPieces.put(blackR, tempBR);
      }
      if(column == 2 || column == 7){
        IChessPiece tempWN = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        IChessPiece tempBN = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        IChessPosition whiteN = new IChessPosition(1, column);
        IChessPosition blackN = new IChessPosition(8, column);
        myPieces.put(whiteN, tempWN);
        myPieces.put(blackN, tempBN);
      }
      if(column == 3 || column == 6){
        IChessPiece tempWB = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        IChessPiece tempBB = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        IChessPosition whiteB = new IChessPosition(1, column);
        IChessPosition blackB = new IChessPosition(8, column);
        myPieces.put(whiteB, tempWB);
        myPieces.put(blackB, tempBB);
      }
      if(column == 4){
        IChessPiece tempWQ = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        IChessPiece tempBQ = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        IChessPosition whiteQ = new IChessPosition(1, column);
        IChessPosition blackQ = new IChessPosition(8, column);
        myPieces.put(whiteQ, tempWQ);
        myPieces.put(blackQ, tempBQ);
      }
      if(column == 5){
        IChessPiece tempWK = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        IChessPiece tempBK = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        IChessPosition whiteK = new IChessPosition(1, column);
        IChessPosition blackK = new IChessPosition(8, column);
        myPieces.put(whiteK, tempWK);
        myPieces.put(blackK, tempBK);
      }

    }

  }
}
