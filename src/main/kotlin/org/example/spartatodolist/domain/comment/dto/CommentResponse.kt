package org.example.spartatodolist.domain.comment.dto

import org.example.spartatodolist.domain.card.model.Card

data class CommentResponse(
    val id:Long,
    val commenterName:String,
    val commentInform:String,
    val card:Card
)