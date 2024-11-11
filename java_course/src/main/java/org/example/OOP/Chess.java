package org.example.OOP;

import java.util.Scanner;

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

    public static void main(String[] args) {


        ChessBoard board = buildBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
               Чтобы проверить игру надо вводить команды:
               'exit' - для выхода
               'replay' - для перезапуска игры
               'castling0' или 'castling7' - для рокировки по соответствующей линии
               'move 1 1 2 3' - для передвижения фигуры с позиции 1 1 на 2 3(поле это двумерный массив от 0 до 7)
               'print - печать доски'
               Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?""");
        System.out.println();
        board.printBoard();
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                System.out.println("Заново");
                board = buildBoard();
                board.printBoard();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.contains("move")) {
                    String[] a = s.split(" ");
                    try {
                        int line = Integer.parseInt(a[1]);
                        int column = Integer.parseInt(a[2]);
                        int toLine = Integer.parseInt(a[3]);
                        int toColumn = Integer.parseInt(a[4]);
                        if (board.moveToPosition(line, column, toLine, toColumn)) {
                            board.printBoard();
                        }
                    } catch (Exception e) {
                        System.out.println("Вы что-то ввели не так, попробуйте ещё раз");
                    }

                } else if (s.equals("print")) {
                    board.printBoard();
                }
            }
        }
    }
}

