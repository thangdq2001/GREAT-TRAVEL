package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Fragment.Dialog.MonAn.UpdateAndDeleteMonAnAdapter;
import com.example.duan1.Admin.Model.MonAn;
import com.example.duan1.KhachHang.NhaHang.DanhSachMonAnAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MonAnDao {

    public static void readMonAn(final UpdateAndDeleteMonAnAdapter Adapter, final Context context){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("MonAn");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Adapter.resetAdpter();
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        MonAn monAn = i.getValue(MonAn.class);
                        Adapter.updateAdapter(monAn);
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
    public static void updateMonAn(String maMonAn,MonAn monAn){
        Map<String, Object> map = new HashMap();
        map.put("nhMaIdNhaHang",monAn.getNhMaIdNhaHang());
        map.put("nhMaId",monAn.getNhMaId());
        map.put("nhMaName",monAn.getNhMaName());
        map.put("nhMaNhom",monAn.getNhMaNhom());
        map.put("nhMaGia", monAn.getNhMaGia());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("MonAn");
        databaseReference.child(maMonAn).updateChildren(map);



    }
    public static void delteteMonAn(String MaMonAn, final int position, final UpdateAndDeleteMonAnAdapter adapter){
       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("MonAn");
       databaseReference.child(MaMonAn).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               adapter.onDeleteSuccessful(position);
           }
       });


    }
    public static void readMonAnKhachHang(final DanhSachMonAnAdapter Adapter, final Context context){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("MonAn");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        MonAn monAn = i.getValue(MonAn.class);
                        Adapter.updateAdapter(monAn);
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
    public static void SendDish(String MaNhhang, final DanhSachMonAnAdapter adapter, final Context context){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("MonAn");
        ref.orderByChild("nhMaIdNhaHang").equalTo(MaNhhang).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        MonAn monAn = i.getValue(MonAn.class);
                        adapter.updateAdapter(monAn);
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
