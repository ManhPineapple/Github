package Bai9;

import java.util.LinkedList;
import java.util.List;

public class DaThuc {
    List<HangTu> list = new LinkedList<>();

    public DaThuc(HangTu first) {
        list.add(first);
    }

    public void add(HangTu new_HangTu) {
        boolean need_add = true;
        for (HangTu hangTu : list) {
            if (hangTu.exp == new_HangTu.exp) {
                hangTu.coef += new_HangTu.coef;
                need_add = false;
            }
        }
        if (need_add == true) list.add(new_HangTu);
    }

    public void multiple(HangTu new_HangTu) {
        for (HangTu hangTu : list) {
            hangTu.coef *= new_HangTu.coef;
            hangTu.exp += new_HangTu.coef;
        }
    }

    public void add(DaThuc new_DaThuc) {
        for (HangTu hangTu : list) {
            for (HangTu hangTu2 : new_DaThuc.list) {
                if (hangTu.exp == hangTu2.exp) {
                    hangTu.coef += hangTu2.coef;
                    new_DaThuc.list.remove(hangTu2);
                }
            }
        }

        for (HangTu hangTu2 : new_DaThuc.list) {
            this.list.add(hangTu2);
        }
    }

    public void display() {
        for (HangTu hangTu : list) {
            if (hangTu.coef > 0){
                System.out.print("+" + hangTu.coef + "x^" + hangTu.exp);
            } else System.out.print(hangTu.coef + "x^" + hangTu.exp);
        }
        System.out.println();
    }

    public double calculate(double x) {
        double res = 0;
        for (HangTu hangTu : list) {
            res += hangTu.coef*(Math.pow(x, hangTu.exp));
        }
        return res;
    }
}
