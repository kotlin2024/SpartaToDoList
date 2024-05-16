package org.example.spartatodolist.domain.user.model

import jakarta.persistence.*
import org.example.spartatodolist.domain.card.dto.CardResponse
import org.example.spartatodolist.domain.card.model.Card
import org.example.spartatodolist.domain.user.dto.UserResponse
import org.springframework.data.jpa.domain.AbstractPersistable_.id

@Entity
@Table(name="user")
class User(
    @Column(name="loginId")
    val loginId:String,

    @Column(name="loginPassword")
    val loginPassword:String,


    @Embedded
    var profile:Profile,

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    val role:UserRole
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null
}
fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        loginId = loginId,
        loginPassword = loginPassword,
        loginNickname= profile.loginNickname,
        role = role.name

    )
}
