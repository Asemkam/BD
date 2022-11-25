package com.bam.viewmodelexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.bam.viewmodelexample.room.DbConnection
import com.bam.viewmodelexample.room.UserEntity
import kotlinx.coroutines.launch

class ListFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val userEntityDao =
        Room.databaseBuilder(application, DbConnection::class.java, "database")
            .build()
            .entityDao()

    val list = userEntityDao.getAll()


    init {
        val list = mutableListOf<UserEntity>()
        for (i in 1..100){
            list.add(UserEntity(name = "name$i", age = i))
        }

        viewModelScope.launch {
            list.forEach {
                userEntityDao.insert(it)
            }
        }
    }

}