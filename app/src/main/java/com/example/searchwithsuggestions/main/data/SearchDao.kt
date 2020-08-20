package com.mrk.compaq.application.local.ui.main.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mrk.compaq.application.local.ui.main.Model
@Dao
interface SearchDao {
    @Query("SELECT * from localquery ORDER BY id desc ")
     fun getAll(): LiveData<List<Model>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModel(

            model: Model
    )
}