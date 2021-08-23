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

import com.example.duan1.Admin.Model.Admin;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogAddDataAdmin extends DialogFragment {
    EditText username,password;
    Button cancel,addData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addadmin, container, false);
         username = view.findViewById(R.id.edtAddUserNameAdMin);
         password = view.findViewById(R.id.edtAddPassAdMin);
          cancel = view.findViewById(R.id.btnCanceldialogAdmin);
          cancel.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  dismiss();
              }
          });
          addData = view.findViewById(R.id.btnAddDataDialogAdmin);
          addData.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  addDataDialog();
                  Handler h = new Handler();
                  h.postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          Toast.makeText(getContext(), "Add Data Success", Toast.LENGTH_SHORT).show();
                          dismiss();
                      }
                  },1200);
              }
          });


        return  view;
    }
    public void addDataDialog(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
        String UserName = username.getText().toString();
        String Pass = password.getText().toString();
        String id = databaseReference.push().getKey();
        Admin ad = new Admin(id,UserName,Pass);
        databaseReference.child(id).setValue(ad);

    }
}
