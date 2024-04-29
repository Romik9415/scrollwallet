package com.example.scrollwallet.data._di

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder

class Converter {

    /**
     * LockerverseChat
     */
    @TypeConverter
    fun toLockerverseChat(data: String): LockerverseChat {
        return GsonBuilder().create().fromJson(data, LockerverseChat::class.java)
    }

    @TypeConverter
    fun toLockerverseChatString(lockerverseChat: LockerverseChat): String {
        return GsonBuilder().create().toJson(lockerverseChat)
    }

    /**
     * LMessage
     */
    @TypeConverter
    fun toLMessage(data: String): LMessage {
        return GsonBuilder().create().fromJson(data, LMessage::class.java)
    }

    @TypeConverter
    fun toLMessageString(lMessage: LMessage): String {
        return GsonBuilder().create().toJson(lMessage)
    }
}