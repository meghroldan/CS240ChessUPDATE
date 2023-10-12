package com.company;

import chess.*;

public class Main {

    public static void main(String[] args) {
	    System.out.println("hello");
        IChessBoard temp = new IChessBoard();
        IChessPiece piece = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        IChessPosition pos = new IChessPosition(1, 1);
        temp.addPiece(pos, piece);
        System.out.println(temp.getPiece(pos).getPieceType());
    }
}
