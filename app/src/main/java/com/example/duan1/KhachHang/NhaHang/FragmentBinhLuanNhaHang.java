package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.UserComent;
import com.example.duan1.Dao.UserDao;
import com.example.duan1.KhachHang.NhaHang.Coment.DanhSachBinhLuanAdapter;
import com.example.duan1.MainActivity;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentBinhLuanNhaHang extends Fragment {

    Context context;
    FragmentManager fragmentManager;
    EditText edtPostBinhLuan;
    ImageView imgPostBinhLuan;
    TextView chuyenFragment;

    String idNhahang, nameNh, locaiton;

    public FragmentBinhLuanNhaHang(Context context, FragmentManager fragmentManager, String nameNh, String idNhahang, String KhoanCach) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.nameNh = nameNh;
        this.idNhahang = idNhahang;
        this.locaiton = KhoanCach;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.binhluanfragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recBinhLuan);
        DanhSachBinhLuanAdapter adapter = new DanhSachBinhLuanAdapter(getContext(), getChildFragmentManager());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        UserDao.readAll(idNhahang, adapter, getContext());
        UserDao.readDataInfo(adapter, getContext());

        chuyenFragment = view.findViewById(R.id.txtFragmentDatDon);
        chuyenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new GiaoDienChinhNhaHang(nameNh, idNhahang, locaiton)).commit();
            }
        });
        edtPostBinhLuan = view.findViewById(R.id.edtPostBinhLuan);
        imgPostBinhLuan = view.findViewById(R.id.imgPost);
        imgPostBinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String binhLuan = edtPostBinhLuan.getText().toString();
                if (binhLuan.length() > 5) {
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserComent");
                    String id = databaseReference.push().getKey();
                    String username = ((MainActivity) context).getUsername();

                    UserComent userComent = new UserComent(username, binhLuan, idNhahang, id, ((MainActivity) context).getTenNguoiDung());
                    databaseReference.child(id).setValue(userComent);
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edtPostBinhLuan.setText("");
                            Toast.makeText(getContext(), "Bình luận thành công", Toast.LENGTH_SHORT).show();
                        }
                    }, 1000);
                }else {
                    Toast.makeText(getContext(), "Vui lòng nhập bình luận", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return view;
    }
}
