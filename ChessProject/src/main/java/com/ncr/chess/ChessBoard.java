package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;
    private int maxPawns = 8;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && isLocationNotOccupied(xCoordinate, yCoordinate) && maxPawns != 0) {
            maxPawns = maxPawns - 1;
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate <= 7 && yCoordinate <= 7 && xCoordinate >= 0 && yCoordinate >= 0;
    }

    private boolean isLocationNotOccupied(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }

    public Pawn removePiece(int xCoordinate, int yCoordinate) {
        Pawn removedPawn = pieces[xCoordinate][yCoordinate];
        pieces[xCoordinate][yCoordinate] = null;
        return removedPawn;
    }
}
