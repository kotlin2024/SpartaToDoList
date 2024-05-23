package org.example.spartatodolist.domain.card.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.example.spartatodolist.domain.card.dto.CardResponse

@Entity
@Table(name="card")
class Card (
    @Column(name="title")
    var title:String,

    @Column(name= "description" )
    var description: String? = null,

    @Column(name="finished")
    var finished: Boolean = false


){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null
}
fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = id!!,
        title = title,
        description = description,
        finished = finished
    )
}