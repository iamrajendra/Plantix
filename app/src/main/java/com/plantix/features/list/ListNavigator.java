package com.plantix.features.list;

import com.plantix.data.database.dbpojo.Datum;

import java.util.List;

interface ListNavigator {

    void response(List<Datum> jsonObject);
}
