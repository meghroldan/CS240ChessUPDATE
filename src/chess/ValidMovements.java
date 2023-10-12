package chess;

import java.util.Collection;

public interface ValidMovements {

  Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

}
