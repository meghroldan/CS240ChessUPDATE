package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static chess.ChessPiece.PieceType.KING;

public class IChessGame implements ChessGame{

  private ChessBoard currBoard = new IChessBoard();
  private ChessBoard tempBoard = new IChessBoard((IChessBoard) currBoard);
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
      TeamColor color = currBoard.getPiece(startPosition).getTeamColor();
      validMovesToMake =(Set<ChessMove>) currBoard.getMyPieces().get(startPosition).pieceMoves(currBoard, startPosition);
      //make sure the moves are valid for this piece
      tempBoard = new IChessBoard((IChessBoard) currBoard);


      for(ChessMove moveToMake : validMovesToMake){
        tempBoard = new IChessBoard((IChessBoard) currBoard);
        ChessPiece type = tempBoard.getPiece(startPosition);
        tempBoard.getMyPieces().remove(startPosition);
        tempBoard.addPiece(moveToMake.getEndPosition(), type);
        if(!isInCheck(color)){
          tempMoves.add(moveToMake);
      }
      tempBoard.getMyPieces().remove(moveToMake.getEndPosition());
      tempBoard.addPiece(moveToMake.getStartPosition(), type);
    }



    validMovesToMake = tempMoves;


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
   if( !validMovesToMake.contains(move)){
     throw new InvalidMoveException("not a move");
   }

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
    if(tempBoard.getMyPieces().size() == 0){
      tempBoard = new IChessBoard((IChessBoard) currBoard);
    }
    /*
    if(tempBoard.getMyPieces().size() != currBoard.getMyPieces().size()){
      tempBoard = new IChessBoard((IChessBoard) currBoard);
    }

     */
    //this gets piece partially trapped but not cannot elimate check

    pieces = tempBoard.getMyPieces();


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
        opponantMoves =(Set<ChessMove>) tempBoard.getPiece(en.getKey()).pieceMoves(tempBoard, en.getKey());
        for(ChessMove move : opponantMoves){
          if(move.getEndPosition().equals(king)){
            return true;
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean isInCheckmate(TeamColor teamColor) {
    tempBoard = new IChessBoard((IChessBoard) currBoard);

    pieces = tempBoard.getMyPieces();
    for(Map.Entry<ChessPosition, ChessPiece> en : pieces.entrySet()) {
      if (en.getValue().getTeamColor() == teamColor) {
        Set<ChessMove> tempMoves = new HashSet<>();
        Set<ChessMove> possibleMoves = new HashSet<>();
        possibleMoves =(Set<ChessMove>) validMoves(en.getKey() );
        for(ChessMove moveToMake : possibleMoves){
          ChessPiece type = tempBoard.getPiece(moveToMake.getStartPosition());
          tempBoard.getMyPieces().remove(moveToMake.getStartPosition());
          tempBoard.addPiece(moveToMake.getEndPosition(), type);
          if(!isInCheck(teamColor)){
            tempMoves.add(moveToMake);
          }
          tempBoard.getMyPieces().remove(moveToMake.getEndPosition());
          tempBoard.addPiece(moveToMake.getStartPosition(), type);
        }
        validMovesToMake = tempMoves;
        if(!validMovesToMake.isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isInStalemate(TeamColor teamColor) {
    //double check to make sure i don't want to use the overall temp board
    ChessBoard temp = new IChessBoard((IChessBoard) currBoard);
    pieces = temp.getMyPieces();


    Set<ChessMove> opponantMoves = new HashSet<>();
    for(Map.Entry<ChessPosition, ChessPiece> en : pieces.entrySet()) {
      if (en.getValue().getTeamColor() == teamColor) {
        //this has to be valid moves only
        opponantMoves=(Set<ChessMove>) validMoves(en.getKey());
        if (!opponantMoves.isEmpty()) {
          return false;
        }
      }
    }
    return true;
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
