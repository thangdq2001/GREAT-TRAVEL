package com.example.duan1.KhachHang.NhaHang.Coment;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.UserComent;
import com.example.duan1.Admin.Model.UserInfo;
import com.example.duan1.MainActivity;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachBinhLuanAdapter extends RecyclerView.Adapter<DanhSachBinhLuanAdapter.ViewHolder> {
    ArrayList<UserInfo> userInfos;
    ArrayList<UserComent> userComents;
    Context context;
    FragmentManager fragmentManager;
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public DanhSachBinhLuanAdapter(Context context, FragmentManager fragmentManager) {
        userInfos = new ArrayList<>();
        userComents = new ArrayList<>();
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.custom_item_binhluan, null);
      return  new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.timeNow.setText(String.valueOf(((MainActivity)context).TimeNow()));
        holder.name.setText(userComents.get(position).getNameUser());
        holder.coment.setText(userComents.get(position).getComent());

        holder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a) {
                    holder.star.setImageResource(R.drawable.sao_notfun);
                    a= false;
                }else {
                    holder.star.setImageResource(R.drawable.sao_danhgia);

                    a = true;
                }
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b){
                    holder.like.setImageResource(R.drawable.like_yeu);
                    b = false;
                }else {
                    holder.like.setImageResource(R.drawable.likemanh);
                    b = true;
                }
            }
        });
        holder.fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c){
                    holder.fun.setImageResource(R.drawable.fun);

                    c = false;
                }
                else {
                    holder.fun.setImageResource(R.drawable.fun1);
                    c = true;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return userComents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeNow,name,coment;
        ImageView star,fun,like;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeNow = itemView.findViewById(R.id.txtThoiGianPost);
            name = itemView.findViewById(R.id.txtNameNguoiPost);
            coment = itemView.findViewById(R.id.txtNoiDungPost);
            star = itemView.findViewById(R.id.saofun);
            fun = itemView.findViewById(R.id.fun);
            like = itemView.findViewById(R.id.like);
        }
    }
    public void updateAdapter(UserComent userComent){
        userComents.add(userComent);
        notifyDataSetChanged();

    }
    public void resetAdapter(){
        userComents.clear();
        notifyDataSetChanged();
    }
    public void  reserAdapterInfo(){
        userInfos.clear();
        notifyDataSetChanged();
    }
    public void updateAdapterInfo(UserInfo userInfo){
        userInfos.add(userInfo);
        notifyDataSetChanged();
    }
}
