package org.example.spartatodolist.domain.user.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Profile (
    @Column(name = "loginNickname")
    var loginNickname: String,
)