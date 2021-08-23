package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Fragment.Dialog.ChuyenBay.DanhSachChuyenBayAdapter;
import com.example.duan1.Admin.Model.ChuyenBay;
import com.example.duan1.KhachHang.chuyenBayFragment.CustomDanhhSachchuyenBayKhAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ChuyenBayDao {
    public static  void readChuyenBay(final DanhSachChuyenBayAdapter Adapter, final Context context){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChuyenBay");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Adapter.resetAdapterChuyenBay();
                    for (DataSnapshot i:snapshot.getChildren()){
                        ChuyenBay chuyenBay = i.getValue(ChuyenBay.class);
                    Adapter.updateAdapter(chuyenBay);

                }
                }else {
                    Toast.makeText(context, "Cảnh báo: không có dử liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public static void UpdateChuyenBay(String IdChuyenBay,ChuyenBay chuyenBay){
        Map map = new HashMap();
        map.put("diemBatDau",chuyenBay.getDiemBatDau());
        map.put("diemKetThuc",chuyenBay.getDiemKetThuc());
        map.put("giaVe",chuyenBay.getGiaVe());
        map.put("hangBay",chuyenBay.getHangBay());
        map.put("maChuyenBay",chuyenBay.getMaChuyenBay());
        map.put("phi",chuyenBay.getPhi());
        map.put("sanBay",chuyenBay.getSanBay());
        map.put("thoiGianBay",chuyenBay.getThoiGianBay());
        map.put("thoiGianDen",chuyenBay.getThoiGianDen());
        map.put("thoiLuongBay",chuyenBay.getThoiLuongBay());
        map.put("thue",chuyenBay.getThue());
        map.put("tongTien",chuyenBay.getTongTien());

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChuyenBay");
        databaseReference.child(IdChuyenBay).updateChildren(map);

    }
    public static void chuyenBayDelete(String idChuyenBay, final int position, final DanhSachChuyenBayAdapter adapter){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChuyenBay");
        databaseReference.child(idChuyenBay).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                adapter.deleteSuccess(position);
            }
        });

    }
    // doc du lieu show to khach hang
    public static  void readChuyenBayKhachHang(final CustomDanhhSachchuyenBayKhAdapter Adapter, final Context context){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChuyenBay");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Adapter.resetAdapterKhacHang();

                    for (DataSnapshot i:snapshot.getChildren()){
                        ChuyenBay chuyenBay = i.getValue(ChuyenBay.class);
                        Adapter.updateAdapter(chuyenBay);

                    }
                }else {
                    Toast.makeText(context, "Cảnh báo: không có dử liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
