package org.example.spartatodolist.domain.comment.dto

data class CreateCommentRequest(
    val commenterName: String,
    val commenterPassword: String,
    val commentInform:String
)
