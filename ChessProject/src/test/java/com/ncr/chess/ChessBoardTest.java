package com.ncr.chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest {

    private ChessBoard testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new ChessBoard();
    }

    @Test
    public void testHas_MaxBoardWidth_of_7() {
        //Updated test since Chess board with and height should be 8*8
        Assert.assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_7() {
        Assert.assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 0);
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, 5);
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(11, 5);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 9);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(11, 0);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, -1);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testAvoids_Duplicate_Positioning() {
        Pawn firstPawn = new Pawn(PieceColor.BLACK);
        Pawn secondPawn = new Pawn(PieceColor.BLACK);
        testSubject.addPiece(firstPawn, 6, 3, PieceColor.BLACK);
        testSubject.addPiece(secondPawn, 6, 3, PieceColor.BLACK);
        Assert.assertEquals(6, firstPawn.getXCoordinate());
        Assert.assertEquals(3, firstPawn.getYCoordinate());
        Assert.assertEquals(-1, secondPawn.getXCoordinate());
        Assert.assertEquals(-1, secondPawn.getYCoordinate());
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        for (int i = 0; i < 10; i++) {
            Pawn pawn = new Pawn(PieceColor.BLACK);
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            testSubject.addPiece(pawn, 6 + row, i % ChessBoard.MAX_BOARD_WIDTH, PieceColor.BLACK);
            if (row < 1) {
                Assert.assertEquals(6 + row, pawn.getXCoordinate());
                Assert.assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getYCoordinate());
            } else {
                Assert.assertEquals(-1, pawn.getXCoordinate());
                Assert.assertEquals(-1, pawn.getYCoordinate());
            }
        }
    }

    @Test
    public void testRemovePiece_should_remove_element_and_make_referenceEmpty() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        testSubject.addPiece(pawn, 6, 5, PieceColor.BLACK);
        Piece pawnRemoved = testSubject.removePiece(6, 5);
        Assert.assertNotNull(pawnRemoved);
        Assert.assertNull(testSubject.getElementFromBoard(6, 5));
    }

    @Test
    public void test_get_element_from_a_location_on_board() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        testSubject.addPiece(pawn, 6, 5, PieceColor.BLACK);
        Piece retrievedPawn = testSubject.getElementFromBoard(6, 5);
        Assert.assertNotNull(retrievedPawn);
        Assert.assertEquals(6, retrievedPawn.getXCoordinate());
        Assert.assertEquals(5, retrievedPawn.getYCoordinate());
    }
}
