package Bai8;

public class Horse extends Piece {
    static int cur_num = 0;
    static int limit = 4;
    Board b;

    public Horse(Board b) {
        canAdd = true;
        this.kind = 6;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 1;
                this.y = 0;
                this.is_red_piece = false;
            }
            case 2 -> {
                this.x = 7;
                this.y = 0;
                this.is_red_piece = false;
            }
            // case 3 -> {
            //     this.x = 1;
            //     this.y = 9;
            //     this.is_red_piece = true;
            // }
            // case 4 -> {
            //     this.x = 7;
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
