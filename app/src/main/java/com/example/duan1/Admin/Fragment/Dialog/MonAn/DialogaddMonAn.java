package com.example.duan1.Admin.Fragment.Dialog.MonAn;

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

import com.example.duan1.Admin.Model.MonAn;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogaddMonAn extends DialogFragment {
    EditText TenMonAn,NhomMonAn,Gia;
    Button cancel,addData;
    String idNhaHang;

    public DialogaddMonAn(String idNhaHang) {
        this.idNhaHang = idNhaHang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monan_dialog_add_data, container, false);
        TenMonAn = view.findViewById(R.id.edtAddNameMonAn);
        NhomMonAn = view.findViewById(R.id.edtAddNhomMonAn);
        Gia = view.findViewById(R.id.edtAddGiaMonAn);
        cancel = view.findViewById(R.id.btnCancelDialogAdMonAn);
        addData = view.findViewById(R.id.btnAddDataDiaLogMonAn);

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
                addDataMonAn();
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
    public void addDataMonAn(){
        String name = String.valueOf(TenMonAn.getText().toString());
        String Nhom = String.valueOf(NhomMonAn.getText().toString());
        Double gia = Double.parseDouble(Gia.getText().toString());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("MonAn");
        String idMonAn = databaseReference.push().getKey();
        MonAn monAn = new MonAn(idNhaHang,idMonAn,name,Nhom,gia);
        databaseReference.child(idMonAn).setValue(monAn);



    }
}
