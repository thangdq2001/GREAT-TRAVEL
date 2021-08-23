package com.example.duan1.KhachHang.chuyenBayFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThanhToanChuyenBay extends Fragment {
    String MaCb,TimeBay,AmoutBay;
    Double Price,Vat,Phi;


    public ThanhToanChuyenBay(String maChuyenBay,String thoiGianBay,String thoiLuongBay,Double giaVe,Double thue,Double phi){
        this.MaCb = maChuyenBay;
        this.TimeBay = thoiGianBay;
        this.AmoutBay = thoiLuongBay;
        this.Price = giaVe;
        this.Vat = thue;
        this.Phi = phi;

    }

    TextView maChuyenBay,thoiGianBay,thoiLuongBay,giaVe,thue,phi,tongTien,timeNow;
    Button thanhToan,QuaiLai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_thanh_toan_chuyenbay, container, false);

        // tham chieu
        maChuyenBay = view.findViewById(R.id.txtMaChuyenBayThanhToan);
        thoiGianBay = view.findViewById(R.id.txtThoiGianBayThanhToan);
        thoiLuongBay = view.findViewById(R.id.txtThoiLuongBayThanhToan);
        giaVe = view.findViewById(R.id.txtGiaVeThanhToan);
        thue = view.findViewById(R.id.txtThueThanhToan);
        phi = view.findViewById(R.id.txtPhiThanhToan);
        tongTien = view.findViewById(R.id.txtTongTienThanhToan);
        timeNow = view.findViewById(R.id.txtShowTimeNow);
        thanhToan = view.findViewById(R.id.btnThanhToanChuyenBay);
        QuaiLai = view.findViewById(R.id.btnOutFragment);

        QuaiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new danhsachchuyenbayFragmentKH()).commit();
            }
        });

        thanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HoanThanhThanhToanCb()).commit();
            }
        });

        // tinh toan;
        Double vat = Vat*100;
        Double TongTien = (Price * Vat) + Price + Phi;

        // settext

        maChuyenBay.setText(MaCb);
        thoiGianBay.setText(TimeBay);
        thoiLuongBay.setText(AmoutBay);

        giaVe.setText(String.valueOf(Price));
        thue.setText(String.valueOf(vat+"%"));
        phi.setText(String.valueOf(Phi));
        tongTien.setText(String.valueOf(TongTien));


        // setTimeNow
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        String date = df.format(Calendar.getInstance().getTime());
        timeNow.setText(String.valueOf(date));


        return  view;
    }
}
