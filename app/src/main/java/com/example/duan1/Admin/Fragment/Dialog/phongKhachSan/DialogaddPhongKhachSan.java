package com.example.duan1.Admin.Fragment.Dialog.phongKhachSan;

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

import com.example.duan1.Admin.Model.KhachSanPhong;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogaddPhongKhachSan extends DialogFragment {
    EditText LoaiPhong,GiagocPhong,soPhong,SoluongPhong,giamGia,giaPhong;
    Button cancel,addData;
    String idKhachSan;



    public DialogaddPhongKhachSan(String idKhachSan) {
        this.idKhachSan = idKhachSan;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khachsan_phong_dialog_add_data, container, false);
        cancel = view.findViewById(R.id.btnCancelDialogAddPhongKhachSan);
        addData = view.findViewById(R.id.btnAddDataDiaLogKhachSan);


        LoaiPhong = view.findViewById(R.id.edtUpdateMaChuyenBay);
        GiagocPhong = view.findViewById(R.id.edtAddGiaGocPhong);
        soPhong = view.findViewById(R.id.edtAddSoPhong);
        SoluongPhong = view.findViewById(R.id.edtAddSoLuongPhong);
        giamGia = view.findViewById(R.id.edtAddGiamGiaPhong);
        giaPhong = view.findViewById(R.id.edtAddGiaPhong);
        //cancel dialog
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataPhongKhachSan();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                },1500);
            }
        });


        return view;
    }
    public void addDataPhongKhachSan(){
        String loaiPhong = String.valueOf(LoaiPhong.getText().toString());
        Double giaGocPhong = Double.parseDouble(GiagocPhong.getText().toString());
        String SoPhong = String.valueOf(soPhong.getText().toString());
        int slPhong = Integer.parseInt(SoluongPhong.getText().toString());
        Double GiamGia = Double.parseDouble(giamGia.getText().toString());
        Double Gia = Double.parseDouble(giaPhong.getText().toString());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
        String id = databaseReference.push().getKey();
        KhachSanPhong ksp = new KhachSanPhong(idKhachSan,id,loaiPhong,giaGocPhong,SoPhong,slPhong,GiamGia,Gia);
        databaseReference.child(id).setValue(ksp);



    }
}
