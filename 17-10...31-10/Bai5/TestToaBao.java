package Bai5;

public class TestToaBao {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        NhaBao nb = (NhaBao)nv;
        nb.beAdd(null, null);
    }
}
