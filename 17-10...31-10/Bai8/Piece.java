package Bai8;

public abstract class Piece {
    int kind;
    boolean is_red_piece;
    boolean canAdd;
    int limit;

    int x, y;

    public abstract boolean canMoveTo(int x, int y);
    public abstract void moveTo(int x, int y);
}
