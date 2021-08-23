package com.example.duan1.Admin.Fragment.Dialog.phongKhachSan;

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

import com.example.duan1.Admin.Model.KhachSanPhong;
import com.example.duan1.Dao.KhachSanPhongDao;
import com.example.duan1.R;

public class DialogUpdatePhong extends DialogFragment {
    EditText giaGoc,giaPhong,giamGia,loai,soPhong,soLuongPhong;
    Button cancel, update;
   String idPhong,idKhachSan;

    // id được lấy từ contrustor
    public DialogUpdatePhong(String idPhong, String idKhachSan) {
        this.idPhong = idPhong;
        this.idKhachSan = idKhachSan;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogupdate_phong_khachsan, container, false);
        giaGoc = view.findViewById(R.id.edtUpdateGiaGocPhong);
        giaPhong = view.findViewById(R.id.edtUpdateGiaPhong);
        giamGia = view.findViewById(R.id.edtUpdategiamGiaPhong);
        loai = view.findViewById(R.id.edtUpdateLoaiPhong);
        soPhong = view.findViewById(R.id.edtUpdateSoPhong);
        soLuongPhong = view.findViewById(R.id.edtUpdateSoLuong);

        // tham chieu button;
        cancel = view.findViewById(R.id.btnCancelDiaLogUpdatePhong);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        update = view.findViewById(R.id.btnUpdateDialogPhong);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                dismiss();
            }
        });
        return view;
    }

    public void updateData() {
       Double GiaGoc = Double.parseDouble(giaGoc.getText().toString());
        Double GiaPhong = Double.parseDouble(giaPhong.getText().toString());
        Double GiamGia = Double.parseDouble(giamGia.getText().toString());
        String Loai =String.valueOf(loai.getText().toString());
        int   SoLuong = Integer.parseInt(soLuongPhong.getText().toString());
        String SoPhong = String.valueOf(soPhong.getText().toString());
        KhachSanPhong ksp = new KhachSanPhong(idKhachSan,idPhong,Loai,GiaGoc,SoPhong,SoLuong,GiamGia,GiaPhong);
        KhachSanPhongDao.updatePhong(idPhong,ksp);
        Toast.makeText(getContext(), "Update Thành Công", Toast.LENGTH_SHORT).show();

    }
}
