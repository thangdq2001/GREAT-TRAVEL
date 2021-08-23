package com.example.duan1.Admin.Fragment.Dialog.Nhahang;

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

import com.example.duan1.Admin.Model.NhaHang;
import com.example.duan1.Dao.NhaHangDao;
import com.example.duan1.R;

public class DialogUpdateNhaHang extends DialogFragment {
    EditText khuVuc, Lat, Log, name, Nhom;
    Button cancel,update;
    String id;

    // id được lấy từ contrustor
    public DialogUpdateNhaHang(String id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_update_data_nhahang, container, false);
        khuVuc = view.findViewById(R.id.edtUpdateKhuVucNhahang);
        Lat = view.findViewById(R.id.edtUpdateLatNhaHang);
        Log = view.findViewById(R.id.edtUpdateLogNhaHang);
        Nhom = view.findViewById(R.id.edtUpdateNhomNhaHang);
        name = view.findViewById(R.id.edtUpdateNameNhaHang);
        cancel = view.findViewById(R.id.btnCancelDialogUpdateNhaHang);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        update = view.findViewById(R.id.btnUpdateDialogNhaHang);
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
        String NhomNh = String.valueOf(Nhom.getText().toString());
        String KhuVucNhaHang = String.valueOf(khuVuc.getText().toString());
        String nameNhaHang = String.valueOf(name.getText().toString());
        double lat = Double.parseDouble(String.valueOf(Lat.getText().toString()));
        double log = Double.parseDouble(String.valueOf(Log.getText().toString()));
        NhaHang nh = new NhaHang(id, nameNhaHang, lat, log, NhomNh, KhuVucNhaHang);
        NhaHangDao.updateNhaHang(id, nh);
        Toast.makeText(getContext(), "Update Thành Công", Toast.LENGTH_SHORT).show();

    }
}
