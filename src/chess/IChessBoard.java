package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IChessBoard implements ChessBoard{
  Map<ChessPosition,ChessPiece> myPieces = new HashMap<ChessPosition,ChessPiece>();

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
    for(Map.Entry<ChessPosition, ChessPiece> entry : myPieces.entrySet()) {
      if(entry.getKey().equals(position)){
        return entry.getValue();
      }
    }
    return null;
  }

  public void removePiece(ChessPosition pos, ChessPiece pie){
    myPieces.remove(pos, pie);
  }

  //do once pieces types are set
  @Override
  public void resetBoard() {
    myPieces.clear();
    for(int column = 1; column <= 8; column++){
      ChessPiece tempW = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
      ChessPiece tempB = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
      ChessPosition white = new IChessPosition(2, column);
      ChessPosition black = new IChessPosition(7, column);
      myPieces.put(white, tempW);
      myPieces.put(black, tempB);
      if(column == 1 || column == 8){
        ChessPiece tempWR = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        ChessPiece tempBR = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        ChessPosition whiteR = new IChessPosition(1, column);
        ChessPosition blackR = new IChessPosition(8, column);
        myPieces.put(whiteR, tempWR);
        myPieces.put(blackR, tempBR);
      }
      if(column == 2 || column == 7){
        ChessPiece tempWN = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        ChessPiece tempBN = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        ChessPosition whiteN = new IChessPosition(1, column);
        ChessPosition blackN = new IChessPosition(8, column);
        myPieces.put(whiteN, tempWN);
        myPieces.put(blackN, tempBN);
      }
      if(column == 3 || column == 6){
        ChessPiece tempWB = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        ChessPiece tempBB = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        ChessPosition whiteB = new IChessPosition(1, column);
        ChessPosition blackB = new IChessPosition(8, column);
        myPieces.put(whiteB, tempWB);
        myPieces.put(blackB, tempBB);
      }
      if(column == 4){
        ChessPiece tempWQ = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        ChessPiece tempBQ = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        ChessPosition whiteQ = new IChessPosition(1, column);
        ChessPosition blackQ = new IChessPosition(8, column);
        myPieces.put(whiteQ, tempWQ);
        myPieces.put(blackQ, tempBQ);
      }
      if(column == 5){
        ChessPiece tempWK = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        ChessPiece tempBK = new IChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        ChessPosition whiteK = new IChessPosition(1, column);
        ChessPosition blackK = new IChessPosition(8, column);
        myPieces.put(whiteK, tempWK);
        myPieces.put(blackK, tempBK);
      }

    }

  }
}
