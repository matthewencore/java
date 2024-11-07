package org.example.OOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// ПеречислениеДляШахмат
enum ChessColor{
    BLACK("Black"),
    WHITE("White");

    private final String choice;

    ChessColor(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}

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

    abstract boolean canMoveToPosition(ChessBoard cb, int line,int column, int toLine, int toColumn);
    abstract String getSymbol();

}

// Класс доски
class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

//    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
//        if (checkPos(startLine) && checkPos(startColumn)) {
//
//            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;
//
//            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
//                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
//                board[startLine][startColumn] = null; // set null to previous cell
//                this.nowPlayer = this.nowPlayerColor().equals(ChessColor.WHITE.getChoice()) ? ChessColor.BLACK.getChoice() : ChessColor.WHITE.getChoice();
//
//                return true;
//            } else return false;
//        } else return false;
//    }

    //Мой метод
    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        // Проверка на координаты
        if (!checkPos(startLine) || !checkPos(startColumn)){
            System.err.println("| Игра: Координаты заданы не в пределах 8х8.");
            return false;
        }
        //Получаем фигуру. Проверяем
        ChessPiece chess = board[startLine][startColumn];
        if (chess == null){
            System.err.println("| Игра: На данной координате нет никого кем можно было бы походить");
            return false;
        }
        // Проверка на цвет
        if (!chess.getColor().equalsIgnoreCase(nowPlayerColor())) {
            System.out.println("| Стоять ковбой, нельзя так быстро. Текущий ход: " + nowPlayerColor());
            return false;
        }

        if (chess.canMoveToPosition(this,startLine,startColumn,endLine,endColumn)) {
            board[endLine][endColumn] = board[startLine] [startColumn];
            board[startLine][startColumn] = null;

            // Смена игрока после успешного хода
            this.nowPlayer = this.nowPlayerColor().equals(ChessColor.WHITE.getChoice()) ?
                    ChessColor.BLACK.getChoice() :
                    ChessColor.WHITE.getChoice();

            System.out.println("Ход выполнен. Следующий игрок: " + nowPlayer);

        } else {
            System.err.println("| Игра: Невозможно выполнить ход.");
        }

        return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    void castling0(){
        //Определяем

    }
    void castling7() {

    }
}

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
    boolean equalsPoint(int toLine, int toColumn){
        if (toLine == getX() && toColumn == getY()) { return true; }
        return false;
    }

    // Проверка на границы шахматной доски
    static boolean isValid(int line, int column){
        // макс. число
        int maxLength = 7;
        return (line >= 0 && line <= maxLength) && (column >= 0 && column <= maxLength);
    }
}

// БлокФигур

