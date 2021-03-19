package com.ncr.chess;

/**
 * Class to define a 8x8 chess board with functionality
 * to add pawn, remove pawn and check board location.
 */
public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;
    private int maxPawns = 8;

    private Piece[][] pieces;

    public ChessBoard() {
        pieces = new Piece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate) && isLocationNotOccupied(xCoordinate, yCoordinate) && maxPawns != 0) {
            maxPawns = maxPawns - 1;
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate <= 7 && yCoordinate <= 7 && xCoordinate >= 0 && yCoordinate >= 0;
    }

    private boolean isLocationNotOccupied(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }

    public Piece removePiece(int xCoordinate, int yCoordinate) {
        Piece removedPawn = pieces[xCoordinate][yCoordinate];
        pieces[xCoordinate][yCoordinate] = null;
        return removedPawn;
    }

    public Piece getElementFromBoard(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate];
    }

}
