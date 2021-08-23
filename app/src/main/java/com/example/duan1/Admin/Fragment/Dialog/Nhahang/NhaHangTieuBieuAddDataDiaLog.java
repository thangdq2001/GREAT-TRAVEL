package com.example.duan1.Admin.Fragment.Dialog.Nhahang;

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

import com.example.duan1.Admin.Model.NhaHangTieuBieu;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NhaHangTieuBieuAddDataDiaLog extends DialogFragment {
    EditText NhId,NhName,NhLat,NhLog,NhNhom,NhKhuVuc;
    Button cancel,addData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nhahangtieubieu_dialog_add_data, container, false);

        NhName = view.findViewById(R.id.edtAddNameNhaHangTieuBieu);
        NhLat = view.findViewById(R.id.edtAddLatNhaHangTieuBieu);
        NhLog = view.findViewById(R.id.edtAddLogNhaHangTieuBieu);

        NhNhom = view.findViewById(R.id.edtAddNhomNhaHangTieuBieu);
        NhKhuVuc = view.findViewById(R.id.edtAddKhuVucNhaHangTieuBieu);

        // cancel dialog
        cancel = view.findViewById(R.id.btnCancelDialogAddNhaHangTieuBieu);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        // add data dialog
        addData = view.findViewById(R.id.btnAddDataDiaLogNhaHangTieuBieu);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataNhaHang();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Thành Công", Toast.LENGTH_SHORT).show();
                        getDialog().dismiss();

                    }
                },1000);
            }
        });


        return view;
    }
    private void addDataNhaHang(){
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        final  DatabaseReference databaseReference = mDatabase.getReference("NhaHangTieuBieu");
        final  String name = String.valueOf(NhName.getText().toString());
        final double lat = Double.parseDouble(NhLat.getText().toString());
        final double log = Double.parseDouble(NhLog.getText().toString());
        final String nhom = String.valueOf(NhNhom.getText().toString());
        final String KhuVuc = String.valueOf(NhKhuVuc.getText().toString());
        String id = databaseReference.push().getKey();
        NhaHangTieuBieu Nh = new NhaHangTieuBieu(id,name,lat,log,nhom,KhuVuc);

        databaseReference.child(id).setValue(Nh);
    }
}
