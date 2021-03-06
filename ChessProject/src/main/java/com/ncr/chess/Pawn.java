package com.ncr.chess;

public class Pawn implements Piece {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    @Override
    public void move(MovementType movementType, int newX, int newY) {
        if (movementType.equals(MovementType.MOVE) && checkLegalMove(newX, newY)) {
            chessBoard.removePiece(xCoordinate, yCoordinate);
            chessBoard.addPiece(this, newX, newY, pieceColor);
        }

    }

    private boolean checkLegalMove(int newX, int newY) {
        return xCoordinate == newX && (newY == yCoordinate + 1 || newY == yCoordinate - 1);
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }

}
