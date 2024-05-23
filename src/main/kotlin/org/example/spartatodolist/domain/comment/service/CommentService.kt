package org.example.spartatodolist.domain.comment.service

import jakarta.transaction.Transactional
import org.example.spartatodolist.domain.card.repository.CardRepository
import org.example.spartatodolist.domain.comment.dto.CommentResponse
import org.example.spartatodolist.domain.comment.dto.CreateCommentRequest
import org.example.spartatodolist.domain.comment.dto.DeleteCommentRequest
import org.example.spartatodolist.domain.comment.dto.UpdateCommentRequest
import org.example.spartatodolist.domain.comment.model.Comment
import org.example.spartatodolist.domain.comment.model.toResponse
import org.example.spartatodolist.domain.comment.repository.CommentRepository
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
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

    @Transactional
    fun createComment(cardId:Long, request:CreateCommentRequest):CommentResponse{
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)

        return commentRepository.save(Comment(
            commenterName= request.commenterName,
            commenterPassword = request.commenterPassword,
            commentInform = request.commentInform,
            card = card // ?수상한 부분
        )).toResponse()
    }


    @Transactional
    fun updateComment(cardId:Long,commentId:Long, request: UpdateCommentRequest): CommentResponse {
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)
        val comment=commentRepository.findByIdOrNull(commentId)?: throw ModelNotFoundException("Comment",commentId)

        if(comment.commenterPassword != request.commenterPassword){
            throw IllegalArgumentException("비밀번호가 틀려요")
        }



        val(commenterName, commenterPassword, commentInform) = request

        comment.commenterName =commenterName
        comment.commenterPassword =commenterPassword
        comment.commentInform =commentInform

        return commentRepository.save(comment).toResponse()


    }

    @Transactional
    fun deleteComment(cardId:Long,commentId:Long,request: DeleteCommentRequest){
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)
        val comment=commentRepository.findByIdOrNull(commentId)?: throw ModelNotFoundException("Comment",commentId)

        if(comment.commenterPassword != request.commenterPassword){
            throw IllegalArgumentException("비밀번호가 틀려요")
        }


        commentRepository.delete(comment)
    }

}