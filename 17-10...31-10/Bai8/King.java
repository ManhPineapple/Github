package Bai8;

public class King extends Piece {
    static int cur_num = 0;
    static int limit = 2;
    Board b;

    public King(Board b) {
        canAdd = true;
        this.kind = 1;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 4;
                this.y = 0;
                this.is_red_piece = false;
            }
            // case 2 -> {
            //     this.x = 4;
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
        if (x > 5 || x < 3 || y > 2) return false;

        if (Math.abs(this.x - x) == 1) {
            if (this.y == y) return true;
        } 
        if (Math.abs(this.y - y) == 1) {
            if (this.x == x) return true;
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
