package com.example.scrollwallet.data._di

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelsDao : BaseDao<LockerverseChannel> {
    @Query("SELECT * FROM LockerverseChannel")
    fun getAllChannels(): Flow<List<LockerverseChannel>>

    @Query("SELECT * FROM LockerverseChannel WHERE channelId = :channelIdStr")
    fun getChannelByIdFlow(channelIdStr: String): Flow<LockerverseChannel>

//    @Query("SELECT * FROM LockerverseChannel order by lastMessage desc")
//    fun getAllChannelsSortedByDate(): Flow<List<LockerverseChannel>>

}