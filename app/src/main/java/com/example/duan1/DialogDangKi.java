package com.example.duan1;

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

import com.example.duan1.Admin.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogDangKi extends DialogFragment {
    EditText name,password,pass2,username,diachi,sdt,mail;
    Button cancel,dangki;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.dangki, container, false);

        name = view.findViewById(R.id.edtName);
        password = view.findViewById(R.id.edtPassWord);
        pass2 = view.findViewById(R.id.edtNhaplaiPassWord);
        username = view.findViewById(R.id.edtUser);
        diachi = view.findViewById(R.id.edtDiaChi);
        sdt = view.findViewById(R.id.edtSdt);
        mail = view.findViewById(R.id.edtMail);

        cancel = view.findViewById(R.id.btnCanCelDiaLogDanKi);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        dangki = view.findViewById(R.id.btnAddDataUser);
      dangki.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              addData();
              Handler h = new Handler();
              h.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Toast.makeText(getContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                      dismiss();
                  }
              },1200);
          }
      });
        return  view;
    }
    public void addData(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User");
        String ten = String.valueOf(name.getText().toString());
        String user = String.valueOf(username.getText().toString());
        String location = String.valueOf(diachi.getText().toString());
        String pass = String.valueOf(password.getText().toString());
        String confimpass = String.valueOf(pass2.getText().toString());
        String gmail = String.valueOf(mail.getText().toString());
        String phone = String.valueOf(sdt.getText().toString());
         if(pass.equals(confimpass)){
             String id = databaseReference.push().getKey();
             User item = new User(user,pass,id,ten,location,phone,gmail);
             databaseReference.child(id).setValue(item);
         }else {
             Toast.makeText(getContext(), "Pass word không giống nhau!", Toast.LENGTH_SHORT).show();
         }





    }
}
