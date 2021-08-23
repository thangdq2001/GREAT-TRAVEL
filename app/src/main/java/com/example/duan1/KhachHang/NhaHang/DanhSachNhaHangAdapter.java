package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.NhaHang;
import com.example.duan1.MainActivity;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachNhaHangAdapter extends RecyclerView.Adapter<DanhSachNhaHangAdapter.ViewHolder> {
    ArrayList<NhaHang> arrayList;
    Context context;
    FragmentManager fragmentManager;
    public  boolean a = false;

    public DanhSachNhaHangAdapter(Context context, FragmentManager fragmentManager) {
        arrayList = new ArrayList<>();
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_nhahang_khachang, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a){
                    holder.fun.setImageResource(R.drawable.fun);
                    a =false;
                }else {
                    holder.fun.setImageResource(R.drawable.fun1);
                    a=true;
                }

            }
        });
        holder.nameNh.setText(arrayList.get(position).getNhName()+" "+"-");
        holder.nameNh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) context).changeFragmet2(R.layout.giaodien_chinh_nhahang,
                        arrayList.get(position).getNhName(), arrayList.get(position).getNhId(),
                        ((MainActivity) context).getLocation(arrayList.get(position).getNhLat(), arrayList.get(position).getNhLog()));
//                DanhSachMonAnAdapter ds = new DanhSachMonAnAdapter(context, fragmentManager, arrayList.get(position).getNhId());
            }
        });
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) context).changeFragmet2(R.layout.giaodien_chinh_nhahang,
                        arrayList.get(position).getNhName(), arrayList.get(position).getNhId(),
                        ((MainActivity) context).getLocation(arrayList.get(position).getNhLat(), arrayList.get(position).getNhLog()));
//                DanhSachMonAnAdapter ds = new DanhSachMonAnAdapter(context, fragmentManager, arrayList.get(position).getNhId());
            }
        });
        holder.nhomNh.setText(arrayList.get(position).getNhNhomNhaHang());
        holder.khoangCach.setText(String.valueOf(((MainActivity) context).getLocation(arrayList.get(position).getNhLat(), arrayList.get(position).getNhLog())) + "Km");
        Log.d("lat1", String.valueOf(arrayList.get(position).getNhLat()));
        Log.d("log1", String.valueOf(arrayList.get(position).getNhLog()));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fun, logo;
        TextView nameNh, nhomNh, khoangCach;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameNh = itemView.findViewById(R.id.txtNameNhaHangKhachHang);
            nhomNh = itemView.findViewById(R.id.txtNhomNhaHangKhachHang);
            khoangCach = itemView.findViewById(R.id.txtKhoangCach);
            fun = itemView.findViewById(R.id.iconFun);
            cardView = itemView.findViewById(R.id.cardViewMonAn);
            logo = itemView.findViewById(R.id.imgLogoNhaHang);
        }
    }

    public void resetAdapter() {
        arrayList.clear();
        notifyDataSetChanged();

    }

    public void updateAdapter(NhaHang nh) {
        arrayList.add(nh);
        notifyDataSetChanged();
    }
}
