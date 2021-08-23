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

import com.example.duan1.Admin.Model.NhaHang;
import com.example.duan1.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NhaHangAddDataDiaLog extends DialogFragment {
    EditText NhId,NhName,NhLat,NhLog,NhNhom,NhKhuVuc;
    Button cancel,addData;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nhahang_dialog_add_data, container, false);
        NhName = view.findViewById(R.id.edtAddNameNhaHang);
        NhLat = view.findViewById(R.id.edtAddLatNhahang);
        NhLog = view.findViewById(R.id.edtAddLogNhaHang);

        NhNhom = view.findViewById(R.id.edtAddNhomNhaHang);
        NhKhuVuc = view.findViewById(R.id.edtAddKhuVucNhahang);

        // cancel dialog
        cancel = view.findViewById(R.id.btnCancelDialogAddNhaHang);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dismiss();
            }
        });

        // add data dialog
        addData = view.findViewById(R.id.btnAddDataDiaLogNhaHang);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataNhaHang();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Add Thành Công", Toast.LENGTH_SHORT).show();
                       dismiss();

                    }
                },1500);
            }
        });


        return view;
    }
    private void addDataNhaHang(){
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        final  DatabaseReference databaseReference = mDatabase.getReference("NhaHang");

        final  String name = String.valueOf(NhName.getText().toString());
        final double lat = Double.parseDouble(NhLat.getText().toString());
        final double log = Double.parseDouble(NhLog.getText().toString());
        final String nhom = String.valueOf(NhNhom.getText().toString());
        final String KhuVuc = String.valueOf(NhKhuVuc.getText().toString());
        String id = databaseReference.push().getKey();
        NhaHang Nh = new NhaHang(id,name,lat,log,nhom,KhuVuc);
        databaseReference.child(id).setValue(Nh).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getContext(), "Add Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
