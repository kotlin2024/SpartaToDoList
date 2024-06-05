package org.example.spartatodolist.domain.comment.model

import jakarta.persistence.*
import org.example.spartatodolist.domain.card.model.Card
import org.example.spartatodolist.domain.comment.dto.CommentResponse
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction


@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "Name")
    var commenterName:String,

    @Column(name = "Password")
    var commenterPassword: String,

    @Column(name = "comment")
    var commentInform:String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="card_id",nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE) //
    val card: Card

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null
}
fun Comment.toResponse():CommentResponse{

    return CommentResponse(
        commenterName=this.commenterName,
        commentInform = this.commentInform,
        id= id!!,
        card= this.card

    )
}

