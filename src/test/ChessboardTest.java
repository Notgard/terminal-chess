package test;

import chess.Chessboard;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.util.ChessMoveException;
import chess.util.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ChessboardTest {


    void getPiece() {
    }


    public void testGetPiece() {
    }


    public void isPiecePresentOnSameDiagonalBetween() {
    }


    public void isPiecePresentOnSameLineBetween() {
    }


    public void isPiecePresentOnSameColumnBetween() {
    }

    @Test
    public void testBoardFunctionalities() throws ChessMoveException {
        Chessboard chess = new Chessboard();
        Piece white_pawn = chess.getPiece(new Position(1, 0));
        Piece piece = chess.getPiece(new Position("B1"));
        System.out.println("Algebraic notation -> " + piece.getSymbol());
        System.out.println("Normal x,y position -> " + white_pawn.getSymbol());
        Position pos = new Position("A4");
        white_pawn.moveTo(pos);
        System.out.println(chess.toString());
        Piece knight = chess.getPiece(new Position("B1"));
        Piece rook = chess.getPiece(new Position("A1"));
        white_pawn.moveTo(new Position("A5"));
        rook.moveTo(new Position("A4"));
        System.out.println(chess.toString());
        rook.moveTo(new Position("A2"));
        chess.getPiece(new Position("B2")).moveTo(new Position("B3"));
        System.out.println(chess.toString());
        Piece bishop = chess.getPiece(new Position("C1"));
        bishop.moveTo(new Position("B2"));
        knight.moveTo(new Position("C3"));
        Piece pawn = chess.getPiece(new Position("D7"));
        pawn.moveTo(new Position("D5"));
        Piece queen = chess.getPiece(new Position("D8"));
        queen.moveTo(new Position("D6"));
        System.out.println(chess.toString());
        bishop.moveTo(new Position("A3"));
        bishop.moveTo(new Position("C5"));
        System.out.println(chess.toString());
    }

    public String[][] enPassantPositionsDataProvider() {
        return new String[][] {
                // En passant for white pieces
                {"C2", "C4"},
                {"H7", "H6"},
                {"C4", "C5"},
                {"D7", "D5"},
                {"C5", "D6"},
                // En passant for black pieces
                {"H6", "H5"},
                {"D1", "A4"},
                {"H5", "H4"},
                {"G2", "G4"},
                {"H4", "G3"}
        };
    }

    @Test
    public void testEnPassant()throws ChessMoveException {
        Chessboard board = new Chessboard();
        String[][] data = enPassantPositionsDataProvider();

        for (String[] turn : data) {
            Position dest = new Position(turn[1]);
            Piece n_piece = board.getPiece(new Position(turn[0]));
            n_piece.moveTo(dest);
        }

        System.out.println(board);
    }

    public String[][] roquePositionsDataProvider() {
        return new String[][] {
                {"G1", "H3"},
                {"H7", "H6"},
                {"E2", "E4"},
                {"H6", "H5"},
                {"F1", "B5"},
                {"C7", "C6"},
                {"E1", "G1"}
        };
    }

    @Test
    public void testRoque()throws ChessMoveException {
        Chessboard board = new Chessboard();
        String[][] data = roquePositionsDataProvider();

        for (String[] turn : data) {
            Position dest = new Position(turn[1]);
            Piece n_piece = board.getPiece(new Position(turn[0]));
            n_piece.moveTo(dest);
        }

        System.out.println(board);
    }

    public String[][] kingInCheckPositionsDataProvider() {
        return new String[][] {
                {"D2", "D3"},
                {"C7", "C5"},
                {"G1", "H3"},
                {"D8", "A5"},
        };
    }

    public ArrayList<King> getKings(Chessboard board) {
        ArrayList<King> kings = new ArrayList<King>();
        for(int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Position pos = new Position(x, y);
                Piece piece = board.getPiece(pos);
                if (piece instanceof King) kings.add((King) piece);
            }
        }
        return kings;
    }

    @Test
    public void testKingInCheck()throws ChessMoveException {
        Chessboard board = new Chessboard();
        String[][] data = kingInCheckPositionsDataProvider();

        for (String[] turn : data) {
            Position dest = new Position(turn[1]);
            Piece n_piece = board.getPiece(new Position(turn[0]));
            n_piece.moveTo(dest);
        }

        System.out.println(board);
        for(King king : getKings(board)) {
            System.out.println(king.inCheck());
        }
    }
}
