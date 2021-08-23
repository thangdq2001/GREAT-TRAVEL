package com.example.duan1.Admin.Model;

public class UserLikeNh {
    private String usernameLikeNh;
    private String idNhaHangLike;
    private String nameNhaHangLike;

    public String getUsernameLikeNh() {
        return usernameLikeNh;
    }

    public void setUsernameLikeNh(String usernameLikeNh) {
        this.usernameLikeNh = usernameLikeNh;
    }

    public String getIdNhaHangLike() {
        return idNhaHangLike;
    }

    public void setIdNhaHangLike(String idNhaHangLike) {
        this.idNhaHangLike = idNhaHangLike;
    }

    public String getNameNhaHangLike() {
        return nameNhaHangLike;
    }

    public void setNameNhaHangLike(String nameNhaHangLike) {
        this.nameNhaHangLike = nameNhaHangLike;
    }

    public UserLikeNh(String usernameLikeNh, String idNhaHangLike, String nameNhaHangLike) {
        this.usernameLikeNh = usernameLikeNh;
        this.idNhaHangLike = idNhaHangLike;
        this.nameNhaHangLike = nameNhaHangLike;
    }

    public UserLikeNh(){

    }
}
