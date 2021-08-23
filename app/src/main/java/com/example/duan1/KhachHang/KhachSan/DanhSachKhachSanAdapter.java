package com.example.duan1.KhachHang.KhachSan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.KhachSan;
import com.example.duan1.MainActivity;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachKhachSanAdapter extends RecyclerView.Adapter<DanhSachKhachSanAdapter.ViewHolder> {
    ArrayList<KhachSan> arrayList;
    FragmentManager fragmentManager;
    Context context;

    public DanhSachKhachSanAdapter(FragmentManager fragmentManager, Context context) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsachks, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameKs.setText(arrayList.get(position).getKsName());
        holder.khuVuc.setText(arrayList.get(position).getKsKhuVuc());
        holder.chonKs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).changeFragment4(R.layout.danhsachphong_fragment,arrayList.get(position).getKsId(),context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView nameKs,khuVuc;
Button chonKs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameKs = itemView.findViewById(R.id.txtNameKsFragment);
            khuVuc = itemView.findViewById(R.id.txtVitri);
            chonKs = itemView.findViewById(R.id.btnChonKhachSan);
        }
    }
    public void resetAdapter(){
        arrayList.clear();
        notifyDataSetChanged();
    }
    public void updateAdapter(KhachSan khachSan){
        arrayList.add(khachSan);
        notifyDataSetChanged();
    }
}
