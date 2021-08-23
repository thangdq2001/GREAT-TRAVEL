package com.example.duan1.Admin.Model;

public class DonHang {
    private String idDonhang;
    private String nameNh;
    private Double tongTien;
    private Double soLuong;
    private String trangThai;

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public DonHang(){}

    public DonHang(String idDonhang, String nameNh, Double tongTien, Double soLuong,String trangThai) {
        this.idDonhang = idDonhang;
        this.nameNh = nameNh;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getIdDonhang() {
        return idDonhang;
    }

    public void setIdDonhang(String idDonhang) {
        this.idDonhang = idDonhang;
    }

    public String getNameNh() {
        return nameNh;
    }

    public void setNameNh(String nameNh) {
        this.nameNh = nameNh;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }
}