// Конь
class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line, column)){
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
            pointChesses.add(new PointChess(indexUp,rIndexUp));
            pointChesses.add(new PointChess(indexUp,lIndexUp));
        }

        // индекс нижнего хода
        int indexDown = line - 2;
        if (indexDown <= 7 && indexDown >= 0) {
            int rIndexDown = column - 1;
            int lIndexDown = column + 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexDown,rIndexDown));
            pointChesses.add(new PointChess(indexDown,lIndexDown));
        }

        // индекс правого хода
        int indexRight = column + 2;
        if (indexRight <= 7 && indexRight >= 0) {
            int upIndexRight = line + 1;
            int downIndexRight = line - 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexRight,upIndexRight));
            pointChesses.add(new PointChess(indexRight,downIndexRight));
        }

        // индекс левого хода
        int indexLeft = column - 2;
        if (indexLeft <= 7 && indexLeft >= 0) {
            int upIndexLeft = line + 1;
            int downIndexLeft = line - 1;

            // Добавление точек
            pointChesses.add(new PointChess(indexLeft,upIndexLeft));
            pointChesses.add(new PointChess(indexLeft,downIndexLeft));
        }

        // Проверка на корректный ход пользователя
        for (PointChess item : pointChesses) {
            if (item.equalsPoint(toLine,toColumn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
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
        if (!PointChess.isValid(line,column)) {
            System.err.println("Пешка | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        System.out.println(getColor());

        // Реализация пешки черного цвета
        if (getColor().equalsIgnoreCase(ChessColor.BLACK.getChoice())) {
            System.out.println("Блок белой пешки");
            // Определение начальных позиций пешек и возможность ходить на две клетки.
            List<PointChess> defaultPositionWhite = new ArrayList<>();
            defaultPositionWhite.add(new PointChess(6,0));
            defaultPositionWhite.add(new PointChess(6,1));
            defaultPositionWhite.add(new PointChess(6,2));
            defaultPositionWhite.add(new PointChess(6,3));
            defaultPositionWhite.add(new PointChess(6,4));
            defaultPositionWhite.add(new PointChess(6,5));
            defaultPositionWhite.add(new PointChess(6,6));
            defaultPositionWhite.add(new PointChess(6,7));

            for (PointChess item: defaultPositionWhite) {
                // Если пешка на начальной позиции
                if (item.equalsPoint(line,column)) {
                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line - 1, column));
                    maybeIndexWhite.add(new PointChess(line - 2, column));

                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine,toColumn)) {
                            return true;
                        }

                    }
                } else {
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
            System.out.println("Блок черной пешки");
            // Определение начальных позиций пешек и возможность ходить на две клетки.
            List<PointChess> defaultPositionBlack = new ArrayList<>();
            defaultPositionBlack.add(new PointChess(1,0));
            defaultPositionBlack.add(new PointChess(1,1));
            defaultPositionBlack.add(new PointChess(1,2));
            defaultPositionBlack.add(new PointChess(1,3));
            defaultPositionBlack.add(new PointChess(1,4));
            defaultPositionBlack.add(new PointChess(1,5));
            defaultPositionBlack.add(new PointChess(1,6));
            defaultPositionBlack.add(new PointChess(1,7));

            for (PointChess item: defaultPositionBlack) {
                // Если пешка на начальной позиции
                if (item.equalsPoint(line,column)) {
                    List<PointChess> maybeIndexWhite = new ArrayList<>();
                    maybeIndexWhite.add(new PointChess(line + 1, column));
                    maybeIndexWhite.add(new PointChess(line + 2, column));

                    for (PointChess item2 : maybeIndexWhite) {
                        if (item2.equalsPoint(toLine,toColumn)) {
                            return true;
                        }

                    }
                } else {
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
// Слон
class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line,column)) {
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
            if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)){
                break;
            } else {
                maybePosBishop.add(new PointChess(x,y));
            }
        }

        // ПравоНиз
        int x2 = line;
        int y2 = column;

        while (true) {
            x2 += 1;
            y2 -= 1;
            if (!(x2 >= 0 && x2 <= 7) || !(y2 >= 0 && y2 <= 7)){
                break;
            } else {
                maybePosBishop.add(new PointChess(x2,y2));
            }
        }

        // ЛевоВверх
        int x3 = line;
        int y3 = column;

        while (true) {
            x3 -= 1;
            y3 += 1;
            if (!(x3 >= 0 && x3 <= 7) || !(y3 >= 0 && y3 <= 7)){
                break;
            } else {
                maybePosBishop.add(new PointChess(x3, y3));
            }
        }

        // ЛевоНиз
        int x4 = line;
        int y4 = column;

        while (true) {
            x4 += 1;
            y4 += 1;
            if (!(x4 >= 0 && x4 <= 7) || !(y4 >= 0 && y4 <= 7)){
                break;
            } else {
                maybePosBishop.add(new PointChess(x4, y4));
            }
        }

        for (PointChess item: maybePosBishop) {
            if (item.equalsPoint(toLine,toColumn)) {
                return true;
            }
        }
//        System.err.println("Слон | Ходить на заданную позицию фигура не может.\n     | Список позиций ниже");
//        for (PointChess item: maybePosBishop) {
//            System.err.println(item.getX() + " " + item.getY());
//        }
        return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }
}
// Ладья
class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line,column)){
            System.err.println("Ладья | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        // Для рокировки, проверка на ход
        super.check = true;
        List<PointChess> maybePosRook = new ArrayList<>();

        // Право
        int x = line;
        int y = column;

        while(true){
            y -= 1;
            if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)){
                break;
            } else {
                maybePosRook.add(new PointChess(x,y));
            }
        }

        // Лево
        int x2 = line;
        int y2 = column;

        while(true){
            y2 += 1;
            if (!(x2 >= 0 && x2 <= 7) || !(y2 >= 0 && y2 <= 7)){
                break;
            } else {
                maybePosRook.add(new PointChess(x2,y2));
            }
        }

        // Вверх
        int x3 = line;
        int y3 = column;

        while(true){
            x3 -= 1;
            if (!(x3 >= 0 && x3 <= 7) || !(y3 >= 0 && y3 <= 7)){
                break;
            } else {
                maybePosRook.add(new PointChess(x3,y3));
            }
        }

        // Вниз
        int x4 = line;
        int y4 = column;

        while(true){
            x4 += 1;
            if (!(x4 >= 0 && x4 <= 7) || !(y4 >= 0 && y4 <= 7)){
                break;
            } else {
                maybePosRook.add(new PointChess(x4, y4));
            }
        }

        for (PointChess item: maybePosRook) {
            if (item.equalsPoint(toLine,toColumn)){
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
// Ферзь
class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line,column)) {
            System.err.println("Ферзь | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }

        List<PointChess> maybePosQueen = new ArrayList<>();

        // ПравоВверх
        int x = line;
        int y = column;

        while (true) {
            x -= 1;
            y -= 1;
            if (!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x,y));
            }
        }

        // ПравоНиз
        int x2 = line;
        int y2 = column;

        while (true) {
            x2 += 1;
            y2 -= 1;
            if (!(x2 >= 0 && x2 <= 7) || !(y2 >= 0 && y2 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x2,y2));
            }
        }

        // ЛевоВверх
        int x3 = line;
        int y3 = column;

        while (true) {
            x3 -= 1;
            y3 += 1;
            if (!(x3 >= 0 && x3 <= 7) || !(y3 >= 0 && y3 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x3, y3));
            }
        }

        // ЛевоНиз
        int x4 = line;
        int y4 = column;

        while (true) {
            x4 += 1;
            y4 += 1;
            if (!(x4 >= 0 && x4 <= 7) || !(y4 >= 0 && y4 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x4, y4));
            }
        }
        // Право
        int x5 = line;
        int y5 = column;

        while(true){
            y5 -= 1;
            if (!(x5 >= 0 && x5 <= 7) || !(y5 >= 0 && y5 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x5,y5));
            }
        }

        // Лево
        int x6 = line;
        int y6 = column;

        while(true){
            y6 += 1;
            if (!(x6 >= 0 && x6 <= 7) || !(y6 >= 0 && y6 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x6,y6));
            }
        }

        // Вверх
        int x7 = line;
        int y7 = column;

        while(true){
            x7 -= 1;
            if (!(x7 >= 0 && x7 <= 7) || !(y7 >= 0 && y7 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x7,y7));
            }
        }

        // Вниз
        int x8 = line;
        int y8 = column;

        while(true){
            x8 += 1;
            if (!(x8 >= 0 && x8 <= 7) || !(y8 >= 0 && y8 <= 7)){
                break;
            } else {
                maybePosQueen.add(new PointChess(x8, y8));
            }
        }

        for (PointChess item: maybePosQueen) {
            if (item.equalsPoint(toLine,toColumn)) {
                return true;
            }
        }
        // для отладки
