package Bai8;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int[][] board = new int [9][10];
    List<Piece> listOfPiece;

    public Board() {
        listOfPiece = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                board[j][i] = 0;
            }
        }
    }

    public boolean canAdd(Piece p) {
        return p.canAdd;
    }

    public void add(Piece p) {
        if (canAdd(p)) listOfPiece.add(p);
    }

    public void delete(Piece p) {
        listOfPiece.remove(p);
    }

    public void update() {
        for (Piece q : listOfPiece) {
            board[q.x][q.y] = q.kind;
        }
    }

    public void display() {
        update();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
