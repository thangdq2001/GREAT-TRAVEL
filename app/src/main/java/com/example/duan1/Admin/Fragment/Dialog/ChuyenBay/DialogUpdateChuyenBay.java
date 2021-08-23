package com.example.duan1.Admin.Fragment.Dialog.ChuyenBay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.duan1.Admin.Model.ChuyenBay;
import com.example.duan1.Dao.ChuyenBayDao;
import com.example.duan1.R;

public class DialogUpdateChuyenBay extends DialogFragment {
    EditText maChuyenBay,thoiGianBay,thoiGianDen,diemBatDau,diemKetThuc,giaVe,sanBay,Hangbay,thoiLuongBay,thue,phi,tongTien;
    Button cancel,update;
    String id;

    public DialogUpdateChuyenBay(String id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.dialog_update_data_chuyenbay, container, false);
       cancel = view.findViewById(R.id.btnCancelDialogUpdateChuyenBay);
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dismiss();
               Toast.makeText(getContext(), "Hủy thực hiện", Toast.LENGTH_SHORT).show();
           }
       });


       update = view.findViewById(R.id.btnUpdateDiaLogChuyenBay);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               UpdateData();
               Toast.makeText(getContext(), "Update Thành công", Toast.LENGTH_SHORT).show();
           }
       });


       maChuyenBay = view.findViewById(R.id.edtUpdateMaChuyenBay);
       thoiGianBay = view.findViewById(R.id.edtUpdateThoiGianBay);
       thoiGianDen = view.findViewById(R.id.edtUpdateThoiGianDen);
        thoiGianDen = view.findViewById(R.id.edtUpdateThoiGianDen);
        diemBatDau = view.findViewById(R.id.edtUpdateDiemBatDau);
        diemKetThuc = view.findViewById(R.id.edtUpdateDiemKetThuc);
        giaVe = view.findViewById(R.id.edtUpdateGiaVe);
        sanBay = view.findViewById(R.id.edtUpdateSanBay);
        Hangbay = view.findViewById(R.id.edtUpdateHangBay);
        thoiLuongBay = view.findViewById(R.id.edtUpdateThoiLuongBay);
        thue = view.findViewById(R.id.edtUpdateThue);
        phi = view.findViewById(R.id.edtUpdatePhi);
        tongTien = view.findViewById(R.id.edtUpdateTongTien);



       return view;
    }
    public void UpdateData(){
        String MaChuyenBay = String.valueOf(maChuyenBay.getText().toString());
        String timeBay = String.valueOf(thoiGianBay.getText().toString());
        String timeDen = String.valueOf(thoiGianDen.getText().toString());
        String DiemBatDau = String.valueOf(diemBatDau.getText().toString());
        String DiemKetThuc = String.valueOf(diemKetThuc.getText().toString());
        Double GiaVe = Double.parseDouble(giaVe.getText().toString());
        String SanBay = String.valueOf(sanBay.getText().toString());
        String hangBay = String.valueOf(Hangbay.getText().toString());
        String ThoiLuongBay = String.valueOf(thoiLuongBay.getText().toString());
        Double Thue  = Double.parseDouble(thue.getText().toString());
        Double  Phi = Double.parseDouble(phi.getText().toString());
        Double TongTien = Double.parseDouble(tongTien.getText().toString());

        // Contrustor
        ChuyenBay chuyenBay = new ChuyenBay(id,MaChuyenBay,timeBay,timeDen,DiemBatDau,DiemKetThuc,GiaVe,SanBay,hangBay,ThoiLuongBay,Thue,Phi,TongTien);
        ChuyenBayDao.UpdateChuyenBay(id,chuyenBay);

    }
}
