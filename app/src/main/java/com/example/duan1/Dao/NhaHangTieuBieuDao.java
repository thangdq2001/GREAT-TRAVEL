package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Model.NhaHangTieuBieu;
import com.example.duan1.KhachHang.NhaHang.NhaHangTieuBieuAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NhaHangTieuBieuDao {

    public static void readAll(final NhaHangTieuBieuAdapter adapter, final  Context context){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("NhaHangTieuBieu");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    adapter.resetAdpter();
                    for (DataSnapshot i: snapshot.getChildren()){
                        NhaHangTieuBieu nh = i.getValue(NhaHangTieuBieu.class);
                        adapter.updateAdapter(nh);
                    }
                }else {
                    Toast.makeText(context, "Cảnh báo không có dử liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
