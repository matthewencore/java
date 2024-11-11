package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Ладья
class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Ладья | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        // Для рокировки, проверка на ход
        super.check = true;
        List<PointChess> maybePosRook = new ArrayList<>();

        // Право
        int x = line;
        int y = column;

        while (true) {
            y += 1;
            if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)) {
                break;
            }
            if (cb.board[x][y] != null) {
                if (cb.board[x][y].color.equalsIgnoreCase(getColor())) {
                    break;
                } else {
                    maybePosRook.add(new PointChess(x, y));
                    break;
                }
            }
            maybePosRook.add(new PointChess(x, y));
        }

        // Лево
        int x2 = line;
        int y2 = column;

        while (true) {
            y2 -= 1;
            if (!(x2 >= 0 && x2 <= 7) || !(y2 >= 0 && y2 <= 7)) {
                break;
            }
            if (cb.board[x2][y2] != null) {
                if (cb.board[x2][y2].color.equalsIgnoreCase(getColor())) {
                    break;
                } else {
                    maybePosRook.add(new PointChess(x2, y2));
                    break;
                }
            }

            maybePosRook.add(new PointChess(x2, y2));
        }

        // Вверх
        int x3 = line;
        int y3 = column;

        while (true) {
            x3 += 1;
            if (!(x3 >= 0 && x3 <= 7) || !(y3 >= 0 && y3 <= 7)) {
                break;
            }

            if (cb.board[x3][y3] != null) {
                if (cb.board[x3][y3].color.equalsIgnoreCase(getColor())) {
                    break;
                } else {
                    maybePosRook.add(new PointChess(x3, y3));
                    break;
                }
            }

            maybePosRook.add(new PointChess(x3, y3));
        }

        // Вниз
        int x4 = line;
        int y4 = column;

        while (true) {
            x4 -= 1;
            if (!(x4 >= 0 && x4 <= 7) || !(y4 >= 0 && y4 <= 7)) {
                break;
            }

            if (cb.board[x4][y4] != null) {
                if (cb.board[x4][y4].color.equalsIgnoreCase(getColor())) {
                    break;
                } else {
                    maybePosRook.add(new PointChess(x4, y4));
                    break;
                }
            }
            maybePosRook.add(new PointChess(x4, y4));
        }

        for (PointChess item : maybePosRook) {
            if (item.equalsPoint(toLine, toColumn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "R";
    }
}
