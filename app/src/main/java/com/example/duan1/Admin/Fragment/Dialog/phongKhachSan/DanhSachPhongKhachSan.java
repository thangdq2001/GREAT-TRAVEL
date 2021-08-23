package com.example.duan1.Admin.Fragment.Dialog.phongKhachSan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.KhachSanPhongDao;
import com.example.duan1.R;

public class DanhSachPhongKhachSan extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.danhsach_phong_khachsan_view,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.rcViewDanhSachPhongKhachSan);
        DanhSachPhongKhachSanAdapter adapter = new DanhSachPhongKhachSanAdapter(getContext(),getChildFragmentManager());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        KhachSanPhongDao.readPhong(adapter,getContext());
        return view;
    }
}
