package com.example.duan1.Admin.Model;

public class UserInfo {
    private String IdUser;
    private String Username;
    private String  Name;
    private String Mail;
    private String DiaChi;
    private String Sdt;

    public UserInfo(){

    }

    public UserInfo(String idUser, String username, String name, String mail, String diaChi, String sdt) {
        IdUser = idUser;
        Username = username;
        Name = name;
        Mail = mail;
        DiaChi = diaChi;
        Sdt = sdt;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
