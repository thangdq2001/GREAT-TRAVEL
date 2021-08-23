package com.example.duan1.KhachHang.likeFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

import java.util.List;

public class liekMainAdapter extends RecyclerView.Adapter<liekMainAdapter.ViewHolder> {
    List<String> nameDN,locationDN,danhGiaDN,quangCaoDN;
    List<Integer> img;
    LayoutInflater inflater;

    public liekMainAdapter(Context context, List<String> nameDN, List<String> locationDN, List<String> danhGiaDN, List<String> quangCaoDN, List<Integer> img) {
        this.nameDN = nameDN;
        this.locationDN = locationDN;
        this.danhGiaDN = danhGiaDN;
        this.quangCaoDN = quangCaoDN;
        this.img = img;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup root;
        View view = inflater.inflate(R.layout.custom_rec_like, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameDN.setText(nameDN.get(position));
        holder.locaitonDN.setText(locationDN.get(position));
        holder.danhGiaDN.setText(danhGiaDN.get(position));
        holder.quangCaoDN.setText(quangCaoDN.get(position));
        holder.imgPr.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return nameDN.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameDN,locaitonDN,danhGiaDN,quangCaoDN;
        ImageView imgPr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameDN = itemView.findViewById(R.id.txtNameDNLike);
            locaitonDN = itemView.findViewById(R.id.txtLocaitonDN);
            danhGiaDN = itemView.findViewById(R.id.txtDanhGiaDN);
            quangCaoDN = itemView.findViewById(R.id.txtPrDN);
        imgPr = itemView.findViewById(R.id.imgAddDN);
        }
    }
}
