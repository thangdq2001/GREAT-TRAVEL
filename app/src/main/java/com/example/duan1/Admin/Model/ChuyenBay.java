package com.example.duan1.Admin.Model;

public class ChuyenBay {
    private String idChuyenbay;
    private String MaChuyenBay;
    private String ThoiGianBay;
    private String ThoiGianDen;
    private String DiemBatDau;
    private String DiemKetThuc;
    private Double GiaVe;
    private String SanBay;
    private String HangBay;
    private String ThoiLuongBay;
    private Double Thue;
    private Double Phi;
    private Double TongTien;


    public  ChuyenBay() {

    }

    public String getIdChuyenbay() {
        return idChuyenbay;
    }

    public void setIdChuyenbay(String idChuyenbay) {
        this.idChuyenbay = idChuyenbay;
    }

    public String getMaChuyenBay() {
        return MaChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        MaChuyenBay = maChuyenBay;
    }

    public String getThoiGianBay() {
        return ThoiGianBay;
    }

    public void setThoiGianBay(String thoiGianBay) {
        ThoiGianBay = thoiGianBay;
    }

    public String getThoiGianDen() {
        return ThoiGianDen;
    }

    public void setThoiGianDen(String thoiGianDen) {
        ThoiGianDen = thoiGianDen;
    }

    public String getDiemBatDau() {
        return DiemBatDau;
    }

    public void setDiemBatDau(String diemBatDau) {
        DiemBatDau = diemBatDau;
    }

    public String getDiemKetThuc() {
        return DiemKetThuc;
    }

    public void setDiemKetThuc(String diemKetThuc) {
        DiemKetThuc = diemKetThuc;
    }

    public Double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(Double giaVe) {
        GiaVe = giaVe;
    }

    public String getSanBay() {
        return SanBay;
    }

    public void setSanBay(String sanBay) {
        SanBay = sanBay;
    }

    public String getHangBay() {
        return HangBay;
    }

    public void setHangBay(String hangBay) {
        HangBay = hangBay;
    }

    public String getThoiLuongBay() {
        return ThoiLuongBay;
    }

    public void setThoiLuongBay(String thoiLuongBay) {
        ThoiLuongBay = thoiLuongBay;
    }

    public Double getThue() {
        return Thue;
    }

    public void setThue(Double thue) {
        Thue = thue;
    }

    public Double getPhi() {
        return Phi;
    }

    public void setPhi(Double phi) {
        Phi = phi;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }

    public ChuyenBay(String idChuyenbay, String maChuyenBay, String thoiGianBay, String thoiGianDen, String diemBatDau, String diemKetThuc, Double giaVe, String sanBay, String hangBay, String thoiLuongBay, Double thue, Double phi, Double tongTien) {
        this.idChuyenbay = idChuyenbay;
        MaChuyenBay = maChuyenBay;
        ThoiGianBay = thoiGianBay;
        ThoiGianDen = thoiGianDen;
        DiemBatDau = diemBatDau;
        DiemKetThuc = diemKetThuc;
        GiaVe = giaVe;
        SanBay = sanBay;
        HangBay = hangBay;
        ThoiLuongBay = thoiLuongBay;
        Thue = thue;
        Phi = phi;
        TongTien = tongTien;
    }

}

