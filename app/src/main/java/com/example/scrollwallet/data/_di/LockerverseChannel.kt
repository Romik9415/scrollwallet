package com.example.scrollwallet.data._di

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//[{"chat":{"roomId":"38a85cbc-c385-4592-9264-15812a7833e2","createdById":"6f96ae93-eb83-426b-8fbc-d6034afc4606","updatedAt":"2023-08-08T19:33:23.390Z","createdAt":"2023-08-08T19:33:23.390Z","members":["3232e3fe-217b-4142-9589-2ad1f0d174bf","6f96ae93-eb83-426b-8fbc-d6034afc4606"],"chatType":"dm"},"lastMessage":{"id":"8efcd6c5-b541-4b0f-9b13-df4d753b9d92","channelId":"38a85cbc-c385-4592-9264-15812a7833e2","createdAt":1692719262196,"updatedAt":1692719262196,"content":"","authorId":"6f96ae93-eb83-426b-8fbc-d6034afc4606"},"unreadMessageCount":6,"lastReadMessageId":null,"membersData":[]},{"chat":{"roomId":"8b2d2496-2b6f-412d-bbe7-0d7a8d25a39d","createdById":"c6f46af6-c201-4bb9-adda-6c070390f55e","updatedAt":"2023-06-29T16:59:28.240Z","createdAt":"2023-06-29T16:59:28.240Z","members":["c6f46af6-c201-4bb9-adda-6c070390f55e","3232e3fe-217b-4142-9589-2ad1f0d174bf"],"chatType":"dm"},"lastMessage":{"id":"ff8e367e-408d-46c6-93a5-f7d1bcc95b56","channelId":"8b2d2496-2b6f-412d-bbe7-0d7a8d25a39d","createdAt":1689079510741,"updatedAt":1689079510741,"content":"12312312","authorId":"c6f46af6-c201-4bb9-adda-6c070390f55e"},"unreadMessageCount":18,"lastReadMessageId":null,"membersData":[]},{"chat":{"roomId":"9853daa3-4bd4-4958-8377-cf0138e872e9","createdById":"b4af6257-e3cf-418d-ad00-f79a42f1f20c","updatedAt":"2024-03-06T20:13:58.814Z","createdAt":"2024-03-06T20:13:58.814Z","members":["a742cfe6-cf56-479d-b04c-892906cdaac2","b4af6257-e3cf-418d-ad00-f79a42f1f20c","3232e3fe-217b-4142-9589-2ad1f0d174bf"],"chatType":"channel","name":"Friends","ownerId":"b4af6257-e3cf-418d-ad00-f79a42f1f20c"},"lastMessage":{"id":"1749124e-074b-48d6-8d39-81b4fc2486bc","channelId":"9853daa3-4bd4-4958-8377-cf0138e872e9","createdAt":1709907327922,"updatedAt":1709907327922,"content":"Кота в студію","authorId":"a742cfe6-cf56-479d-b04c-892906cdaac2"},"unreadMessageCount":3,"lastReadMessageId":null,"membersData":[{"id":"b8427b80-5fe8-40c7-88de-ca4c2dc11e48","name":"Yullia.K","image":"https://dev-media.lockerverse.com/users/b8427b80-5fe8-40c7-88de-ca4c2dc11e48/profile-1709134787218.jpeg","banner":{},"aboutme":null,"cognitoId":"a742cfe6-cf56-479d-b04c-892906cdaac2","verified":false}]},{"chat":{"roomId":"c6a3be1e-496b-46b2-881e-d0591fe84aad","createdById":"b4af6257-e3cf-418d-ad00-f79a42f1f20c","updatedAt":"2024-02-28T15:22:07.861Z","createdAt":"2024-02-28T15:22:07.861Z","members":["3232e3fe-217b-4142-9589-2ad1f0d174bf","b4af6257-e3cf-418d-ad00-f79a42f1f20c"],"chatType":"dm"},"lastMessage":{"id":"1d8d38d6-2ec9-43e3-a8b2-0703faccd030","channelId":"c6a3be1e-496b-46b2-881e-d0591fe84aad","createdAt":1709758396862,"updatedAt":1709758396862,"content":"Bzbsb","authorId":"b4af6257-e3cf-418d-ad00-f79a42f1f20c"},"unreadMessageCount":2,"lastReadMessageId":null,"membersData":[]}
@Entity
@JsonClass(generateAdapter = true)
data class LockerverseChannel(
    @Json(name = "chat") val chat: LockerverseChat,
    @Json(name = "lastMessage") val lastMessage: LMessage,
    @Json(name = "unreadMessageCount") val unreadMessageCount: Int,
    @Json(name = "lastReadMessageId") val lastReadMessageId: String?,
    @PrimaryKey val channelId: String = chat.roomId
)
