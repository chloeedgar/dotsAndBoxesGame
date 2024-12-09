package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveValidatorTest {

    private char[][] board;

    @BeforeEach
    void setUp() {
        board = BoardInitializer.initializeBoard(7);
    }

    @Test
    void testValidMoves() {
        assertTrue(MoveValidator.isMoveValid("A1", board)); // Valid move on the top-left edge
        assertTrue(MoveValidator.isMoveValid("G1", board)); // Valid move on the top-right edge
        assertTrue(MoveValidator.isMoveValid("A5", board)); // Valid move on the bottom-left edge
        assertTrue(MoveValidator.isMoveValid("D6", board)); // Valid move on the bottom-right edge
    }

    @Test
    void testInvalidMoveOutOfBounds() {
        assertFalse(MoveValidator.isMoveValid("H1", board)); // Invalid column (out of bounds)
        assertFalse(MoveValidator.isMoveValid("A8", board)); // Invalid row (out of bounds)
        assertFalse(MoveValidator.isMoveValid("Z1", board)); // Column way out of bounds
    }

    @Test
    void testRestrictedPosition() {
        // Test positions in the middle of squares (restricted areas) and squares with stars
        assertFalse(MoveValidator.isMoveValid("B1", board)); // Middle of a box
        assertFalse(MoveValidator.isMoveValid("D3", board)); // Middle of another box
        assertFalse(MoveValidator.isMoveValid("F5", board)); // Middle of another box
        assertFalse(MoveValidator.isMoveValid("A0", board)); // Star
        assertFalse(MoveValidator.isMoveValid("C4", board)); // Another star
    }

    @Test
    void testOccupiedPosition() {
        // Simulate an occupied position
        board[2][1] = '|'; // Mark "A1" as occupied
        board[1][2] = '-'; // Mark "B0" as occupied

        assertFalse(MoveValidator.isMoveValid("B0", board)); // Position is occupied
        assertFalse(MoveValidator.isMoveValid("A1", board)); // Position is occupied
    }

    @Test
    void testValidEdgeMoves() {
        assertTrue(MoveValidator.isMoveValid("G1", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("G3", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("G5", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("G1", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("B6", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("F6", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("A1", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("A3", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("A5", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("B0", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("D0", board)); // Valid move along the edge
        assertTrue(MoveValidator.isMoveValid("F0", board)); // Valid move along the edge

    }

}