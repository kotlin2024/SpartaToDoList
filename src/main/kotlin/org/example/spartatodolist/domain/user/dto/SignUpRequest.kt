package org.example.spartatodolist.domain.user.dto

data class SignUpRequest(
    val loginId:String,
    val loginPassword:String,
    val loginNickname:String,
    val role:String
)
