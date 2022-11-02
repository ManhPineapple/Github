package Bai9;

public class TestDaThuc {
    public static void main(String[] args) {
        HangTu h1 = new HangTu(3, 2);
        DaThuc d1 = new DaThuc(h1);

        HangTu h2 = new HangTu(2, 3);
        d1.add(h2);

        HangTu h21 = new HangTu(5, 1);
        DaThuc d2 = new DaThuc(h21);
        d1.add(d2);

        HangTu m1 = new HangTu(1, 1);
        d1.multiple(m1);

        d1.display();

        System.out.println(d1.calculate(1));
    }
}
