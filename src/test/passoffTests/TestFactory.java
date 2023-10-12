package test.passoffTests;

import chess.*;

/**
 * Used for testing your code
 * Add in code using your classes for each method for each
 */
public class TestFactory {

    //Chess Functions
    //------------------------------------------------------------------------------------------------------------------
    public static ChessBoard getNewBoard(){
        ChessBoard tempBoard = new IChessBoard();
		return tempBoard;
    }

    public static ChessGame getNewGame(){
        ChessGame tempGame = new IChessGame();
		return tempGame;
    }

    public static ChessPiece getNewPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type){
        ChessPiece tempPiece = new IChessPiece(pieceColor, type);
		return tempPiece;
    }

    public static ChessPosition getNewPosition(Integer row, Integer col){
        ChessPosition tempPosition = new IChessPosition(row, col);
		return tempPosition;
    }

    public static ChessMove getNewMove(ChessPosition startPosition, ChessPosition endPosition, ChessPiece.PieceType promotionPiece){
        ChessMove tempMove = new IChessMove(startPosition, endPosition, promotionPiece);
		return tempMove;
    }
    //------------------------------------------------------------------------------------------------------------------


    //Server API's
    //------------------------------------------------------------------------------------------------------------------
    public static String getServerPort(){
        return "8080";
    }
    //------------------------------------------------------------------------------------------------------------------


    //Websocket Tests
    //------------------------------------------------------------------------------------------------------------------
    public static Long getMessageTime(){
        /*
        Changing this will change how long tests will wait for the server to send messages.
        3000 Milliseconds (3 seconds) will be enough for most computers. Feel free to change as you see fit,
        just know increasing it can make tests take longer to run.
        (On the flip side, if you've got a good computer feel free to decrease it)
         */
        return 3000L;
    }
    //------------------------------------------------------------------------------------------------------------------
}
