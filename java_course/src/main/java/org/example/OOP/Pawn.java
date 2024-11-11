package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

// Пешка
class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }


    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)) {
            System.err.println("Пешка | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        //System.out.println(getColor());

        // Реализация пешки черного цвета
        if (getColor().equalsIgnoreCase(ChessColor.BLACK.getChoice())) {
            // Определение начальных позиций пешек и возможность ходить на две клетки.
            List<PointChess> defaultPositionWhite = new ArrayList<>();
            defaultPositionWhite.add(new PointChess(6, 0));
            defaultPositionWhite.add(new PointChess(6, 1));
            defaultPositionWhite.add(new PointChess(6, 2));
            defaultPositionWhite.add(new PointChess(6, 3));
            defaultPositionWhite.add(new PointChess(6, 4));
            defaultPositionWhite.add(new PointChess(6, 5));
            defaultPositionWhite.add(new PointChess(6, 6));
            defaultPositionWhite.add(new PointChess(6, 7));

            for (PointChess item : defaultPositionWhite) {
                // Если пешка на начальной позиции
                if (item.equalsPoint(line, column)) {

                    //Проверка на стоящую впереди пешку, фигуру
                    if (cb.board[line - 1][column] != null) {
                        return false;
                    } else if (cb.board[line - 2][column] != null) {
                        return false;
                    }

                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line - 1, column));
                    maybeIndexWhite.add(new PointChess(line - 2, column));

                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine, toColumn)) {
                            return true;
                        }

                    }
                } else {

                    //Проверка на стоящую впереди пешку, фигуру
                    if (cb.board[line - 1][column] != null) {
                        return false;
                    }

                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line - 1, column));

                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine, toColumn)) {
                            return true;
                        }
                    }
                }
            }

        }
        // Реализация пешки белого цвета
        if (getColor().equalsIgnoreCase(ChessColor.WHITE.getChoice())) {
            // Определение начальных позиций пешек и возможность ходить на две клетки.
            List<PointChess> defaultPositionBlack = new ArrayList<>();
            defaultPositionBlack.add(new PointChess(1, 0));
            defaultPositionBlack.add(new PointChess(1, 1));
            defaultPositionBlack.add(new PointChess(1, 2));
            defaultPositionBlack.add(new PointChess(1, 3));
            defaultPositionBlack.add(new PointChess(1, 4));
            defaultPositionBlack.add(new PointChess(1, 5));
            defaultPositionBlack.add(new PointChess(1, 6));
            defaultPositionBlack.add(new PointChess(1, 7));

            for (PointChess item : defaultPositionBlack) {
                // Если пешка на начальной позиции
                if (item.equalsPoint(line, column)) {

                    //Проверка на стоящую впереди пешку, фигуру
                    if (cb.board[line + 1][column] != null) {
                        return false;
                    } else if (cb.board[line + 2][column] != null) {
                        return false;
                    }

                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line + 1, column));
                    maybeIndexWhite.add(new PointChess(line + 2, column));


                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine, toColumn)) {
                            return true;
                        }

                    }
                } else {
                    //Проверка на стоящую впереди пешку, фигуру
                    if (cb.board[line + 1][column] != null) {
                        return false;
                    }

                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line + 1, column));

                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine, toColumn)) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    @Override
    String getSymbol() {
        return "P";
    }
}
