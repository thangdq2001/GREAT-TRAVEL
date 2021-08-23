package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.MonAn;
import com.example.duan1.Admin.Model.VoHang;
import com.example.duan1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DanhSachMonAnAdapter extends RecyclerView.Adapter<DanhSachMonAnAdapter.ViewHolder> {
    String idNh;

    Context context;
    FragmentManager fragmentManager;
    String getIdNh;

    public DanhSachMonAnAdapter(Context context, FragmentManager fragmentManager,String idNh) {
        arrayList = new ArrayList<>();
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.getIdNh = idNh;

    }
    ArrayList<MonAn> arrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cutsom_showdanhsachmonan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
    holder.tenMonAn.setText(arrayList.get(position).getNhMaName());
    holder.GiaMonAn.setText(String.valueOf(arrayList.get(position).getNhMaGia()));
    holder.addMonAn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
            double amount = Double.parseDouble(holder.soLuong.getText().toString());
            Double thanhtien = arrayList.get(position).getNhMaGia() * amount;
            String note = String.valueOf(holder.ghiChu.getText().toString());
            String id = databaseReference.push().getKey();
            VoHang cart = new VoHang(getIdNh,arrayList.get(position).getNhMaName(),arrayList.get(position).getNhMaGia(),note,thanhtien,id,amount);
            databaseReference.child(id).setValue(cart);
            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText soLuong,ghiChu;
        ImageView addMonAn;
        TextView tenMonAn,GiaMonAn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            GiaMonAn = itemView.findViewById(R.id.txtGiaMon);
            tenMonAn = itemView.findViewById(R.id.txtTenMon);
            soLuong = itemView.findViewById(R.id.edtSoLuong);
            addMonAn = itemView.findViewById(R.id.iconaddMonAn);
            ghiChu = itemView.findViewById(R.id.txtGhiChu);
        }
    }
    public  void updateAdapter(MonAn item){
       arrayList.add(item);
       notifyDataSetChanged();

    }
    public  void resetAdapter(){
        arrayList.clear();
        notifyDataSetChanged();
    }

}
