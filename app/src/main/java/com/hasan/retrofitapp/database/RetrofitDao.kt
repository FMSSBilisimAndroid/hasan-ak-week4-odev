package com.hasan.retrofitapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hasan.retrofitapp.model.Model

@Dao
interface RetrofitDao {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries: Model) : List<Long>

    //Insert -> INSERT INTO
    // suspend -> coroutine, pause & resume
    // vararg -> multiple country objects
    // List<Long> -> primary keys


    @Query("SELECT * FROM  Model ")
    suspend fun getAllFields() : List<Model>

    @Query("SELECT * FROM Model WHERE id = :fieldId")
    suspend fun getField(fieldId: Int) : Model

    @Query("DELETE FROM Model")
    suspend fun deleteAllFields()

}