package org.example.OOP;

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
        if (!checkPos(startLine) || !checkPos(startColumn)) {
            System.err.println("| Игра: Координаты заданы не в пределах 8х8.");
            return false;
        }
        //Получаем фигуру. Проверяем
        ChessPiece chess = board[startLine][startColumn];
        if (chess == null) {
            System.err.println("| Игра: На данной координате нет никого кем можно было бы походить");
            return false;
        }
        // Проверка на цвет
        if (!chess.getColor().equalsIgnoreCase(nowPlayerColor())) {
            System.out.println("| Стоять ковбой, нельзя так быстро. Текущий ход: " + nowPlayerColor());
            return false;
        }

        if (chess.canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
            board[endLine][endColumn] = board[startLine][startColumn];
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

    // Метод для получения короля определенного цвета
    public King getKing(String color) {
        for (ChessPiece[] row : board) {
            for (ChessPiece piece : row) {
                if (piece != null && piece instanceof King && piece.getColor().equals(color)) {
                    return (King) piece;
                }
            }
        }
        return null;  // Если король не найден
    }

    // Метод для рокировки белого короля с ладьей на 0-й линии
    public boolean castling0() {
        // Проверка, что это ход белого игрока
        if (!nowPlayer.equals("White")) {
            return false;
        }

        // Проверка, что король и ладья находятся на своих начальных позициях
        if (board[0][0] == null || board[0][4] == null) {
            return false;
        }

        ChessPiece king = board[0][4];
        ChessPiece rook = board[0][0];

        // Проверка, что король и ладья того же цвета и не двигались (check == true)
        if (!king.getColor().equals("White") || !rook.getColor().equals("White")) {
            return false;
        }
        if (!king.check || !rook.check) {
            return false;
        }

        // Проверка, что клетки между королем и ладьей пустые
        if (board[0][1] != null || board[0][2] != null || board[0][3] != null) {
            return false;
        }

        // Получаем короля и проверяем, не находится ли он под атакой
        King whiteKing = getKing("White");
        if (whiteKing != null && (whiteKing.isUnderAttack(this, 0, 4) || whiteKing.isUnderAttack(this, 0, 2))) {
            return false;
        }

        // Выполнение рокировки
        // Перемещаем короля
        board[0][2] = king;
        board[0][4] = null;
        king.check = false;

        // Перемещаем ладью
        board[0][3] = rook;
        board[0][0] = null;
        rook.check = false;

        // Меняем игрока
        nowPlayer = "Black";

        return true;
    }

    // Метод для рокировки черного короля с ладьей на 7-й линии
    public boolean castling7() {
        // Проверка, что это ход черного игрока
        if (!nowPlayer.equals("Black")) {
            return false;
        }

        // Проверка, что король и ладья находятся на своих начальных позициях
        if (board[7][0] == null || board[7][4] == null) {
            return false;
        }

        ChessPiece king = board[7][4];
        ChessPiece rook = board[7][0];

        // Проверка, что король и ладья того же цвета и не двигались (check == true)
        if (!king.getColor().equals("Black") || !rook.getColor().equals("Black")) {
            return false;
        }
        if (!king.check || !rook.check) {
            return false;
        }

        // Проверка, что клетки между королем и ладьей пустые
        if (board[7][1] != null || board[7][2] != null || board[7][3] != null) {
            return false;
        }

        // Получаем короля и проверяем, не находится ли он под атакой
        King blackKing = getKing("Black");
        if (blackKing != null && (blackKing.isUnderAttack(this, 7, 4) || blackKing.isUnderAttack(this, 7, 2))) {
            return false;
        }

        // Выполнение рокировки
        // Перемещаем короля
        board[7][2] = king;
        board[7][4] = null;
        king.check = false;

        // Перемещаем ладью
        board[7][3] = rook;
        board[7][0] = null;
        rook.check = false;

        // Меняем игрока
        nowPlayer = "White";

        return true;
    }
}
