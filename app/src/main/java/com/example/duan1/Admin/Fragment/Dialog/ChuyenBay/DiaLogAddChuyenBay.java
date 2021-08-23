package com.example.duan1.Admin.Fragment.Dialog.ChuyenBay;

import android.os.Bundle;
import android.os.Handler;
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
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DiaLogAddChuyenBay extends DialogFragment {
    EditText  maChuyenBay,thoiGianBay,thoiGianDen,DiembatDau,DiemKetthuc,GiaVe,SanBay,HangBay,ThoiLuongBay,Thue,Phi,TongTien;
    Button cancel,adddata;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_data_chuyenbay,container,false);
        maChuyenBay = view.findViewById(R.id.edtUpdateMaChuyenBay) ;
        thoiGianBay = view.findViewById(R.id.edtUpdateThoiGianBay) ;
        thoiGianDen = view.findViewById(R.id.edtUpdateThoiGianDen) ;
        DiembatDau = view.findViewById(R.id.edtUpdateDiemBatDau) ;
        DiemKetthuc = view.findViewById(R.id.edtUpdateDiemKetThuc) ;
        GiaVe = view.findViewById(R.id.edtUpdateGiaVe) ;
        SanBay = view.findViewById(R.id.edtUpdateSanBay) ;
        HangBay = view.findViewById(R.id.edtUpdateHangBay) ;
        ThoiLuongBay = view.findViewById(R.id.edtUpdateThoiLuongBay) ;
        Thue = view.findViewById(R.id.edtUpdateThue) ;
        Phi = view.findViewById(R.id.edtUpdatePhi) ;
        TongTien = view.findViewById(R.id.edtUpdateTongTien) ;
        cancel = view.findViewById(R.id.btnCancelDialogUpdateChuyenBay);
        adddata = view.findViewById(R.id.btnAddDataDialogChuyenbay);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Toast.makeText(getContext(), "Hủy Thực hiện", Toast.LENGTH_SHORT).show();
            }
        });
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataChuyenBay();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Add Success", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                },1500);
            }
        });




        return view;
    }
    public void addDataChuyenBay(){
        String MaChuyenBay = String.valueOf(maChuyenBay.getText().toString());
        String timeBay = String.valueOf(thoiGianBay.getText().toString());
        String timeDen = String.valueOf(thoiGianDen.getText().toString());
        String diemBatDau = String.valueOf(DiembatDau.getText().toString());
        String diemKetThuc = String.valueOf(DiemKetthuc.getText().toString());
        Double giaVe = Double.parseDouble(GiaVe.getText().toString());
        String sanBay = String.valueOf(SanBay.getText().toString());
        String hangBay = String.valueOf(HangBay.getText().toString());
        String thoiLuongBay = String.valueOf(ThoiLuongBay.getText().toString());
        Double thue  = Double.parseDouble(Thue.getText().toString());
        Double  phi = Double.parseDouble(Phi.getText().toString());
        Double tongTien = Double.parseDouble(TongTien.getText().toString());

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChuyenBay");
        String id = databaseReference.push().getKey();
        ChuyenBay cb = new ChuyenBay(id,MaChuyenBay,timeBay,timeDen,diemBatDau,diemKetThuc,giaVe,sanBay,hangBay,thoiLuongBay,thue,phi,tongTien);
        databaseReference.child(id).setValue(cb);




    }

}
