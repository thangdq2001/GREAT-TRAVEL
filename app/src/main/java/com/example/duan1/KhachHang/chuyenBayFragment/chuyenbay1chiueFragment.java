package com.example.duan1.KhachHang.chuyenBayFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.KhachHang.chuyenBayFragment.CustomSpinerOptionAmountKhach.CustomSpinerOptionAmountKhach;
import com.example.duan1.KhachHang.chuyenBayFragment.CustomSpinerOptionAmountKhach.CustomSpinerOptionAmoutKhachAdapter;
import com.example.duan1.R;

import java.util.ArrayList;

public class chuyenbay1chiueFragment extends Fragment {
    EditText flightGo,flightOut;
    TextView dateGo,dateOut,thangGo,thangOut,thuGo,thuOut,GioOut;
    ImageView imgChangeDataEdt;
    private ArrayList<CustomSpinerOptionAmountKhach> customArrayList;
    private CustomSpinerOptionAmoutKhachAdapter customSpinerOptionAmoutKhachAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chuyenbay1chieu, container, false);


        flightGo = view.findViewById(R.id.edtBayDi);
        flightOut = view.findViewById(R.id.edtBayDen);
        imgChangeDataEdt = view.findViewById(R.id.imgChangeInfoMationText);
        imgChangeDataEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = String.valueOf(flightGo.getText().toString());
                String b = String.valueOf(flightOut.getText().toString());
                flightGo.setText(a);
                flightOut.setText(b);
            }
        });
        customSpiner();
        // Custom spiner
        Spinner spinner = view.findViewById(R.id.spnerOptionAmountKhach);
        customSpinerOptionAmoutKhachAdapter = new CustomSpinerOptionAmoutKhachAdapter(getActivity(),customArrayList);
        spinner.setAdapter(customSpinerOptionAmoutKhachAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CustomSpinerOptionAmountKhach clickiTem = (CustomSpinerOptionAmountKhach)adapterView.getItemAtPosition(i);
                String clickItemName = clickiTem.getTextOption();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
    private void customSpiner(){
        customArrayList = new ArrayList<>();
        customArrayList.add(new CustomSpinerOptionAmountKhach("1 H??nh kh??ch,Economy"));
        customArrayList.add(new CustomSpinerOptionAmountKhach("1 Kh??ch kh??ng h??nh l??"));
        customArrayList.add(new CustomSpinerOptionAmountKhach("1 Kh??ch h??nh l?? kh??ng qu??  25kg"));
        customArrayList.add(new CustomSpinerOptionAmountKhach("2 Kh??ch kh??ng h??nh l??"));
        customArrayList.add(new CustomSpinerOptionAmountKhach("2 Kh??ch h??nh l?? kh??ng qu?? 50kg"));

    }
}
