package com.example.scrollwallet.ui.pages.home

import com.example.scrollwallet.data._di.AppDatabase
import com.example.scrollwallet.data._di.User
import javax.inject.Inject

class LocalWalletRepo @Inject constructor(
    val db: AppDatabase,
) {
    suspend fun rollsIncrease() {
        val user = db.userDao().getUserLiveSync()
        if (user == null) {
            db.userDao().insertData(User("1", 0.0))
            return
        }
        user.rolls += 0.0001
        db.userDao().insertData(user)
    }

    suspend fun rollsIncrease(totalItemsViewed: Int) {
        val user = db.userDao().getUserLiveSync()
        if (user == null) {
            db.userDao().insertData(User("1", 0.0))
            return
        }
        user.rolls += totalItemsViewed / 1000.0
        db.userDao().insertData(user)
    }

    val currentRollsLiveData = db.userDao().getUserLiveData()
}
