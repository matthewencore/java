package org.example.OOP;

// ПеречислениеДляШахмат
enum ChessColor {
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
