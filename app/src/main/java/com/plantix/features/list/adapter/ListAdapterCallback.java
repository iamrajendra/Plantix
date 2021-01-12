package com.plantix.features.list.adapter;

import com.plantix.data.database.dbpojo.Datum;

public interface ListAdapterCallback {
    void onListItemClick(Datum datum, int position);
}
