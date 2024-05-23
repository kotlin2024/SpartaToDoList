package org.example.spartatodolist.domain.comment.controller

import org.example.spartatodolist.domain.card.dto.CreateCardRequest
import org.example.spartatodolist.domain.comment.dto.CommentResponse
import org.example.spartatodolist.domain.comment.dto.CreateCommentRequest
import org.example.spartatodolist.domain.comment.model.Comment
import org.example.spartatodolist.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(
    private val commentService: CommentService
){

    @GetMapping("/cards/{cardId}")
    fun getComment(@PathVariable cardId:Long):ResponseEntity<List<CommentResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentList(cardId))
    }

    @PostMapping("/cards/{cardId}")
    fun createComment(@PathVariable cardId:Long,@RequestBody createCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(cardId, createCommentRequest))
    }

}