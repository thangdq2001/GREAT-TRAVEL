//package com.example.duan1.Admin.Fragment.Dialog.KhachSan;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.DialogFragment;
//
//import com.example.duan1.Admin.Model.KhachSanPhong;
//import com.example.duan1.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class KhachSanPhongAddDiaLog extends DialogFragment {
//    EditText khachSanLoaiPhong, khacSanGiaGoc, khachSanSoPhong, khachSanSoLuongPhong,khachSanGiamGia,khachSanGiaPhong;
//    Button cancel, add;
//    String
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.khachsan_phong_dialog_add_data, container, false);
//        khachSanLoaiPhong = view.findViewById(R.id.edtAddLoaiPhongKhachSan);
//        khacSanGiaGoc = view.findViewById(R.id.edtAddGiaGocPhong);
//        khachSanSoPhong = view.findViewById(R.id.edtAddSoPhong);
//        khachSanSoLuongPhong = view.findViewById(R.id.edtAddSoLuongPhong);
//        khachSanGiamGia = view.findViewById(R.id.edtAddGiamGiaPhong);
//        khachSanGiaPhong = view.findViewById(R.id.edtAddGiaPhong);
//
//
//
//        // cancel dialog
//        cancel = view.findViewById(R.id.btnCancelDialogAddPhongKhachSan);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getDialog().dismiss();
//                Toast.makeText(getActivity(), "Hủy Thực Hiện", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // add data button;
//        add = view.findViewById(R.id.btnAddDataDiaLogKhachSan);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                addData();
//
//            }
//        });
//
//
//        return view;
//
//    }
//    public void addData(){
//        // Ánh sạ
//        final  String loaiPhong = String.valueOf(khachSanLoaiPhong.getText().toString());
//        final double giaGoc = Double.parseDouble(khacSanGiaGoc.getText().toString());
//        final double giamGia = Double.parseDouble(khachSanGiamGia.getText().toString());
//        final  double gia  = Double.parseDouble(khachSanGiaPhong.getText().toString());
//        final String soPhong = String.valueOf(khachSanSoPhong.getText().toString());
//        final  int soLuongPhong = Integer.parseInt(khachSanSoLuongPhong.getText().toString());
//
//
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PhongKhachSan");
//        String id = databaseReference.push().getKey();
//        KhachSanPhong ksp = new KhachSanPhong(idKhac,loaiPhong,giaGoc,soPhong,soLuongPhong,giamGia,gia);
//        databaseReference.child(id).setValue(ksp);
//
//    }
//
//
//}
