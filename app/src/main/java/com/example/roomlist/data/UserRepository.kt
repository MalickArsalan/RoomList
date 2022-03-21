package com.example.roomlist.data

import androidx.lifecycle.LiveData

class UserRepository (private val userDao : UserDao) {

    val readAllData : LiveData<List<User>> = userDao.fetchAllUsers()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }

}