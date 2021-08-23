package com.example.duan1.Admin.Fragment.Dialog.KhachSan;

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

import com.example.duan1.Admin.Model.KhachSan;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KhachSanAddDiaLog extends DialogFragment {
    EditText khachSanName, khachSanLog, khachSanLat, khachSanKhuVuc;
    Button cancel, add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khachsan_dialog_add_data, container, false);
        khachSanName = view.findViewById(R.id.edtAddNameKhachSan);
        khachSanLat = view.findViewById(R.id.edtAddLatKhachSan);
        khachSanLog = view.findViewById(R.id.edtAddLogKhachSan);
        khachSanKhuVuc = view.findViewById(R.id.edtAddKhuVucKhachSan);


        // cancel dialog
        cancel = view.findViewById(R.id.khacSanDialogCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
                Toast.makeText(getActivity(), "Hủy Thực Hiện", Toast.LENGTH_SHORT).show();
            }
        });

        // add data button;
        add = view.findViewById(R.id.khachSanDiaLogAddData);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addData();
                Handler hun = new Handler();
                hun.postDelayed(new Runnable() {
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
    public void addData(){
        // Ánh sạ
        final  String name = String.valueOf(khachSanName.getText().toString());
        final double lat = Double.parseDouble(khachSanLat.getText().toString());
        final double log = Double.parseDouble(khachSanLog.getText().toString());
        final  String khuVuc = String.valueOf(khachSanKhuVuc.getText().toString());

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("KhachSan");
        String id = databaseReference.push().getKey();
        KhachSan ks = new KhachSan(id,name,lat,log,khuVuc);
        databaseReference.child(id).setValue(ks);

    }


}
