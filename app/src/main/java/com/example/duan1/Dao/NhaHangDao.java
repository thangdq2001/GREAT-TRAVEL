package com.example.duan1.Dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.duan1.Admin.Fragment.Dialog.Nhahang.UpdateAndDeleteNhaHangAdapter;
import com.example.duan1.Admin.Model.NhaHang;
import com.example.duan1.Admin.Model.NhaHangTieuBieu;
import com.example.duan1.KhachHang.NhaHang.DanhSachNhaHangAdapter;
import com.example.duan1.KhachHang.NhaHang.NhaHangTieuBieuAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class NhaHangDao {


    public static void readNhaHang(final UpdateAndDeleteNhaHangAdapter Adapter, final Context context) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("NhaHang");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Adapter.resetAdapter();
                    for (DataSnapshot i : snapshot.getChildren()) {
                        NhaHang nhaHang = i.getValue(NhaHang.class);
                        Adapter.updateAdapter(nhaHang);
                    }
                } else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void readNhaHangTieuBieu(final NhaHangTieuBieuAdapter Adapter, final Context context) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("NhaHangTieuBieu");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Adapter.resetAdpter();
                    for (DataSnapshot i : snapshot.getChildren()) {
                        NhaHangTieuBieu nhaHangTieuBieu = i.getValue(NhaHangTieuBieu.class);
                        Adapter.updateAdapter(nhaHangTieuBieu);
                    }
                } else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void updateNhaHang(String MaNhaHang, NhaHang nhaHang) {
        Map<String, Object> map = new HashMap();
        map.put("nhKhuVuc", nhaHang.getNhKhuVuc());
        map.put("nhLat", nhaHang.getNhLat());
        map.put("nhLog", nhaHang.getNhLog());
        map.put("nhName", nhaHang.getNhName());
        map.put("nhNhomNhaHang", nhaHang.getNhNhomNhaHang());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("NhaHang");
        databaseReference.child(MaNhaHang).updateChildren(map);


    }

    public static void deleteNhahang(String MaNhaHang, final int position, final UpdateAndDeleteNhaHangAdapter adapter) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("NhaHang");
        databaseReference.child(MaNhaHang).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                adapter.onDeleteSuccessful(position);
            }
        });


    }

    public static double TinhKhoangCachNhaHang(Double lat1, Double lon1, Double lat2, Double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);

    }
    public static void readNhaHangKhachHang(final DanhSachNhaHangAdapter Adapter, final Context context) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("NhaHang");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Adapter.resetAdapter();
                    for (DataSnapshot i : snapshot.getChildren()) {
                        NhaHang nhaHang = i.getValue(NhaHang.class);
                        Adapter.updateAdapter(nhaHang);
                    }
                } else {
                    Toast.makeText(context, "Cảnh báo: Không có dữ liệu", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
