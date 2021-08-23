package com.example.duan1.Admin.Fragment.Dialog.KhachSan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;

public class AdminKhachSanFragment extends Fragment {
    ImageView addKhachSan,updateKhachSan,deleteKhachSan,addPhong,updatePhong,deletePhong;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adminkhachsanfragment, container, false);
        addKhachSan = view.findViewById(R.id.KsAdd);
        updateKhachSan= view.findViewById(R.id.KsUpdate);
        deleteKhachSan = view.findViewById(R.id.KsDelete);
        addPhong = view.findViewById(R.id.KsPAdd);

        updatePhong = view.findViewById(R.id.KsPUpdate);
        deletePhong = view.findViewById(R.id.KsPdelete);
        addKhachSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachSanAddDiaLog khachSanAddDiaLog = new KhachSanAddDiaLog();
                khachSanAddDiaLog.show(getChildFragmentManager(),"KhachSanAddDiaLog");
            }
        });
        updateKhachSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin,new UpdateAndDeleteKhachSanFragment()
                ).commit();
            }
        });
        deleteKhachSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin,new UpdateAndDeleteKhachSanFragment()
                ).commit();
            }
        });
        return view;
    }
}
