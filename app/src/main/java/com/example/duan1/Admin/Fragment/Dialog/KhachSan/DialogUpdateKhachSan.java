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
import com.example.duan1.Dao.KhachSanDao;
import com.example.duan1.R;

public class DialogUpdateKhachSan extends DialogFragment {
    EditText KhuVuc,lat,log,name;
    Button cancel,update;
    String id;
    public DialogUpdateKhachSan(String idKhachSan){
        this.id = idKhachSan;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_update_data_khachsan,container,false);
        KhuVuc = view.findViewById(R.id.edtUpdateKhuVucKhachSan);
        lat = view.findViewById(R.id.edtUpdateLatKhachSan);
        log = view.findViewById(R.id.edtUpdateLogKhachSan);
        name = view.findViewById(R.id.edtUpdateNameKhachSan);
        cancel = view.findViewById(R.id.btnCanelDiaLogUpdateKhachSan);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        update = view.findViewById(R.id.btnUpdateDiaLogKhachSan);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               updateData();
               Handler h = new Handler();
               h.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Toast.makeText(getContext(), "Update success", Toast.LENGTH_SHORT).show();
                       dismiss();
                   }
               },1200);
           }
       });

        return view;
    }
    public void updateData(){
        String kv = String.valueOf(KhuVuc.getText().toString());
        Double Lat = Double.parseDouble(lat.getText().toString());
        Double Log = Double.parseDouble(log.getText().toString());
        String nameKs = String.valueOf(name.getText().toString());
        KhachSan ks = new KhachSan(id,nameKs,Lat,Log,kv);
        KhachSanDao.updateKhachSan(id,ks);
        // cancel dialog

    }

}
