package com.example.duan1.Admin.Fragment.Dialog.User;

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

import com.example.duan1.R;

public class AddUserDialog  extends DialogFragment {
    EditText Username,Password,NickName,Mail,Sdt,DiaChi;
    Button cancel,add;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addatauser, container, false);
        
        // tham chieu
        Username = view.findViewById(R.id.edtAddUserName);
        Password = view.findViewById(R.id.edtAddPassword);
        NickName = view.findViewById(R.id.edtAddName);
        Mail = view.findViewById(R.id.edtAddMail);
        Sdt = view.findViewById(R.id.edtAddSdt);
        DiaChi = view.findViewById(R.id.edtAddDiaChi);
        
        cancel = view.findViewById(R.id.btnCanCelDiaLogAddDataUser);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        
        add = view.findViewById(R.id.btnAddDataUser);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AddDAtaUser();
//             x`
                Handler h =new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Add thanh cong", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                },1500);
            }
        });
        return view;
    }
//    public void addData(){
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserInFo");
//        String username =String.valueOf(Username.getText().toString());
//        String nickname =String.valueOf(NickName.getText().toString());
//        String mail =String.valueOf(Mail.getText().toString());
//        String sdt =String.valueOf(Sdt.getText().toString());
//        String diachi =String.valueOf(DiaChi.getText().toString());
//        String id = databaseReference.push().getKey();
//        UserInfo userInfo = new UserInfo(id,username,nickname,mail,diachi,sdt);
//        databaseReference.child(id).setValue(userInfo);
//    }
//    public void  AddDAtaUser(){
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User");
//        String username =String.valueOf(Username.getText().toString());
//        String password = String.valueOf(Password.getText().toString());
//        String idUser = databaseReference.push().getKey();
//        User user = new User(username,password,idUser);
//        databaseReference.child(idUser).setValue(user);
//    }
}
