package com.example.duan1.aDapter;

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

public class GridViewBottomMainAdapter extends RecyclerView.Adapter<GridViewBottomMainAdapter.ViewHolder> {
    List<String> titles;
    List<String> location;
    List<Integer> img;

    LayoutInflater inflater;
    public GridViewBottomMainAdapter(Context context,List<String> titles, List<String> location, List<Integer> img) {
        this.titles = titles;
        this.location = location;
        this.img = img;
        this.inflater = LayoutInflater.from(context);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titles.setText(titles.get(position));
        holder.locaiton.setText(location.get(position));
        holder.imgPr.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titles,locaiton;
        ImageView imgPr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.txtPr);
            locaiton = itemView.findViewById(R.id.txtLoCaiTon);
            imgPr = itemView.findViewById(R.id.imgPr1);
        }
    }
}
