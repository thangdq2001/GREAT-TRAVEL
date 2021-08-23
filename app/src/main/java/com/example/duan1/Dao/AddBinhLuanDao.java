package com.example.duan1.Dao;

import com.example.duan1.Admin.Model.UserLikeNh;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBinhLuanDao {
    public static  void addLikeNhahang(String username,String idNhaHangLike,String NameNhaHangLike){
        DatabaseReference databaseReference  = FirebaseDatabase.getInstance().getReference("KhachSanYeuThich");
        String id = databaseReference.push().getKey();
        UserLikeNh userLikeNh = new UserLikeNh(username,idNhaHangLike,NameNhaHangLike);
        databaseReference.child(id).setValue(userLikeNh);

    }
}
