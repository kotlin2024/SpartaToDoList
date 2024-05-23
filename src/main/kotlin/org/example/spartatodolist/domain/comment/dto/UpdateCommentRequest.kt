package org.example.spartatodolist.domain.comment.dto

data class UpdateCommentRequest(
    val commenterName: String,
    val commenterPassword: String,
    val commentInform:String
)
