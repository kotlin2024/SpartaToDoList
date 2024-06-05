package org.example.spartatodolist.domain.user.service

import jakarta.transaction.Transactional
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.example.spartatodolist.domain.user.dto.*
import org.example.spartatodolist.domain.user.exception.InvalidCredentialException
import org.example.spartatodolist.domain.user.model.Profile
import org.example.spartatodolist.domain.user.model.User
import org.example.spartatodolist.domain.user.model.UserRole
import org.example.spartatodolist.domain.user.model.toResponse
import org.example.spartatodolist.domain.user.repository.UserRepository
import org.example.spartatodolist.infra.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) :UserService {

    override fun login(request: LoginRequest): LoginResponse {
        val user= userRepository.findByLoginId(request.loginId) ?: throw ModelNotFoundException("User",null)

        if(user.role.name != request.role || !passwordEncoder.matches(request.loginPassword,user.loginPassword)){
            throw InvalidCredentialException()
        }

        return LoginResponse(
            accessToken =jwtPlugin.generateAccessToken(
                subject=user.id.toString(),
                email = user.loginId,
                role= user.role.name
            )
        )
    }


    @Transactional
    override fun signUp(request: SignUpRequest): UserResponse {
        if(userRepository.existsByLoginId(request.loginId)){
            throw IllegalArgumentException("ID is already exists")
        }

        return userRepository.save(
            User(
                loginId=request.loginId,
                loginPassword=passwordEncoder.encode(request.loginPassword),
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