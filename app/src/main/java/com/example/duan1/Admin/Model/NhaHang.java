package com.example.duan1.Admin.Model;

public class NhaHang {
    private String NhId;
    private String NhName;
    // Địa chỉ
    private Double NhLat;
    private Double NhLog;
    //    public String NhDanhGia;
//    public String NhNhanXet;
    private String NhNhomNhaHang;
    private String NhKhuVuc;

    public NhaHang() {
    }

    public NhaHang(String nhId, String nhName, Double nhLat, Double nhLog, String nhNhomNhaHang, String nhKhuVuc) {
        NhId = nhId;
        NhName = nhName;
        NhLat = nhLat;
        NhLog = nhLog;
        NhNhomNhaHang = nhNhomNhaHang;
        NhKhuVuc = nhKhuVuc;
    }

    public String getNhId() {
        return NhId;
    }

    public void setNhId(String nhId) {
        NhId = nhId;
    }

    public String getNhName() {
        return NhName;
    }

    public void setNhName(String nhName) {
        NhName = nhName;
    }

    public Double getNhLat() {
        return NhLat;
    }

    public void setNhLat(Double nhLat) {
        NhLat = nhLat;
    }

    public Double getNhLog() {
        return NhLog;
    }

    public void setNhLog(Double nhLog) {
        NhLog = nhLog;
    }

//    public String getNhDanhGia() {
//        return NhDanhGia;
//    }
//
//    public void setNhDanhGia(String nhDanhGia) {
//        NhDanhGia = nhDanhGia;
//    }
//
//    public String getNhNhanXet() {
//        return NhNhanXet;
//    }
//
//    public void setNhNhanXet(String nhNhanXet) {
//        NhNhanXet = nhNhanXet;
//    }

    public String getNhNhomNhaHang() {
        return NhNhomNhaHang;
    }

    public void setNhNhomNhaHang(String nhNhomNhaHang) {
        NhNhomNhaHang = nhNhomNhaHang;
    }

    public String getNhKhuVuc() {
        return NhKhuVuc;
    }

    public void setNhKhuVuc(String nhKhuVuc) {
        NhKhuVuc = nhKhuVuc;
    }
}
