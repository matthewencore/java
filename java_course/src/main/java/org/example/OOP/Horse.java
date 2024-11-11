package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Конь
class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Конь | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }

        // Список возможных индексов
        List<PointChess> pointChesses = new ArrayList<>();

        // индекс верхнего хода
        int indexUp = line + 2;
        if (indexUp <= 7 && indexUp >= 0) {
            int rIndexUp = column - 1;
            int lIndexUp = column + 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexUp, rIndexUp));
            pointChesses.add(new PointChess(indexUp, lIndexUp));
        }

        // индекс нижнего хода
        int indexDown = line - 2;
        if (indexDown <= 7 && indexDown >= 0) {
            int rIndexDown = column - 1;
            int lIndexDown = column + 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexDown, rIndexDown));
            pointChesses.add(new PointChess(indexDown, lIndexDown));
        }

        // индекс правого хода
        int indexRight = column + 2;
        if (indexRight <= 7 && indexRight >= 0) {
            int upIndexRight = line + 1;
            int downIndexRight = line - 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexRight, upIndexRight));
            pointChesses.add(new PointChess(indexRight, downIndexRight));
        }

        // индекс левого хода
        int indexLeft = column - 2;
        if (indexLeft <= 7 && indexLeft >= 0) {
            int upIndexLeft = line + 1;
            int downIndexLeft = line - 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexLeft, upIndexLeft));
            pointChesses.add(new PointChess(indexLeft, downIndexLeft));
        }

        // Проверка на корректный ход пользователя
        for (PointChess item : pointChesses) {
            if (item.equalsPoint(toLine, toColumn)) {
                if (cb.board[toLine][toColumn] != null) {
                    if (cb.board[toLine][toColumn].color.equalsIgnoreCase(getColor())) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
