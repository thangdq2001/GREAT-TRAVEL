package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Fragment.Dialog.KhachSan.UpdateAndDeleteKhachSanAdapter;
import com.example.duan1.Admin.Model.KhachSan;
import com.example.duan1.KhachHang.KhachSan.DanhSachKhachSanAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class KhachSanDao {

    public static void readKhachSan(final UpdateAndDeleteKhachSanAdapter Adapter, final Context context){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("KhachSan");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Adapter.resetAdapter();
                    for (DataSnapshot i:snapshot.getChildren()){
                        KhachSan khachSan = i.getValue(KhachSan.class);
                        Adapter.updateAdapter(khachSan);
                    }

                }
                else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void readKhachSanKh(final DanhSachKhachSanAdapter Adapter, final Context context){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("KhachSan");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Adapter.resetAdapter();
                    for (DataSnapshot i:snapshot.getChildren()){
                        KhachSan khachSan = i.getValue(KhachSan.class);
                        Adapter.updateAdapter(khachSan);
                    }

                }
                else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void updateKhachSan(String MaKhachSan,KhachSan khachSan){
        Map<String, Object> map = new HashMap();
        map.put("ksKhuVuc",khachSan.getKsKhuVuc());
        map.put("ksLat",khachSan.getKsLat());
        map.put("ksLog",khachSan.getKsLog());
        map.put("ksName",khachSan.getKsName());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("KhachSan");
        databaseReference.child(MaKhachSan).updateChildren(map);



    }
    public static void deleteKhachSan(String MaKhachSan, final  int position, final UpdateAndDeleteKhachSanAdapter adapter){
       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("KhachSan");
       databaseReference.child(MaKhachSan).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               adapter.onDeleteSuccessful(position);
           }
       });


    }
}
