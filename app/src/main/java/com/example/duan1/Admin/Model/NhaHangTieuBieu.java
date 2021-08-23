package com.example.duan1.Admin.Model;

public class NhaHangTieuBieu {
     private String NhTbId;
     private String NhTbName;
     private Double NhTbLat;
     private Double NhTbLog;
     private String NhTbNhomNhaHang;
     private String NhTbKhuVuc;

     public NhaHangTieuBieu() {
     }

     public NhaHangTieuBieu(String nhTbId, String nhTbName, Double nhTbLat, Double nhTbLog, String nhTbNhomNhaHang, String nhTbKhuVuc) {
          NhTbId = nhTbId;
          NhTbName = nhTbName;
          NhTbLat = nhTbLat;
          NhTbLog = nhTbLog;
          NhTbNhomNhaHang = nhTbNhomNhaHang;
          NhTbKhuVuc = nhTbKhuVuc;
     }

     public String getNhTbId() {
          return NhTbId;
     }

     public void setNhTbId(String nhTbId) {
          NhTbId = nhTbId;
     }

     public String getNhTbName() {
          return NhTbName;
     }

     public void setNhTbName(String nhTbName) {
          NhTbName = nhTbName;
     }

     public Double getNhTbLat() {
          return NhTbLat;
     }

     public void setNhTbLat(Double nhTbLat) {
          NhTbLat = nhTbLat;
     }

     public Double getNhTbLog() {
          return NhTbLog;
     }

     public void setNhTbLog(Double nhTbLog) {
          NhTbLog = nhTbLog;
     }

     public String getNhTbNhomNhaHang() {
          return NhTbNhomNhaHang;
     }

     public void setNhTbNhomNhaHang(String nhTbNhomNhaHang) {
          NhTbNhomNhaHang = nhTbNhomNhaHang;
     }

     public String getNhTbKhuVuc() {
          return NhTbKhuVuc;
     }

     public void setNhTbKhuVuc(String nhTbKhuVuc) {
          NhTbKhuVuc = nhTbKhuVuc;
     }
}
