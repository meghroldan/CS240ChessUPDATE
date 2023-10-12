package chess;

import java.util.Collection;

public interface ValidMovements {

  Collection<ChessMove> pieceMovesAvailable(ChessBoard board, ChessPosition myPosition);

}
