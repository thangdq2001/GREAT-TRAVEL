package com.example.duan1.Admin.Model;

public class KhachSan {
    private String KsId;
    private String  KsName;
    private Double KsLat;
    private Double KsLog;
    private String KsKhuVuc;

    public KhachSan() {
    }

    public KhachSan(String ksId, String ksName, Double ksLat, Double ksLog, String ksKhuVuc) {
        KsId = ksId;
        KsName = ksName;
        KsLat = ksLat;
        KsLog = ksLog;
        KsKhuVuc = ksKhuVuc;
    }


    public String getKsId() {
        return KsId;
    }

    public void setKsId(String ksId) {
        KsId = ksId;
    }

    public String getKsName() {
        return KsName;
    }

    public void setKsName(String ksName) {
        KsName = ksName;
    }

    public Double getKsLat() {
        return KsLat;
    }

    public void setKsLat(Double ksLat) {
        KsLat = ksLat;
    }

    public Double getKsLog() {
        return KsLog;
    }

    public void setKsLog(Double ksLog) {
        KsLog = ksLog;
    }

    public String getKsKhuVuc() {
        return KsKhuVuc;
    }

    public void setKsKhuVuc(String ksKhuVuc) {
        KsKhuVuc = ksKhuVuc;
    }
}
