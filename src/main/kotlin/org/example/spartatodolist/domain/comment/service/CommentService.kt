package org.example.spartatodolist.domain.comment.service

import org.example.spartatodolist.domain.card.repository.CardRepository
import org.example.spartatodolist.domain.comment.dto.CommentResponse
import org.example.spartatodolist.domain.comment.dto.CreateCommentRequest
import org.example.spartatodolist.domain.comment.model.Comment
import org.example.spartatodolist.domain.comment.model.toResponse
import org.example.spartatodolist.domain.comment.repository.CommentRepository
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val cardRepository: CardRepository
) {

    fun getCommentList(cardId:Long):List<CommentResponse>{
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)
        return commentRepository.findAllByCard(card).map{it.toResponse()}
    }

    fun createComment(cardId:Long, request:CreateCommentRequest):CommentResponse{
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)

        return commentRepository.save(Comment(
            commenterName= request.commenterName,
            commenterPassword = request.commenterPassword,
            commentInform = request.commentInform,
            card = card // ?수상한 부분
        )).toResponse()
    }

    fun updateComment(){

    }

    fun deleteComment(){

    }

}