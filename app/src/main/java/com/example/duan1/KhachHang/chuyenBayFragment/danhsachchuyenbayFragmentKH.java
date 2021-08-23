package com.example.duan1.KhachHang.chuyenBayFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.ChuyenBayDao;
import com.example.duan1.R;

public class danhsachchuyenbayFragmentKH extends Fragment {
    CustomDanhhSachchuyenBayKhAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachchuyenbayfragment_kh, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recViewDanhSachChuyenBayKh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new CustomDanhhSachchuyenBayKhAdapter(getChildFragmentManager(),getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        ChuyenBayDao.readChuyenBayKhachHang(adapter,getContext());
        return view;
    }
}
