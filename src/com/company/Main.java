package com.company;

import chess.*;

public class Main {

    public static void main(String[] args) {
	    System.out.println("hello");
        ChessBoard temp = new IChessBoard();
        ChessPiece piece = new IChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        ChessPosition pos = new IChessPosition(1, 1);
        temp.addPiece(pos, piece);
        System.out.println(temp.getPiece(pos).getPieceType());
    }
}
