package com.example.duan1.Admin.Fragment.Dialog.Nhahang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;

public class AdminNhaHangFragment extends Fragment {
    RelativeLayout nhaHang;
    ImageView imgInfoNhaHang;
    ImageView add, update, delete, addMonAn, updateMonAn, deleteMonAn, addNhahangTieuBieu, updateNhaHangTieuBieu, deleteNhaHangTieuBieu, addMonAnTieuBieu, updateMonAnTieuBieu, deleteMonAnBieu;
    TextView xemChiTiet;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adminnhahangfragment, container, false);
        imgInfoNhaHang = view.findViewById(R.id.imgTileNhaHang);
        add = view.findViewById(R.id.NhIconAdd);
        update = view.findViewById(R.id.NhIconSua);
        delete = view.findViewById(R.id.NhIiconXoa);


        addNhahangTieuBieu = view.findViewById(R.id.NhTbIconAdd);
        updateNhaHangTieuBieu = view.findViewById(R.id.NhTbIconSua);
        deleteNhaHangTieuBieu = view.findViewById(R.id.NhTbIconXoa);
        xemChiTiet = view.findViewById(R.id.txtXemChiTietNhaHang);

        xemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new UpdateAndDeleteNhaHang()).commit();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhaHangAddDataDiaLog nhaHangAddDataDiaLog = new NhaHangAddDataDiaLog();
                nhaHangAddDataDiaLog.show(getChildFragmentManager(), "NhaHangAddDataDiaLog");
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new UpdateAndDeleteNhaHang()).commit();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new UpdateAndDeleteNhaHang()).commit();
            }
        });

        // Nha Hang tieu bieu
        addNhahangTieuBieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhaHangTieuBieuAddDataDiaLog NhaHangtieuBieuDiaLog = new NhaHangTieuBieuAddDataDiaLog();
                NhaHangtieuBieuDiaLog.show(getChildFragmentManager(), "NhaHangTieuBieuAddDataDiaLog");
            }
        });


        return view;


    }
}
