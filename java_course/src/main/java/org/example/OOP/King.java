package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Король
class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        // Проходим по всей доске
        for (int i = 0; i < board.board.length; i++) { // строки
            for (int j = 0; j < board.board[i].length; j++) { // столбцы
                ChessPiece chess = board.board[i][j]; // Получаем фигуру на позиции (i, j)

                // Проверяем, если фигура есть и она противника
                if (chess != null && !chess.getColor().equalsIgnoreCase(this.getColor())) {
                    // Проверяем, может ли эта фигура атаковать поле (line, column)
                    if (chess.canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Король | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        // Для рокировки, проверка на ход
        super.check = true;

        List<PointChess> maybePosKing = new ArrayList<>();

        //Вверх
        if (line + 1 <= 7 && line + 1 >= 0) {
            maybePosKing.add(new PointChess(line - 1, column));
        }

        //Низ
        if (line - 1 <= 7 && line - 1 >= 0) {
            maybePosKing.add(new PointChess(line + 1, column));
        }

        //Лево
        if (column - 1 <= 7 && column - 1 >= 0) {
            maybePosKing.add(new PointChess(line, column - 1));
        }

        //Право
        if (column + 1 <= 7 && column + 1 >= 0) {
            maybePosKing.add(new PointChess(line, column + 1));
        }

        // ДиагональЛевоВверх
        if ((line + 1 <= 7 && line + 1 >= 0) || (column - 1 <= 7 && column - 1 >= 0)) {
            maybePosKing.add(new PointChess(line - 1, column - 1));
        }

        // ДиагональПравоВверх
        if ((line + 1 <= 7 && line + 1 >= 0) || (column + 1 <= 7 && column + 1 >= 0)) {
            maybePosKing.add(new PointChess(line - 1, column + 1));
        }

        // ДиагональПравоНиз
        if ((line - 1 <= 7 && line - 1 >= 0) || (column + 1 <= 7 && column + 1 >= 0)) {
            maybePosKing.add(new PointChess(line + 1, column + 1));
        }

        // ДиагональЛевоНиз
        if ((line - 1 <= 7 && line - 1 >= 0) || (column - 1 <= 7 && column - 1 >= 0)) {
            maybePosKing.add(new PointChess(line - 1, column - 1));
        }

        for (PointChess item : maybePosKing) {
            if (item.equalsPoint(toLine, toColumn)) {
                if (cb.board[toLine][toColumn] != null) {
                    if (cb.board[toLine][toColumn].color.equalsIgnoreCase(getColor())) {
                        return false;
                    }
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }
}
