package com.example.duan1.Dao;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Model.VoHang;
import com.example.duan1.KhachHang.NhaHang.VoHangAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CartDao {
    public static void readAll(String MaNhhang, final VoHangAdapter adapter, final Context context, final TextView tongTien){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Cart");
        ref.orderByChild("idNhaHang").equalTo(MaNhhang).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot i:snapshot.getChildren()){
                        VoHang voHang = i.getValue(VoHang.class);
                        adapter.updateAdapter(voHang);
                    }
                    tongTien.setText(String.valueOf(adapter.getTongTien()));
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
    public static void delete(String maCart, final int position, final VoHangAdapter adapter){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.child(maCart).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                adapter.deletesuccess(position);
            }
        });
    }

}
