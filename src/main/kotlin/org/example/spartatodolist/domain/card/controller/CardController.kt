package org.example.spartatodolist.domain.card.controller

import org.example.spartatodolist.domain.card.dto.CardResponse
import org.example.spartatodolist.domain.card.dto.CreateCardRequest
import org.example.spartatodolist.domain.card.dto.UpdateCardRequest
import org.example.spartatodolist.domain.card.service.CardService
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/cards")
@RestController
class CardController(
    private val cardService: CardService
) {

    @GetMapping()
    fun getCardList(): ResponseEntity<List<CardResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getAllCardList())
    }

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Long): ResponseEntity<CardResponse>{
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCardById(cardId))
    }

    @PostMapping()
    fun createCard(@RequestBody createCardRequest: CreateCardRequest): ResponseEntity<CardResponse>{
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.createCard(createCardRequest))
    }

    @PutMapping("/{cardId}")
    fun updateCard(@PathVariable cardId: Long, @RequestBody updateCardRequest: UpdateCardRequest):ResponseEntity<CardResponse>{
        return ResponseEntity.status(HttpStatus.OK).body(cardService.updateCard(cardId, updateCardRequest))
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Long): ResponseEntity<Unit>{
        cardService.deleteCard(cardId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}