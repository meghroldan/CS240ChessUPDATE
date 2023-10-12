package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BishopMovementRule implements ValidMovements{

  private Map<ChessPosition, ChessPiece> pieces;
  private Set<ChessMove> validMoves2 = new HashSet<>();
  public BishopMovementRule(){
  }

  @Override
  public Collection<ChessMove> pieceMovesAvailable(ChessBoard board, ChessPosition myPosition) {

    pieces = board.getMyPieces();
    ChessGame.TeamColor currColor = board.getPiece(myPosition).getTeamColor();
    int col = myPosition.getColumn();
    int row = myPosition.getRow();

    ChessPosition tempPos;
    ChessMove tempMov;
    //debug this loop
    int tempRow = row;
    int tempCol = col;
    for(int i = col; i <= 8; i++){
      if(tempRow >= 1) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos).getTeamColor() == currColor){
          break;
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      } tempRow--;

    }

    tempRow = row;
    tempCol = col;
    for(int i = col; i >= 1; i--){
      if(tempRow <= 8) {
        tempPos=new IChessPosition(tempRow, i);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos).getTeamColor() == currColor){
          break;
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }tempRow++;
    }

    tempRow = row;
    tempCol = col;
    for(int i = row; i >= 1; i--){
      if(tempCol >= 1) {
        tempPos=new IChessPosition(i, tempCol);
        if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
          break;
        }
        if(board.getPiece(tempPos).getTeamColor() == currColor){
          break;
        }
        if (board.getPiece(tempPos) == null) {
          tempMov=new IChessMove(myPosition, tempPos, null);
          validMoves2.add(tempMov);
        }
      }tempCol--;
    }


    tempRow = row;
    tempCol = col;
    for(int i = row; i <= 8; i++){
        if(tempCol <= 8) {
          tempPos=new IChessPosition(i, tempCol);
          if (board.getPiece(tempPos) != null && board.getPiece(tempPos).getTeamColor() != currColor) {
            tempMov=new IChessMove(myPosition, tempPos, null);
            validMoves2.add(tempMov);
            break;
          }
          if(board.getPiece(tempPos).getTeamColor() == currColor){
            break;
          }
          if (board.getPiece(tempPos) == null) {
            tempMov=new IChessMove(myPosition, tempPos, null);
            validMoves2.add(tempMov);
          }
        }tempCol++;
    }

    if(validMoves2 == null){
      return null;
    }
    return validMoves2;
  }
}
