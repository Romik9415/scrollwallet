package com.example.scrollwallet.data._di

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//"roomId":"38a85cbc-c385-4592-9264-15812a7833e2",
//            "createdById":"6f96ae93-eb83-426b-8fbc-d6034afc4606",
//            "updatedAt":"2023-08-08T19:33:23.390Z",
//            "createdAt":"2023-08-08T19:33:23.390Z",
//            "members":[
//               "3232e3fe-217b-4142-9589-2ad1f0d174bf",
//               "6f96ae93-eb83-426b-8fbc-d6034afc4606"
//            ],
//            "chatType":"dm"
@JsonClass(generateAdapter = true)
data class LockerverseChat(
    @Json(name = "roomId") val roomId: String,
    @Json(name = "createdById") val createdById: String,
    @Json(name = "updatedAt") val updatedAt: String,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "members") val members: List<String>,
    @Json(name = "chatType") val chatType: String,
    @Json(name = "name") val name: String?,
    @Json(name = "ownerId") val ownerId: String?
) {

    fun getChatType(): ChatType {
        return when (chatType) {
            "dm" -> ChatType.DM
            "channel" -> ChatType.CHANNEL
            else -> ChatType.DM
        }
    }

    //todo need to add chat type
    enum

    class ChatType {
        DM,
        CHANNEL
    }
}

