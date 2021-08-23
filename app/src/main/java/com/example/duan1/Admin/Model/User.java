package com.example.duan1.Admin.Model;

public class User {
    private String username;
    private String password;
    private String idUSer;
    private String ten;
    private String DiaChi;
    private String sdt;
    private String mail;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUSer() {
        return idUSer;
    }

    public void setIdUSer(String idUSer) {
        this.idUSer = idUSer;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User(String username, String password, String idUSer, String ten, String diaChi, String sdt, String mail) {
        this.username = username;
        this.password = password;
        this.idUSer = idUSer;
        this.ten = ten;
        DiaChi = diaChi;
        this.sdt = sdt;
        this.mail = mail;
    }

    public User(){

    }

}
