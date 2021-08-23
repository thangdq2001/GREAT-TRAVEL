package com.example.duan1.Admin.Model;

public class MonAn {


    public String getNhMaIdNhaHang() {
        return NhMaIdNhaHang;
    }

    public void setNhMaIdNhaHang(String nhMaIdNhaHang) {
        NhMaIdNhaHang = nhMaIdNhaHang;
    }

    public MonAn(String nhMaIdNhaHang, String nhMaId, String nhMaName, String nhMaNhom, double nhMaGia) {
        NhMaIdNhaHang = nhMaIdNhaHang;
        NhMaId = nhMaId;
        NhMaName = nhMaName;
        NhMaNhom = nhMaNhom;
        NhMaGia = nhMaGia;
    }
    private String NhMaIdNhaHang;
    private String NhMaId;
    private String NhMaName;
    private String NhMaNhom;
    private double NhMaGia;

    public MonAn(){

    }


    public String getNhMaId() {
        return NhMaId;
    }

    public void setNhMaId(String nhMaId) {
        NhMaId = nhMaId;
    }

    public String getNhMaName() {
        return NhMaName;
    }

    public void setNhMaName(String nhMaName) {
        NhMaName = nhMaName;
    }

    public String getNhMaNhom() {
        return NhMaNhom;
    }

    public void setNhMaNhom(String nhMaNhom) {
        NhMaNhom = nhMaNhom;
    }

    public double getNhMaGia() {
        return NhMaGia;
    }

    public void setNhMaGia(double nhMaGia) {
        NhMaGia = nhMaGia;
    }
}
