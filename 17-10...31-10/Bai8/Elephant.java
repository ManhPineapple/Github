package Bai8;

public class Elephant extends Piece {
    static int cur_num = 0;
    static int limit = 4;
    Board b;

    public Elephant(Board b) {
        canAdd = true;
        this.kind = 3;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 2;
                this.y = 0;
                this.is_red_piece = false;
            }
            case 2 -> {
                this.x = 6;
                this.y = 0;
                this.is_red_piece = false;
            }
            // case 3 -> {
            //     this.x = 2;
            //     this.y = 9;
            //     this.is_red_piece = true;
            // }
            // case 4 -> {
            //     this.x = 6;
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
        if (x == 2 && y == 0 && b.board[3][1] == 0) {
            if (this.x == 4 && this.y == 2) return true;
        }
        if (x == 6 && y == 0 && b.board[5][1] == 0) {
            if (this.x == 4 && this.y == 2) return true;
        }
        if (x == 2 && y == 4 && b.board[3][3] == 0) {
            if (this.x == 4 && this.y == 2) return true;
        }
        if (x == 6 && y == 4 && b.board[5][3] == 0) {
            if (this.x == 4 && this.y == 2) return true;
        }
        if (x == 4 && y == 2) {
            if (this.x == 2 && this.y == 0 && b.board[3][1] == 0) return true;
            if (this.x == 6 && this.y == 0 && b.board[5][1] == 0) return true;
            if (this.x == 2 && this.y == 4 && b.board[3][3] == 0) return true;
            if (this.x == 6 && this.y == 4 && b.board[5][3] == 0) return true;
        }

        return false;
    }

    @Override
    public void moveTo(int x, int y) {
        if (canMoveTo(x, y)) {
            Piece p_delete = null;
            for (Piece p : b.listOfPiece) {
                if (p.x == x && p.y == y) p_delete = p;
            }
            b.listOfPiece.remove(p_delete);
            b.board[this.x][this.y] = 0;
            this.x = x;
            this.y = y;
            b.update();
        } else System.out.println("Can't move to " + x + "," + y);
    }
}
