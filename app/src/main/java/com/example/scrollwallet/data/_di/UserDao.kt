package com.example.scrollwallet.data._di

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUserLiveData(): LiveData<User?>

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUserLiveSync(): User?

    @Query("DELETE FROM user")
    suspend fun nukeTable()

    @Delete
    fun delete(user: User)
}