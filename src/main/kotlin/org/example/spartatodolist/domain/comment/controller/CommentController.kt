package org.example.spartatodolist.domain.comment.controller

import org.example.spartatodolist.domain.card.dto.CreateCardRequest
import org.example.spartatodolist.domain.comment.dto.CommentResponse
import org.example.spartatodolist.domain.comment.dto.CreateCommentRequest
import org.example.spartatodolist.domain.comment.dto.DeleteCommentRequest
import org.example.spartatodolist.domain.comment.dto.UpdateCommentRequest
import org.example.spartatodolist.domain.comment.model.Comment
import org.example.spartatodolist.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CommentController(
    private val commentService: CommentService
){

    @GetMapping("/cards/{cardId}/comments")
    fun getComment(@PathVariable cardId:Long):ResponseEntity<List<CommentResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentList(cardId))
    }

    @PostMapping("/cards/{cardId}/comments")
    fun createComment(@PathVariable cardId:Long,@RequestBody createCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(cardId, createCommentRequest))
    }

    @PutMapping("/cards/{cardId}/comments/{commentId}")
    fun updateComment(@PathVariable cardId:Long,@PathVariable commentId:Long,@RequestBody updateCommentRequest: UpdateCommentRequest): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateComment(cardId,commentId,updateCommentRequest))

    }

    @DeleteMapping("/cards/{cardId}/comments/{commentId}")
    fun deleteComment(@PathVariable cardId:Long,@PathVariable commentId:Long,@RequestBody deleteCommentRequest: DeleteCommentRequest):ResponseEntity<Unit>{
        commentService.deleteComment(cardId,commentId,deleteCommentRequest)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}