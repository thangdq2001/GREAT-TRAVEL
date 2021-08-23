package com.example.duan1.KhachHang.KhachSan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.KhachSanPhongDao;
import com.example.duan1.R;

public class DanhSachPhong extends Fragment {
    FragmentManager fragmentManager;
    Context context;
    ImageView backThue;
    String idKs;

    public DanhSachPhong(FragmentManager fragmentManager, Context context, String idKs) {
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.idKs = idKs;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachphong_fragment, container, false);
        backThue = view.findViewById(R.id.imgBackPhong);
        RecyclerView recyclerView = view.findViewById(R.id.recPhongKhachSan);
        DanhSachPhongAdapter adapter = new DanhSachPhongAdapter(fragmentManager,context) ;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        KhachSanPhongDao.readAllKh(idKs,adapter,context);
        return view;
    }
}