//        for (PointChess item: maybePosQueen) {
//            System.out.println(item.getX() + " " + item.getY());
//        }

        return false;
    }

    @Override
    String getSymbol() {
        return "Q";
    }
}
// Король
class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    boolean isUnderAttack(ChessBoard board, int line, int column){
        return false;
    }

    @Override
    boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (!PointChess.isValid(line,column)) {
            System.err.println("Король | Возникла ошибка, позиция фигуры вышла за границы 8х8");
            return false;
        }
        // Для рокировки, проверка на ход
        super.check = true;

        List<PointChess> maybePosKing = new ArrayList<>();

        //Вверх
        if (line - 1 <= 7 && line - 1  >= 0 ){
            maybePosKing.add(new PointChess(line - 1, column));
        }

        //Низ
        if (line + 1 <= 7 && line + 1  >= 0 ){
            maybePosKing.add(new PointChess(line + 1, column));
        }

        //Лево
        if (column - 1 <= 7 && column - 1  >= 0 ){
            maybePosKing.add(new PointChess(line, column - 1));
        }

        //Право
        if (column + 1 <= 7 && column + 1  >= 0 ){
            maybePosKing.add(new PointChess(line, column + 1));
        }

        // ДиагональЛевоВверх
        if ((line - 1 <= 7 && line - 1  >= 0 ) || (column - 1 <= 7 && column - 1 >= 0)){
            maybePosKing.add(new PointChess(line - 1, column - 1));
        }

        // ДиагональПравоВверх
        if ((line - 1 <= 7 && line - 1  >= 0 ) || (column + 1 <= 7 && column + 1 >= 0)){
            maybePosKing.add(new PointChess(line - 1, column + 1));
        }

        // ДиагональПравоНиз
        if ((line + 1 <= 7 && line + 1  >= 0 ) || (column + 1 <= 7 && column + 1 >= 0)){
            maybePosKing.add(new PointChess(line + 1, column + 1));
        }

        // ДиагональЛевоНиз
        if ((line - 1 <= 7 && line - 1  >= 0 ) || (column - 1 <= 7 && column - 1 >= 0)){
            maybePosKing.add(new PointChess(line - 1, column - 1));
        }

        for (PointChess item: maybePosKing) {
            if (item.equalsPoint(toLine,toColumn)) {
                return true;
            }
        }

