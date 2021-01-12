package com.plantix.data.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class SuperDao<K> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(K entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract List<Long> insert(List<K> entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Long[] insert(K[] entity);

    @Update
    public abstract void update(K entity);

    @Update
    public abstract void update(List<K> entity);

    @Update
    public abstract void update(K[] entity);


    @Delete
    public abstract void delete(K entity);

    @Transaction
    public void upSert(K obj) {
        long id = insert(obj);
        if (id == -1) {
            update(obj);
        }
    }

    @Transaction
    public void upSert(List<K> objList) {
        List<Long> insertResult = insert(objList);
        List<K> updateList = new ArrayList<>();

        for (int i = 0; i < insertResult.size(); i++) {
            if (insertResult.get(i) == -1) {
                updateList.add(objList.get(i));
            }
        }

        if (!updateList.isEmpty()) {
            update(updateList);
        }
    }
}
