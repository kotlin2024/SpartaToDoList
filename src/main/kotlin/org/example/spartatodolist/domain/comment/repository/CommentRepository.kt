package org.example.spartatodolist.domain.comment.repository

import org.example.spartatodolist.domain.card.model.Card
import org.example.spartatodolist.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment,Long> {
    fun findAllByCard(card: Card):List<Comment>
}