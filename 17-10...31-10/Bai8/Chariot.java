package Bai8;

public class Chariot extends Piece {
    static int cur_num = 0;
    static int limit = 4;
    Board b;

    public Chariot(Board b) {
        canAdd = true;
        this.kind = 4;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 0;
                this.y = 0;
                this.is_red_piece = false;
            }
            case 2 -> {
                this.x = 8;
                this.y = 0;
                this.is_red_piece = false;
            }
            // case 3 -> {
            //     this.x = 0;
            //     this.y = 9;
            //     this.is_red_piece = true;
            // }
            // case 4 -> {
            //     this.x = 8;
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
        if (x == this.x && y == this.y) return false;

        if (x == this.x) {
            if (y > this.y) {
                for (int i = this.y+1; i <= y; i++) {
                    if (i == y) return true;
                    if (b.board[x][i] == 0) continue;
                    return false;
                }
            }
            if (y < this.y) {
                for (int i = this.y-1; i >= y; i--) {
                    if (i == y) return true;
                    if (b.board[x][i] == 0) continue;
                    return false;
                }
            }
        }
        if (y == this.y) {
            if (x > this.x) {
                for (int i = this.x+1; i <= x; i++) {
                    if (i == x) return true;
                    if (b.board[i][y] == 0) continue;
                    return false;
                }
            }
            if (x < this.x) {
                for (int i = this.x-1; i >= x; i--) {
                    if (i == x) return true;
                    if (b.board[i][y] == 0) continue;
                    return false;
                }
            }
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
