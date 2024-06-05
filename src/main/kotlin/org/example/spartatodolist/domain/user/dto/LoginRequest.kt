package org.example.spartatodolist.domain.user.dto

data class LoginRequest(
    val loginId:String,
    val loginPassword:String,
    val role:String,
)
