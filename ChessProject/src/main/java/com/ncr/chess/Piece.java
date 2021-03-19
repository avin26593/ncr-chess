package com.ncr.chess;

/**
 * Interface from where all further different kind of pieces
 * (King, Knight, Queen)
 * would inherit
 */
public interface Piece {
    void move(MovementType movementType, int newX, int newY);

    int getXCoordinate();

    int getYCoordinate();
};
