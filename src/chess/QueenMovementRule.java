package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QueenMovementRule implements ValidMovements{
  private Map<ChessPosition, ChessPiece> pieces;
  private Set<ChessMove> validMoves2 = new HashSet<>();
  public QueenMovementRule(){
  }

  @Override
  public Collection<ChessMove> pieceMovesAvailable(ChessBoard board, ChessPosition myPosition) {

    pieces = board.getMyPieces();
    ChessGame.TeamColor currColor = board.getPiece(myPosition).getTeamColor();
    int col = myPosition.getColumn();
    int row = myPosition.getRow();

    ChessPosition tempPos;
    ChessMove tempMov;

    int tempRow = row;
    int tempCol = col;

    tempRow = row;
    tempCol = col;
    for(int i = col + 1; i <= 8; i++){
      if(tempCol <= 8) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }

    tempRow = row;
    tempCol = col;
    for(int i = col - 1; i >= 1; i--) {
      if (tempCol >= 1) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if (board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }

    tempRow = row;
    tempCol = col;
    for(int i = row - 1; i >= 1; i--) {
      if (tempRow >= 1) {
        tempPos=new IChessPosition(i, tempCol);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if (board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }

    tempRow = row;
    tempCol = col;
    for(int i = row + 1; i <= 8; i++) {
      if (tempRow <= 8) {
        tempPos=new IChessPosition(i, tempCol);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if (board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }

    tempRow = row;
    tempCol = col;
    for(int i = col + 1; i <= 8; i++){
      tempRow--;
      if(tempRow >= 1) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }

    }

    tempRow = row;
    tempCol = col;
    for(int i = col - 1; i >= 1; i--){
      tempRow++;
      if(tempRow <= 8) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }

    tempRow = row;
    tempCol = col;
    for(int i = row - 1; i >= 1; i--){
      tempCol--;
      if(tempCol >= 1) {
        tempPos=new IChessPosition(i, tempCol);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }
    }


    tempRow = row;
    tempCol = col;
    for(int i = row + 1; i <= 8; i++){
      tempCol++;
      if(tempCol <= 8) {
        tempPos=new IChessPosition(i, tempCol);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos) != null) {
          if (board.getPiece(tempPos).getTeamColor() == currColor) {
            break;
          }
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
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