//        // для отладки
//        for (PointChess item: maybePosKing) {
//            System.out.println(item.getX() + " " + item.getY());
//        }

        return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }
}

// КонецБлокаФигур

public class Chess  {
    // Растанова фигур
    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard(ChessColor.WHITE.getChoice());

        board.board[0][0] = new Rook(ChessColor.WHITE.getChoice());
        board.board[0][1] = new Horse(ChessColor.WHITE.getChoice());
        board.board[0][2] = new Bishop(ChessColor.WHITE.getChoice());
        board.board[0][3] = new Queen(ChessColor.WHITE.getChoice());
        board.board[0][4] = new King(ChessColor.WHITE.getChoice());
        board.board[0][5] = new Bishop(ChessColor.WHITE.getChoice());
        board.board[0][6] = new Horse(ChessColor.WHITE.getChoice());
        board.board[0][7] = new Rook(ChessColor.WHITE.getChoice());
        board.board[1][0] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][1] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][2] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][3] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][4] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][5] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][6] = new Pawn(ChessColor.WHITE.getChoice());
        board.board[1][7] = new Pawn(ChessColor.WHITE.getChoice());

        board.board[7][0] = new Rook(ChessColor.BLACK.getChoice());
        board.board[7][1] = new Horse(ChessColor.BLACK.getChoice());
        board.board[7][2] = new Bishop(ChessColor.BLACK.getChoice());
        board.board[7][3] = new Queen(ChessColor.BLACK.getChoice());
        board.board[7][4] = new King(ChessColor.BLACK.getChoice());
        board.board[7][5] = new Bishop(ChessColor.BLACK.getChoice());
        board.board[7][6] = new Horse(ChessColor.BLACK.getChoice());
        board.board[7][7] = new Rook(ChessColor.BLACK.getChoice());
        board.board[6][0] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][1] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][2] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][3] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][4] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][5] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][6] = new Pawn(ChessColor.BLACK.getChoice());
        board.board[6][7] = new Pawn(ChessColor.BLACK.getChoice());
        return board;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String string = sc.nextLine();
            switch (string.toLowerCase()){
                case "board":
            }

        }


    }
}
