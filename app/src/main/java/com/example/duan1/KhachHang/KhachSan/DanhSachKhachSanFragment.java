package com.example.duan1.KhachHang.KhachSan;

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

import com.example.duan1.Dao.KhachSanDao;
import com.example.duan1.KhachHang.HomeFragMent;
import com.example.duan1.R;

public class DanhSachKhachSanFragment extends Fragment {
    ImageView back;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.danhsachkhachsan,container,false);
        back = view.findViewById(R.id.imgbackKs);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HomeFragMent()).commit();
            }
        });
        RecyclerView recView = view.findViewById(R.id.recViewDanhSachKhachSan);
        DanhSachKhachSanAdapter adapter = new DanhSachKhachSanAdapter(getChildFragmentManager(),getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recView.setAdapter(adapter);
        recView.setLayoutManager(manager);
        KhachSanDao.readKhachSanKh(adapter,getContext());


        return  view ;
    }
}
