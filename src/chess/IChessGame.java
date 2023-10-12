package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static chess.ChessPiece.PieceType.KING;

public class IChessGame implements ChessGame{

  private ChessBoard currBoard = new IChessBoard();
  private Map<ChessPosition, ChessPiece> pieces;  //this is only to pass through functions to test things - MUST EDIT BOARD
  private Set<ChessMove> validMovesToMake;  //to check only
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
    Set<ChessMove> tempMoves = new HashSet<>();
    validMovesToMake =(Set<ChessMove>) currBoard.getMyPieces().get(startPosition).pieceMoves(currBoard, startPosition);
    //make sure the moves are valid for this piece
    for(ChessMove moveToMake : validMovesToMake){

    }

    if(validMovesToMake == null){
      return null;
    }
    return validMovesToMake;
  }


  //see if valid move and then do it or not
  @Override
  public void makeMove(ChessMove move) throws InvalidMoveException {
    ChessPiece.PieceType rightType = currBoard.getPiece(move.getStartPosition()).getPieceType();
    TeamColor color = currBoard.getPiece(move.getStartPosition()).getTeamColor();
    //is it the right color
    if(currBoard.getMyPieces().get(move.getStartPosition()).getTeamColor() != getTeamTurn()){
      InvalidMoveException exceptionN = new InvalidMoveException("Not your turn");
      throw exceptionN;
    }
    //is there a pieces there
    if(currBoard.getMyPieces().get(move.getStartPosition()) == null){
      InvalidMoveException exceptionNoPiece = new InvalidMoveException("No piece");
    }
    //check if it can make the move - is the move in this set
    validMovesToMake =(Set<ChessMove>) validMoves(move.getStartPosition());

    //remove piece from play
    if(currBoard.getMyPieces().get(move.getEndPosition()) != null && currBoard.getMyPieces().get(move.getEndPosition()).getTeamColor() != getTeamTurn()){
      ChessPiece.PieceType tempType = currBoard.getMyPieces().get(move.getEndPosition()).getPieceType();

      //promote pawn
      if(move.getPromotionPiece() != null){
        ChessPiece toPut = new IChessPiece(color, move.getPromotionPiece());
        currBoard.getMyPieces().remove(move.getEndPosition(), tempType);
        currBoard.getMyPieces().put(move.getEndPosition(), toPut);
        currBoard.getMyPieces().remove(move.getStartPosition(), currBoard.getPiece(move.getStartPosition()));
      }
      else {
        currBoard.getMyPieces().remove(move.getEndPosition(), tempType);
        currBoard.getMyPieces().put(move.getEndPosition(), currBoard.getPiece(move.getStartPosition()));
        currBoard.getMyPieces().remove(move.getStartPosition(), currBoard.getPiece(move.getStartPosition()));
      }
    }

    //move piece without removing piece from play
    if(currBoard.getMyPieces().get(move.getEndPosition()) == null){

      //promote pawn
      if(move.getPromotionPiece() != null){
        ChessPiece toPut = new IChessPiece(color, move.getPromotionPiece());
        currBoard.getMyPieces().put(move.getEndPosition(), toPut);
        currBoard.getMyPieces().remove(move.getStartPosition(), currBoard.getPiece(move.getStartPosition()));
      }
      else{
        currBoard.getMyPieces().put(move.getEndPosition(), currBoard.getPiece(move.getStartPosition()));
        currBoard.getMyPieces().remove(move.getStartPosition(), currBoard.getPiece(move.getStartPosition()));
      }
    }

    //change the turn at end
    if(getTeamTurn() == TeamColor.WHITE){
      setTeamTurn(TeamColor.BLACK);
    }
    else{
      setTeamTurn(TeamColor.WHITE);
    }

  }

  @Override
  public boolean isInCheck(TeamColor teamColor) {
    pieces = currBoard.getMyPieces();

    //get where the king is
    ChessPosition king = null;
    for(Map.Entry<ChessPosition, ChessPiece> en : pieces.entrySet()){
      if(en.getValue().getPieceType() == KING && en.getValue().getTeamColor() == teamColor){
        king = en.getKey();
      }
    }

    Set<ChessMove> opponantMoves = new HashSet<>();
    for(Map.Entry<ChessPosition, ChessPiece> en : pieces.entrySet()){
      if(en.getValue().getTeamColor() != teamColor){
        opponantMoves =(Set<ChessMove>) currBoard.getPiece(en.getKey()).pieceMoves(currBoard, en.getKey());
        for(ChessMove move : opponantMoves){
          if(move.getEndPosition().equals(king)){
            return true;
          }
        }
      }
    }
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
