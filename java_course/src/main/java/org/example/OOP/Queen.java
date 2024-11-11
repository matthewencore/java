package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Ферзь
class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Ферзь | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }

        List<PointChess> maybePosQueen = new ArrayList<>();

        // Направления: {право, лево, вверх, вниз, право-вверх, право-вниз, лево-вверх, лево-вниз}
        int[][] directions = {
                {0, 1},  // право
                {0, -1}, // лево
                {-1, 0},  // вверх
                {1, 0},  // вниз
                {-1, 1},  // право-вверх
                {1, 1},  // право-вниз
                {-1, -1}, // лево-вверх
                {1, -1}  // лево-вниз
        };

        // Проверка всех направлений
        for (int[] dir : directions) {
            int x = line;
            int y = column;

            while (true) {
                x += dir[0];
                y += dir[1];

                // Выход за границы доски
                if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)) {
                    break;
                }

                if (cb.board[x][y] != null) {
                    if (cb.board[x][y].color.equalsIgnoreCase(getColor())) {
                        break;
                    } else {
                        maybePosQueen.add(new PointChess(x, y));  // Противник, добавляем позицию
                        break;
                    }
                }
                maybePosQueen.add(new PointChess(x, y));  // Пустая клетка, добавляем позицию
            }
        }

        // Проверка на возможность перемещения в целевую позицию
        for (PointChess item : maybePosQueen) {
            if (item.equalsPoint(toLine, toColumn)) {
                return true;
            }
        }

        return false;
    }

    @Override
    String getSymbol() {
        return "Q";
    }
}
