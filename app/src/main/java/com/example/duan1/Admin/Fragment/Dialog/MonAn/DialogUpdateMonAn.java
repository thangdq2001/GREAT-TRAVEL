package com.example.duan1.Admin.Fragment.Dialog.MonAn;

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

import com.example.duan1.Admin.Model.MonAn;
import com.example.duan1.Dao.MonAnDao;
import com.example.duan1.R;

public class DialogUpdateMonAn extends DialogFragment {
    EditText tenMon, giaMon, nhomMon;
    Button cancel, update;
    String idNhaHang;
    String idMonAn;

    // id được lấy từ contrustor
    public DialogUpdateMonAn(String nhMaId, String id) {
        this.idNhaHang = id;
        this.idMonAn = nhMaId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_update_data_monan, container, false);
        tenMon = view.findViewById(R.id.edtUpdateTenMon);
        giaMon = view.findViewById(R.id.edtUpdateGiamon);
        nhomMon = view.findViewById(R.id.edtUpdateNhomMon);
        cancel = view.findViewById(R.id.btnCanceldialogUpdateMonAn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        update = view.findViewById(R.id.btnUpdateDialogUpdateMonAn);
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
        String name = String.valueOf(tenMon.getText().toString());
        Double gia = Double.parseDouble(giaMon.getText().toString());
        String nhom = String.valueOf(nhomMon.getText().toString());
        MonAn monAn = new MonAn(idMonAn, idNhaHang,name,nhom,gia);
        MonAnDao.updateMonAn(idMonAn, monAn);
        Toast.makeText(getContext(), "Update Thành Công", Toast.LENGTH_SHORT).show();

    }
}
