package org.example.spartatodolist.domain.card.dto

data class CardResponse(
    val id:Long,
    val title: String,
    val description: String?,
    val finished: Boolean
)