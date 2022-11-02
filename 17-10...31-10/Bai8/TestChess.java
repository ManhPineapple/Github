package Bai8;

import java.util.Random;

public class TestChess {

    public static void PlayGame(Board b, int n) {
        if (n == 0) return;
        Random rd = new Random();
        int i_rd = rd.nextInt(b.listOfPiece.size());
        Piece p_rd = null;
        for (Piece p : b.listOfPiece) {
            if (i_rd == 0) {
                p_rd = p;
                break;
            }
            i_rd--;
        }
        int x_rd = rd.nextInt(8);
        int y_rd = rd.nextInt(5);
        if (p_rd.canMoveTo(x_rd, y_rd)) {
            p_rd.moveTo(x_rd, y_rd);
            b.display();
            PlayGame(b, n-1);
        } else PlayGame(b, n);
    }
    public static void main(String[] args) {
        Board b = new Board();
        
        Piece horse[] = new Horse[4];
        for (int i = 0; i < horse.length; i++) {
            horse[i] = new Horse(b);
            b.add(horse[i]);
        }

        Piece advisor[] = new Advisor[4];
        for (int i = 0; i < advisor.length; i++) {
            advisor[i] = new Advisor(b);
            b.add(advisor[i]);
        }

        Piece cannon[] = new Cannon[4];
        for (int i = 0; i < cannon.length; i++) {
            cannon[i] = new Cannon(b);
            b.add(cannon[i]);
        }
        
        Piece chariot[] = new Chariot[4];
        for (int i = 0; i < chariot.length; i++) {
            chariot[i] = new Chariot(b);
            b.add(chariot[i]);
        }

        Piece elephant[] = new Elephant[4];
        for (int i = 0; i < elephant.length; i++) {
            elephant[i] = new Elephant(b);
            b.add(elephant[i]);
        }

        Piece king[] = new King[2];
        for (int i = 0; i < king.length; i++) {
            king[i] = new King(b);
            b.add(king[i]);
        }

        Piece soldier[] = new Soldier[10];
        for (int i = 0; i < soldier.length; i++) {
            soldier[i] = new Soldier(b);
            b.add(soldier[i]);
        }

        b.update();

        PlayGame(b, 10);
        // king[0].moveTo(5, 0);
        // chariot[0].moveTo(0, 5);
        // elephant[0].moveTo(4, 2);
        // advisor[0].moveTo(4, 1);
        // b.display();
    }
}
