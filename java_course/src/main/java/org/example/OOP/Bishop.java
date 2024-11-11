package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Слон
class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Слон | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        List<PointChess> maybePosBishop = new ArrayList<>();

        // ПравоВверх
        int x = line;
        int y = column;
        while (true) {
            x -= 1;
            y -= 1;
            if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)) {
                break;  // Выход из цикла, если мы за пределами доски
            }
            if (cb.board[x][y] != null) {
                if (cb.board[x][y].color.equalsIgnoreCase(getColor())) {
                    break;  // Если фигура того же цвета, выходим
                } else {
                    maybePosBishop.add(new PointChess(x, y));
                    break;  // Если фигура противника, добавляем и выходим
                }
            }
            maybePosBishop.add(new PointChess(x, y));  // Если клетка пуста, добавляем
        }

        // ПравоНиз
        int x2 = line;
        int y2 = column;
        while (true) {
            x2 += 1;
            y2 -= 1;
            if (!(x2 >= 0 && x2 <= 7) || !(y2 >= 0 && y2 <= 7)) {
                break;  // Выход из цикла, если мы за пределами доски
            }
            if (cb.board[x2][y2] != null) {
                if (cb.board[x2][y2].color.equalsIgnoreCase(getColor())) {
                    break;  // Если фигура того же цвета, выходим
                } else {
                    maybePosBishop.add(new PointChess(x2, y2));
                    break;  // Если фигура противника, добавляем и выходим
                }
            }
            maybePosBishop.add(new PointChess(x2, y2));  // Если клетка пуста, добавляем
        }

        // ЛевоВверх
        int x3 = line;
        int y3 = column;
        while (true) {
            x3 -= 1;
            y3 += 1;
            if (!(x3 >= 0 && x3 <= 7) || !(y3 >= 0 && y3 <= 7)) {
                break;  // Выход из цикла, если мы за пределами доски
            }
            if (cb.board[x3][y3] != null) {
                if (cb.board[x3][y3].color.equalsIgnoreCase(getColor())) {
                    break;  // Если фигура того же цвета, выходим
                } else {
                    maybePosBishop.add(new PointChess(x3, y3));
                    break;  // Если фигура противника, добавляем и выходим
                }
            }
            maybePosBishop.add(new PointChess(x3, y3));  // Если клетка пуста, добавляем
        }

        // ЛевоНиз
        int x4 = line;
        int y4 = column;
        while (true) {
            x4 += 1;
            y4 += 1;
            if (!(x4 >= 0 && x4 <= 7) || !(y4 >= 0 && y4 <= 7)) {
                break;  // Выход из цикла, если мы за пределами доски
            }
            if (cb.board[x4][y4] != null) {
                if (cb.board[x4][y4].color.equalsIgnoreCase(getColor())) {
                    break;  // Если фигура того же цвета, выходим
                } else {
                    maybePosBishop.add(new PointChess(x4, y4));
                    break;  // Если фигура противника, добавляем и выходим
                }
            }
            maybePosBishop.add(new PointChess(x4, y4));  // Если клетка пуста, добавляем
        }

        // Проверяем, можно ли ходить на заданную позицию
        for (PointChess item : maybePosBishop) {
            if (item.equalsPoint(toLine, toColumn)) {
                return true;
            }
        }

        // Если не нашли подходящей позиции
        return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }
}
