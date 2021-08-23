package com.example.duan1.Admin.Model;

public class VoHang {
    private String idNhaHang;
    private String tenMon;
    private Double GiaMon;
    private String ghiChi;
    private Double thanhTien;
    private Double SoLuong;


    private String idVoHang;

    public String getIdVoHang() {
        return idVoHang;
    }

    public void setIdVoHang(String idVoHang) {
        this.idVoHang = idVoHang;
    }

    public VoHang(){

   }

    public Double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Double soLuong) {
        SoLuong = soLuong;
    }

    public VoHang(String idNhaHang, String tenMon, Double giaMon, String ghiChi, Double thanhTien, String idVoHang, Double SoLuong) {
        this.idNhaHang = idNhaHang;
        this.tenMon = tenMon;
        GiaMon = giaMon;
        this.ghiChi = ghiChi;
        this.thanhTien = thanhTien;
        this.idVoHang = idVoHang;
        this.SoLuong = SoLuong;
    }

    public String getIdNhaHang() {
        return idNhaHang;
    }

    public void setIdNhaHang(String idNhaHang) {
        this.idNhaHang = idNhaHang;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public Double getGiaMon() {
        return GiaMon;
    }

    public void setGiaMon(Double giaMon) {
        GiaMon = giaMon;
    }

    public String getGhiChi() {
        return ghiChi;
    }

    public void setGhiChi(String ghiChi) {
        this.ghiChi = ghiChi;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
