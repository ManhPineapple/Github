package Bai8;

public class Advisor extends Piece {
    static int cur_num = 0;
    static int limit = 4;
    Board b;

    public Advisor(Board b) {
        canAdd = true;
        this.kind = 2;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 3;
                this.y = 0;
                this.is_red_piece = false;
            }
            case 2 -> {
                this.x = 5;
                this.y = 0;
                this.is_red_piece = false;
            }
            // case 3 -> {
            //     this.x = 3;
            //     this.y = 9;
            //     this.is_red_piece = true;
            // }
            // case 4 -> {
            //     this.x = 5;
            //     this.y = 9;
            //     this.is_red_piece = true;
            // } 
            default -> {
                canAdd = false;
            }
        }
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if (x == 3 && y == 0) {
            if (this.x == 4 && this.y == 1) return true;
        }
        if (x == 5 && y == 0) {
            if (this.x == 4 && this.y == 1) return true;
        }
        if (x == 3 && y == 2) {
            if (this.x == 4 && this.y == 1) return true;
        }
        if (x == 5 && y == 2) {
            if (this.x == 4 && this.y == 1) return true;
        }
        if (x == 4 && y == 1) {
            if (this.x != 4 && this.y != 1) return true;
        }

        return false;
    }

    @Override
    public void moveTo(int x, int y) {
        if (canMoveTo(x, y)) {
            for (Piece p : b.listOfPiece) {
                if (p.x == x && p.y == y) b.listOfPiece.remove(p);
            }
            b.board[this.x][this.y] = 0;
            this.x = x;
            this.y = y;
            b.update();
        } else System.out.println("Can't move to " + x + "," + y);
    }
}
