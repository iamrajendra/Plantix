package com.plantix.features.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.plantix.data.base.BaseAdapter;
import com.plantix.data.database.dbpojo.Datum;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends BaseAdapter<ListAdapterHolder, Datum> {
    private ListAdapterCallback callback;
    private List<Datum> list = new ArrayList<>();

    @Override
    public void setData(List<Datum> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListAdapterHolder.create(LayoutInflater.from(parent.getContext()), parent, callback);
    }

    @Override
    public long getItemId(int position) {
        Datum teams = list.get(position);
        return teams.getId();
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterHolder holder, int position) {
        holder.onBind(list.get(position), position);
        Glide.with(holder.getViewDataBinding().thumbImage.getContext())
                .load(list.get(position).getAvatar())
                .into(holder.getViewDataBinding().thumbImage);
        StringBuilder sb = new StringBuilder(list.get(position).getModifiedLowerCaseUserName());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        holder.getViewDataBinding().userName.setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setCallback(ListAdapterCallback callback) {
        this.callback = callback;
    }


}
