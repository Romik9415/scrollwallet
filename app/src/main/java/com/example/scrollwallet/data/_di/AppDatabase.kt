package com.example.scrollwallet.data._di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converter::class)
@Database(
    entities = [User::class, LockerverseChannel::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun channelsDao(): ChannelsDao

    companion object {

        private const val dbName = "lockerverse_db"

        fun getInstance(applicationContext: Context): AppDatabase {
            return Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, dbName
            ).build()
        }
    }
}