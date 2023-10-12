package chess;

import java.util.Collection;

public class IChessGame implements ChessGame{

  ChessBoard currBoard = new IChessBoard();

  ChessGame.TeamColor turn = TeamColor.WHITE;
  boolean isBoardValid = true;
  boolean isInCheck = false;
  boolean isCheckmate = false;
  boolean isStalemate = false;

  @Override
  public TeamColor getTeamTurn() {
    return turn;
  }

  @Override
  public void setTeamTurn(TeamColor team) {
    turn = team;
  }

  @Override
  public Collection<ChessMove> validMoves(ChessPosition startPosition) {
    return null;
  }

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
