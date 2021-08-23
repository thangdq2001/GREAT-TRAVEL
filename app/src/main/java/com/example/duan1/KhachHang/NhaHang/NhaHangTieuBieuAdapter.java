package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.NhaHangTieuBieu;
import com.example.duan1.R;

import java.util.ArrayList;

public class NhaHangTieuBieuAdapter extends RecyclerView.Adapter<NhaHangTieuBieuAdapter.ViewHolder>{
    ArrayList<NhaHangTieuBieu> arrayList;
    FragmentManager fragmentManager;
    Context context;

    public NhaHangTieuBieuAdapter(FragmentManager fragmentManager, Context context) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_nhahangtieubieu, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.nameNh.setText(arrayList.get(position).getNhTbName());
//            holder.logoNhaHang.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    GiaoDienChinhNhaHang nhaHang = new GiaoDienChinhNhaHang(arrayList.get(position).getNhTbName(),arrayList.get(position).getNhTbId(),((MainActivity)context).getLocation(arrayList.get(position).getNhTbLat(),arrayList.get(position).getNhTbLog()));
//                    fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,new GiaoDienChinhNhaHang(arrayList.get(position).getNhTbName(),arrayList.get(position).getNhTbId(),((MainActivity)context).getLocation(arrayList.get(position).getNhTbLat(),arrayList.get(position).getNhTbLog())));
//                }
//            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameNh;
        ImageView logoNhaHang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNh = itemView.findViewById(R.id.txtNameNhaHangTieuBieu);
            logoNhaHang = itemView.findViewById(R.id.imgLoGoNhaHangTieuBieu);
        }
    }
    public void updateAdapter(NhaHangTieuBieu nh){
        arrayList.add(nh);
        notifyDataSetChanged();
    }
    public void resetAdpter(){
        arrayList.clear();
        notifyDataSetChanged();
    }
}
