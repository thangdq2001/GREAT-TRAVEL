package com.example.duan1.KhachHang.chuyenBayFragment.CustomSpinerOptionAmountKhach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1.R;

import java.util.ArrayList;

public class CustomSpinerOptionAmoutKhachAdapter extends ArrayAdapter<CustomSpinerOptionAmountKhach> {
    public CustomSpinerOptionAmoutKhachAdapter(Context context, ArrayList<CustomSpinerOptionAmountKhach> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }
    private View initView(int position,View convertView,ViewGroup parent){
        if (convertView == null){

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customspineroptionamountkhach, parent, false);
        }

        TextView optionAmount = (TextView) convertView.findViewById(R.id.txtTextOption);
        CustomSpinerOptionAmountKhach customSpinerOptionAmountKhach = getItem(position);
        if (convertView != null) {
            optionAmount.setText(customSpinerOptionAmountKhach.getTextOption());
        }
        return convertView;
    }
}
