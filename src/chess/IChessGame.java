package chess;

import java.util.Collection;
import java.util.Map;

public class IChessGame implements ChessGame{

  private ChessBoard currBoard = new IChessBoard();
  private Map<ChessPosition, ChessPiece> pieces;  //this is only to pass through functions to test things - MUST EDIT BOARD
  private Collection<ChessMove> validMovesToMake;
  private ChessGame.TeamColor turn = TeamColor.WHITE;
  private boolean isBoardValid = true;
  private boolean isInCheck = false;
  private boolean isCheckmate = false;
  private boolean isStalemate = false;

  @Override
  public TeamColor getTeamTurn() {
    return turn;
  }

  @Override
  public void setTeamTurn(TeamColor team) {
    turn = team;
  }

  //set up all classes and return a collection of moves to make
  @Override
  public Collection<ChessMove> validMoves(ChessPosition startPosition) {
    validMovesToMake = currBoard.getMyPieces().get(startPosition).pieceMoves(currBoard, startPosition);


    if(validMovesToMake == null){
      return null;
    }
    return validMovesToMake;
  }


  //see if valid move and then do it or not
  @Override
  public void makeMove(ChessMove move) throws InvalidMoveException {

  }

  @Override
  public boolean isInCheck(TeamColor teamColor) {
    return isInCheck;
  }

  @Override
  public boolean isInCheckmate(TeamColor teamColor) {
    return isCheckmate;
  }

  @Override
  public boolean isInStalemate(TeamColor teamColor) {
    return isStalemate;
  }

  @Override
  public void setBoard(ChessBoard board) {
    currBoard = board;
  }

  @Override
  public ChessBoard getBoard() {
    return currBoard;
  }
}
