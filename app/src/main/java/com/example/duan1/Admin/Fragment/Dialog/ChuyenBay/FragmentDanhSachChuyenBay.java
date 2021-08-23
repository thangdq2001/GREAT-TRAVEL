package com.example.duan1.Admin.Fragment.Dialog.ChuyenBay;

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

public class FragmentDanhSachChuyenBay extends Fragment {
    DanhSachChuyenBayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachchuyenbay_view, container, false);
        adapter = new DanhSachChuyenBayAdapter(getContext(),getChildFragmentManager());
        RecyclerView recyclerView = view.findViewById(R.id.rcDanhSachChuyenBay);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        ChuyenBayDao.readChuyenBay(adapter,getContext());
        return view;
    }
}
