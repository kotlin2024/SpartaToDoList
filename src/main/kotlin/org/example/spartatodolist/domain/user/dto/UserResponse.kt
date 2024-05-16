package org.example.spartatodolist.domain.user.dto

data class UserResponse(
    val id:Long,
    val loginId:String,
    val loginPassword:String,
    val loginNickname:String,
    val role:String
)
