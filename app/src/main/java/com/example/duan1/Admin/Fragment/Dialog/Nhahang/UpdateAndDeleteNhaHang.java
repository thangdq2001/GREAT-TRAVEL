package com.example.duan1.Admin.Fragment.Dialog.Nhahang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.NhaHangDao;
import com.example.duan1.R;

public class UpdateAndDeleteNhaHang extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachnhaahng_update_and_delete, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rcDanhSachNhaHang);
        UpdateAndDeleteNhaHangAdapter Adapter = new UpdateAndDeleteNhaHangAdapter(getChildFragmentManager(),getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(layoutManager);
        NhaHangDao.readNhaHang(Adapter,getContext());
        return view;
    }

}
