package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KingMovementRule implements ValidMovements{
  private Map<ChessPosition, ChessPiece> pieces;
  private Set<ChessMove> validMoves2 = new HashSet<>();
  public KingMovementRule(){
  }

  @Override
  public Collection<ChessMove> pieceMovesAvailable(ChessBoard board, ChessPosition myPosition) {
    pieces = board.getMyPieces();
    ChessGame.TeamColor currColor = board.getPiece(myPosition).getTeamColor();
    int col = myPosition.getColumn();
    int row = myPosition.getRow();

    ChessPosition tempPos;
    ChessMove tempMov;
    if(col + 1 < 9){
      tempPos = new IChessPosition(row, col + 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(row + 1 < 9){
      tempPos = new IChessPosition(row + 1, col);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(row - 1 >= 1){
      tempPos = new IChessPosition(row - 1, col);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(col - 1 >= 1){
      tempPos = new IChessPosition(row, col - 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
        tempMov=new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(col - 1 >= 1  && row - 1 >= 1){
      tempPos = new IChessPosition(row - 1, col - 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(col + 1 < 9  && row + 1 < 9){
      tempPos = new IChessPosition(row + 1, col + 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(col - 1 >= 1  && row + 1 < 9){
      tempPos = new IChessPosition(row + 1, col - 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(col + 1 < 9  && row - 1 >= 1){
      tempPos = new IChessPosition(row - 1, col + 1);
      if(board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
      if(board.getPiece(tempPos) == null){
        tempMov = new IChessMove(myPosition, tempPos, null);
        validMoves2.add(tempMov);
      }
    }

    if(validMoves2 == null){
      return null;
    }
    return validMoves2;
  }
}
