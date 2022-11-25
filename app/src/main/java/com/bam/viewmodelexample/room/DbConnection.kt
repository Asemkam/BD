package com.bam.viewmodelexample.room


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): UserEntityDao
}