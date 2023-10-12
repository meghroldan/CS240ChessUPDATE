package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IChessPiece implements ChessPiece{
  private Set<ChessMove> validMovesToMake = new HashSet<>();

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
    KingMovementRule king = new KingMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.KING){
      return king.pieceMovesAvailable(board, myPosition);
    }

    BishopMovementRule bishop = new BishopMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.BISHOP){
      return bishop.pieceMovesAvailable(board, myPosition);
    }

    RookMovementRule rook = new RookMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.ROOK){
      return rook.pieceMovesAvailable(board, myPosition);
    }

    QueenMovementRule queen = new QueenMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.QUEEN){
      return queen.pieceMovesAvailable(board, myPosition);
    }

    KnightMovementRule knight = new KnightMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.KNIGHT){
      return knight.pieceMovesAvailable(board, myPosition);
    }

    PawnMovementRule pawn = new PawnMovementRule();
    if(board.getPiece(myPosition).getPieceType() == PieceType.PAWN){
      return pawn.pieceMovesAvailable(board, myPosition);
    }

    if(validMovesToMake == null){
      return null;
    }
    return validMovesToMake;
  }
}
