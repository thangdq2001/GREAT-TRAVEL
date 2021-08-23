package com.example.duan1.Admin.Fragment.Dialog.ChuyenBay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.Admin.Fragment.Dialog.User.AddUserDialog;
import com.example.duan1.Admin.Fragment.Dialog.User.DialogAddDataAdmin;
import com.example.duan1.R;

public class AdminChuyenBayFragment extends Fragment {
    TextView  xemChiTiet;
    ImageView addChuyenBay,addUser,addAdmin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adminchuyenbayfragment, container, false);
        xemChiTiet = view.findViewById(R.id.txtXemChiTietFragmentChuyenBay);
        xemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin,new FragmentDanhSachChuyenBay()).commit();
                Toast.makeText(getContext(), "Danh sách các chuyến bay ", Toast.LENGTH_SHORT).show();
            }
        });


        addChuyenBay = view.findViewById(R.id.CbAdd);
        addChuyenBay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaLogAddChuyenBay diaLogAddChuyenBay = new DiaLogAddChuyenBay();
                diaLogAddChuyenBay.show(getFragmentManager(),"DiaLogAddChuyenBay");
            }
        });
        addUser = view.findViewById(R.id.iconOpenDialogAddUser);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUserDialog addUserDialog = new AddUserDialog();
                addUserDialog.show(getFragmentManager(),"AddUserDialog");
            }
        });

         addAdmin = view.findViewById(R.id.addAdmin);
         addAdmin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DialogAddDataAdmin dialog = new DialogAddDataAdmin();
                 dialog.show(getFragmentManager(),"DialogAddDataAdmin");
             }
         });

        return view;
    }
}
