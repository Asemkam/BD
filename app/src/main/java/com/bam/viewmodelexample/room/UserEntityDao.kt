package com.bam.viewmodelexample.room


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserEntityDao {

    @Query("select * from UserEntity")
    fun getAll(): LiveData<List<UserEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: UserEntity)
}