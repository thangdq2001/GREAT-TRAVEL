package com.example.duan1.Admin.Model;

public class MonAnTieuBieu {
    public  String NhTbMaName;
    public  Double NhTbMaGia;
    public  int NhTbMaId;
    public String NhTbMaKhuVuc;

    public MonAnTieuBieu() {
    }

    public MonAnTieuBieu(String nhTbMaName, Double nhTbMaGia, int nhTbMaId, String nhTbMaKhuVuc) {
        NhTbMaName = nhTbMaName;
        NhTbMaGia = nhTbMaGia;
        NhTbMaId = nhTbMaId;
        NhTbMaKhuVuc = nhTbMaKhuVuc;
    }

    public String getNhTbMaName() {
        return NhTbMaName;
    }

    public void setNhTbMaName(String nhTbMaName) {
        NhTbMaName = nhTbMaName;
    }

    public Double getNhTbMaGia() {
        return NhTbMaGia;
    }

    public void setNhTbMaGia(Double nhTbMaGia) {
        NhTbMaGia = nhTbMaGia;
    }

    public int getNhTbMaId() {
        return NhTbMaId;
    }

    public void setNhTbMaId(int nhTbMaId) {
        NhTbMaId = nhTbMaId;
    }

    public String getNhTbMaKhuVuc() {
        return NhTbMaKhuVuc;
    }

    public void setNhTbMaKhuVuc(String nhTbMaKhuVuc) {
        NhTbMaKhuVuc = nhTbMaKhuVuc;
    }
}
