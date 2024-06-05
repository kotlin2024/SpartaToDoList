package org.example.spartatodolist.domain.user.service

import org.example.spartatodolist.domain.user.dto.*

interface UserService {

    fun signUp(request:SignUpRequest):UserResponse

    fun updateUserProfile(userId:Long,request:UpdateUserProfileRequest): UserResponse

    fun login(request: LoginRequest):LoginResponse
}