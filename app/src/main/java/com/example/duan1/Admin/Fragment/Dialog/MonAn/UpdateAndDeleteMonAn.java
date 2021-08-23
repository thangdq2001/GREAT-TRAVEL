package com.example.duan1.Admin.Fragment.Dialog.MonAn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.MonAnDao;
import com.example.duan1.R;

public class UpdateAndDeleteMonAn extends Fragment {
    ImageView addMonAnNhaHang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachmonan_update_and_delete, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rcDanhSachMonAn);
        UpdateAndDeleteMonAnAdapter Adapter = new UpdateAndDeleteMonAnAdapter(getChildFragmentManager());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(layoutManager);
        MonAnDao.readMonAn(Adapter,getContext());
        return view;
    }

}
