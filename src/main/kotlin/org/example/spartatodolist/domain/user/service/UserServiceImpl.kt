package org.example.spartatodolist.domain.user.service

import jakarta.transaction.Transactional
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.example.spartatodolist.domain.user.dto.SignUpRequest
import org.example.spartatodolist.domain.user.dto.UpdateUserProfileRequest
import org.example.spartatodolist.domain.user.dto.UserResponse
import org.example.spartatodolist.domain.user.model.Profile
import org.example.spartatodolist.domain.user.model.User
import org.example.spartatodolist.domain.user.model.UserRole
import org.example.spartatodolist.domain.user.model.toResponse
import org.example.spartatodolist.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) :UserService {

    @Transactional
    override fun signUp(request: SignUpRequest): UserResponse {
        if(userRepository.existsByLoginId(request.loginId)){
            throw IllegalArgumentException("ID is already exists")
        }

        return userRepository.save(
            User(
                loginId=request.loginId,
                loginPassword=request.loginPassword,
                profile= Profile(
                    loginNickname=request.loginNickname
                ),
                role=when(request.role){
                    UserRole.ADMIN.name -> UserRole.ADMIN
                    UserRole.NORMAL.name -> UserRole.NORMAL
                    else -> throw IllegalArgumentException("Invalid role")
                }
            )
        ).toResponse()
    }

    @Transactional
    override fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse {
        val user=userRepository.findByIdOrNull(userId)?: throw ModelNotFoundException("User",userId)
        user.profile=Profile(
            loginNickname = request.loginNickname
        )
        return userRepository.save(user).toResponse()
    }

}