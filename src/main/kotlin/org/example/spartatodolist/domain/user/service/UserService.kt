package org.example.spartatodolist.domain.user.service

import org.example.spartatodolist.domain.user.dto.SignUpRequest
import org.example.spartatodolist.domain.user.dto.UpdateUserProfileRequest
import org.example.spartatodolist.domain.user.dto.UserResponse

interface UserService {

    fun signUp(request:SignUpRequest):UserResponse

    fun updateUserProfile(userId:Long,request:UpdateUserProfileRequest): UserResponse
}