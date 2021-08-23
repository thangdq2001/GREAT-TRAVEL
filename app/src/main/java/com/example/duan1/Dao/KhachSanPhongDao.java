package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Fragment.Dialog.phongKhachSan.DanhSachPhongKhachSanAdapter;
import com.example.duan1.Admin.Model.KhachSanPhong;
import com.example.duan1.KhachHang.KhachSan.DanhSachPhongAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class KhachSanPhongDao {

    public static void readPhong(final DanhSachPhongKhachSanAdapter Adapter, final Context context){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Adapter.resetAdapter();
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        KhachSanPhong khachSanPhong = i.getValue(KhachSanPhong.class);
                        Adapter.updateAdapter(khachSanPhong);
                    }
                }
                else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void updatePhong(String maPhong,KhachSanPhong phong){
        Map<String, Object> map = new HashMap();
        map.put("ksPGiaGoc",phong.getKsPGiaGoc());
        map.put("ksPGiaPhong",phong.getKsPGiaPhong());
        map.put("ksPGiamGia",phong.getKsPGiamGia());
        map.put("ksPLoai",phong.getKsPLoai());
        map.put("ksPSoLuongPhong",phong.getKsPSoLuongPhong());
        map.put("ksPSoPhong",phong.getKsPSoPhong());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
        databaseReference.child(maPhong).updateChildren(map);



    }
    public static void deletePhong(String MaPhong, final int position, final DanhSachPhongKhachSanAdapter adapter){
       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
       databaseReference.child(MaPhong).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               adapter.onDeleteSuccessful(position);
           }
       });


    }
    public static void readAllKh(String Maks, final DanhSachPhongAdapter adapter, final Context context){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
        ref.orderByChild("idKhachSan").equalTo(Maks).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.resetAdapter();
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        KhachSanPhong ks = i.getValue(KhachSanPhong.class);
                        adapter.updateAdapter(ks);
                    }
                }
                else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
