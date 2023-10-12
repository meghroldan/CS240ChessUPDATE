package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PawnMovementRule implements ValidMovements{

  private Map<ChessPosition, ChessPiece> pieces;
  private Set<ChessMove> validMoves2 = new HashSet<>();
  public PawnMovementRule(){
  }

  @Override
  public Collection<ChessMove> pieceMovesAvailable(ChessBoard board, ChessPosition myPosition) {

    pieces = board.getMyPieces();
    ChessGame.TeamColor currColor = board.getPiece(myPosition).getTeamColor();
    int col = myPosition.getColumn();
    int row = myPosition.getRow();

    ChessPosition tempPos;
    ChessMove tempMov;

    //white pawns
    if(currColor == ChessGame.TeamColor.WHITE){
      if(row == 2){
        tempPos = new IChessPosition(row + 1, col);
        if(board.getPiece(tempPos) == null){
          tempPos = new IChessPosition(row + 2, col);
          if(board.getPiece(tempPos) == null){
            tempMov = new IChessMove(myPosition, tempPos, null);
            validMoves2.add(tempMov);
          }
        }
      }
      if(row + 1 <= 7){
        tempPos = new IChessPosition(row + 1, col);
        if(board.getPiece(tempPos) == null){
          tempMov = new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
      if(row + 1 != 8) {
        tempPos=new IChessPosition(row + 1, col + 1);
        if (row + 1 <= 7 && col + 1 <= 7 && board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
        tempPos=new IChessPosition(row + 1, col - 1);
        if (row + 1 <= 7 && col - 1 >= 1 && board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }

      //promotion white
      if(row + 1 == 8){
        tempPos = new IChessPosition(row + 1, col);
        if(board.getPiece(tempPos) == null){
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
        tempPos = new IChessPosition(row + 1, col + 1);
        if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
        tempPos = new IChessPosition(row + 1, col - 1);
        if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov = new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
      }
    }

    //black pawns
    if(currColor == ChessGame.TeamColor.BLACK){
      if(row == 7){
        tempPos = new IChessPosition(row - 1, col);
        if(board.getPiece(tempPos) == null){
          tempPos = new IChessPosition(row - 2, col);
          if(board.getPiece(tempPos) == null){
            tempMov = new IChessMove(myPosition, tempPos, null);
            validMoves2.add(tempMov);
          }
        }
      }
      if(row - 1 > 1){
        tempPos = new IChessPosition(row - 1, col);
        if(board.getPiece(tempPos) == null){
          tempMov = new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
      if(row - 1 != 1) {
        tempPos=new IChessPosition(row - 1, col + 1);
        if (row - 1 >= 1 && col + 1 <= 7 && board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
        tempPos=new IChessPosition(row - 1, col - 1);
        if (row - 1 >= 1 && col - 1 >= 1 && board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }

      //promotion black
      if(row - 1 == 1){
        tempPos = new IChessPosition(row - 1, col);
        if(board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
        tempPos = new IChessPosition(row - 1, col + 1);
        if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
        tempPos = new IChessPosition(row - 1, col - 1);
        if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.BISHOP);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.ROOK);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.KNIGHT);
          validMoves2.add(tempMov);
          tempMov=new IChessMove(myPosition, tempPos, ChessPiece.PieceType.QUEEN);
          validMoves2.add(tempMov);
        }
      }
    }


    if(validMoves2 == null){
      return null;
    }
    return validMoves2;
  }
}
