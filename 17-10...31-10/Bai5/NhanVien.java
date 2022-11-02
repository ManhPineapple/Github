package Bai5;

public class NhanVien {
    enum TypeNhanVien {NhaBao, NhanVienHanhChinh};
    String name;
    ToaBao host;
    TypeNhanVien typeNhanVien;

    public NhanVien() {
        
    }

    public NhanVien(String name) {
        this.name = name;
    }

    public void beAdd(ToaBao tb, TypeNhanVien type) {
        this.host = tb;
        this.typeNhanVien = type;
    }

    public void beRmv(ToaBao tb, TypeNhanVien type) {
        this.host = null;
        this.typeNhanVien = null;
    }

    public void display() {
        System.out.println("Name: " + this.name + ", type:" + this.typeNhanVien);
    }
}
