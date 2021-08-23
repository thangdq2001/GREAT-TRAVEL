package com.example.duan1.KhachHang.NhaHang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.NhaHangTieuBieu;
import com.example.duan1.Admin.Model.User;
import com.example.duan1.Dao.NhaHangDao;
import com.example.duan1.KhachHang.HomeFragMent;
import com.example.duan1.MainActivity;
import com.example.duan1.R;

import java.util.ArrayList;

public class NhaHangFragmentKhachHang extends Fragment {
    User user;
    ArrayList<NhaHangTieuBieu> arrayList2;
    TextView diaChi;
    DanhSachNhaHangAdapter adapter;
    NhaHangTieuBieuAdapter adapter2;
    ImageView backHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nhahang_khachang, container, false);
        // tham chieu
        diaChi = view.findViewById(R.id.txtLocaitonKh);
        diaChi.setText(String.valueOf(((MainActivity)getContext()).getDiaChi()));

        backHome = view.findViewById(R.id.imgBackHome);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HomeFragMent()).commit();
            }
        });

        RecyclerView recyclerView1 = view.findViewById(R.id.rcBody);
        adapter2 = new NhaHangTieuBieuAdapter(getChildFragmentManager(), getContext());
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView1.setAdapter(adapter2);
        recyclerView1.setLayoutManager(manager2);


        RecyclerView recyclerView = view.findViewById(R.id.recViewDanhSachNhaHangKhachHang);
        adapter = new DanhSachNhaHangAdapter(getContext(), getChildFragmentManager());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        NhaHangDao.readNhaHangKhachHang(adapter, getContext());
        NhaHangDao.readNhaHangTieuBieu(adapter2,getContext());


        return view;
    }

}
