package chess;

import java.util.Collection;

public class IChessPiece implements ChessPiece{

  ChessPiece.PieceType type;
  ChessGame.TeamColor color;

  public IChessPiece(ChessGame.TeamColor type1, ChessPiece.PieceType type2){
    color = type1;
    type = type2;
  }

  @Override
  public ChessGame.TeamColor getTeamColor() {
    return color;
  }

  @Override
  public PieceType getPieceType() {
    return type;
  }

  public void promotePawn(PieceType newType){
    type = newType;
  }


  //decide how to make them move later
  @Override
  public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
    return null;
  }
}
