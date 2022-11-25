package com.bam.viewmodelexample.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true) var id: Int = 0, var name: String, var age: Int)