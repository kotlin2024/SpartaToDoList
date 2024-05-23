package org.example.spartatodolist.domain.comment.model

import jakarta.persistence.*
import org.example.spartatodolist.domain.card.model.Card
import org.example.spartatodolist.domain.comment.dto.CommentResponse


@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "Name")
    val commenterName:String,

    @Column(name = "Password")
    val commenterPassword: String,

    @Column(name = "comment")
    val commentInform:String,

    @ManyToOne
    @JoinColumn(name="card_id")
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

