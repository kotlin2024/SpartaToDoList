package org.example.spartatodolist.domain.card.controller

import org.example.spartatodolist.domain.card.dto.CardResponse
import org.example.spartatodolist.domain.card.dto.CreateCardResponse
import org.example.spartatodolist.domain.card.dto.UpdateCardResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/cards")
@RestController
class CardController {

    @GetMapping()
    fun getCardList(){
        TODO()
    }

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Long){
        TODO()
    }

    @PostMapping()
    fun createCard(@RequestBody createCardResponse: CreateCardResponse): ResponseEntity<CardResponse>{
        TODO()
    }

    @PutMapping("/{cardId}")
    fun updateCard(@PathVariable cardId: Long, @RequestBody updateCardResponse: UpdateCardResponse){
        TODO()
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Long){
        TODO()
    }
}