package Bai5;

import java.util.List;

import Bai5.NhanVien.TypeNhanVien;

public class ToaBao {
    String name;
    List<NhanVien> listOfNhaBao;
    List<NhanVien> listOfHanhChinh;

    public ToaBao(String name) {
        this.name = name;
    }

    public void addNhanVien(NhanVien nv, TypeNhanVien type) {
        if (type == TypeNhanVien.NhaBao) {
            listOfNhaBao.add(nv);
            nv.beAdd(this, type);
        }
        if (type == TypeNhanVien.NhanVienHanhChinh) {
            listOfHanhChinh.add(nv);
            nv.beAdd(this, type);
        }
    }

    public void rmvNhanVien(NhanVien nv, TypeNhanVien type) {
        if (type == TypeNhanVien.NhaBao) {
            listOfNhaBao.remove(nv);
            nv.beRmv(this, type);
        }
        if (type == TypeNhanVien.NhanVienHanhChinh) {
            listOfHanhChinh.remove(nv);
            nv.beRmv(this, type);
        }
    }
    
    public void display() {
        for (NhanVien nhanVien : listOfHanhChinh) {
            System.out.println(nhanVien.name + ", type:" + nhanVien.typeNhanVien);
        }
        for (NhanVien nhanVien : listOfNhaBao) {
            System.out.println(nhanVien.name + ", type:" + nhanVien.typeNhanVien);
        }
    }
}
