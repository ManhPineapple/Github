package Bai8;

public class Cannon extends Piece {
    static int cur_num = 0;
    static int limit = 4;
    Board b;

    public Cannon(Board b) {
        canAdd = true;
        this.kind = 5;
        this.b = b;
        cur_num ++;
        switch (cur_num) {
            case 1 -> {
                this.x = 1;
                this.y = 2;
                this.is_red_piece = false;
            }
            case 2 -> {
                this.x = 7;
                this.y = 2;
                this.is_red_piece = false;
            }
            // case 3 -> {
            //     this.x = 1;
            //     this.y = 7;
            //     this.is_red_piece = true;
            // }
            // case 4 -> {
            //     this.x = 7;
            //     this.y = 7;
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
        
    }
    
}
