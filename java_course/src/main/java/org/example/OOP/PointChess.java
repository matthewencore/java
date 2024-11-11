package org.example.OOP;

// Точка для фигур
class PointChess {
    int x;
    int y;

    public PointChess(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Проверка на выбор точек пользователем
    boolean equalsPoint(int toLine, int toColumn) {
        if (toLine == getX() && toColumn == getY()) {
            return true;
        }
        return false;
    }

    // Проверка на границы шахматной доски
    static boolean isValid(int line, int column) {
        // макс. число
        int maxLength = 7;
        return (line >= 0 && line <= maxLength) && (column >= 0 && column <= maxLength);
    }
}
