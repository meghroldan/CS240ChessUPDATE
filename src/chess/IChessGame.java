package chess;

import java.util.Collection;

public class IChessGame implements ChessGame{
  ChessGame.TeamColor turn = TeamColor.WHITE;

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
    return false;
  }

  @Override
  public boolean isInCheckmate(TeamColor teamColor) {
    return false;
  }

  @Override
  public boolean isInStalemate(TeamColor teamColor) {
    return false;
  }

  @Override
  public void setBoard(ChessBoard board) {

  }

  @Override
  public ChessBoard getBoard() {
    return null;
  }
}
