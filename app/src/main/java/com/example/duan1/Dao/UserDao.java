package com.example.duan1.Dao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.AdminActivity;
import com.example.duan1.Admin.Model.Admin;
import com.example.duan1.Admin.Model.User;
import com.example.duan1.Admin.Model.UserComent;
import com.example.duan1.Admin.Model.UserInfo;
import com.example.duan1.KhachHang.NhaHang.Coment.DanhSachBinhLuanAdapter;
import com.example.duan1.LoginAcivity;
import com.example.duan1.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDao {

    public static void readAll(String maNh, final DanhSachBinhLuanAdapter adapter, final Context context) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserComent");
        databaseReference.orderByChild("idNhahang").equalTo(maNh).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    adapter.resetAdapter();
                    for (DataSnapshot i : snapshot.getChildren()) {
                        UserComent userComent = i.getValue(UserComent.class);
                        adapter.updateAdapter(userComent);
                    }
                } else {
                    Toast.makeText(context, "Cảnh báo không có dử liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public static void readData(final String username, final String password, final LoginAcivity acivity) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User");
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot i : snapshot.getChildren()) {
                        User user = i.getValue(User.class);
                        if (user.getPassword().equals(password)) {
                            Intent intent = new Intent(acivity, MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("name",user.getTen());
                            bundle.putString("diachi",user.getDiaChi());
                            bundle.putString("sdt",user.getSdt());
                            bundle.putString("mail",user.getMail());
                            bundle.putString("username", username);
                            intent.putExtra("UserInfo", bundle);
                            acivity.startActivity(intent);
                        }
                    }
                } else {
                    Toast.makeText(acivity, "Sai ten dang nhap hoac mat khau", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void readDataInfo(final DanhSachBinhLuanAdapter adapter, Context context) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserInFo");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.reserAdapterInfo();
                if (snapshot.exists()) {
                    for (DataSnapshot i : snapshot.getChildren()) {
                        UserInfo userInfo = i.getValue(UserInfo.class);
                        adapter.updateAdapterInfo(userInfo);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public static void readDataAdmin(final String username, final String password, final LoginAcivity acivity) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot i : snapshot.getChildren()) {
                        Admin admin = i.getValue(Admin.class);
                        if (admin.getPassword().equals(password)) {
                            Intent intent = new Intent(acivity, AdminActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            intent.putExtra("UserInfo", bundle);
                            acivity.startActivity(intent);
                        }
                    }
                } else {
                    Toast.makeText(acivity, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
