package org.example.OOP;

// Абстрактный класс фигуры
abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    abstract boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn);

    abstract String getSymbol();

}
