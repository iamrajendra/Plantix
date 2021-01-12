package com.plantix.features.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.plantix.data.database.dbpojo.Datum;
import com.plantix.databinding.ListAdapterBinding;

public class ListAdapterHolder extends RecyclerView.ViewHolder {
    private ListAdapterBinding binding;
    private int position = -1;

    private ListAdapterHolder(ListAdapterBinding binding, ListAdapterCallback callback) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(view -> {
            if (callback != null)
                callback.onListItemClick(binding.getMediaFile(), position);
        });
    }

    static ListAdapterHolder create(LayoutInflater inflater, ViewGroup parent, ListAdapterCallback callback) {
        ListAdapterBinding binding = ListAdapterBinding.inflate(inflater, parent, false);
        return new ListAdapterHolder(binding, callback);
    }

    public ListAdapterBinding getViewDataBinding() {
        return binding;
    }

    void onBind(Datum datum, int position) {
        this.position = position;
        binding.setMediaFile(datum);
        binding.executePendingBindings();
    }
}
