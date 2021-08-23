package com.example.duan1.KhachHang.chuyenBayFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;

public class HoanThanhThanhToanCb extends Fragment {
    ImageView QuaiLai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.thanhtoan_thanhcong_chuyenbay, container, false);
        Toast.makeText(getContext(), "Quét Code để thanh toán", Toast.LENGTH_LONG).show();

        QuaiLai = view.findViewById(R.id.imgqrcode);
        QuaiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new danhsachchuyenbayFragmentKH()).commit();
            }
        });

        return view;
    }
}
