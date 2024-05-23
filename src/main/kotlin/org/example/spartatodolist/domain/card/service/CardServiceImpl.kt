package org.example.spartatodolist.domain.card.service

import jakarta.transaction.Transactional
import org.example.spartatodolist.domain.card.dto.CardResponse
import org.example.spartatodolist.domain.card.dto.CreateCardRequest
import org.example.spartatodolist.domain.card.dto.UpdateCardRequest
import org.example.spartatodolist.domain.card.model.Card
import org.example.spartatodolist.domain.card.model.toResponse
import org.example.spartatodolist.domain.card.repository.CardRepository
import org.example.spartatodolist.domain.exception.ModelNotFoundException
import org.example.spartatodolist.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
    private val userRepository: UserRepository
):CardService {
    override fun getAllCardList(): List<CardResponse> {
        val cardRepositoryWithFinished= cardRepository.findAll().sortedWith(compareBy<Card>{it.finished}.thenBy{it.id})
        return cardRepositoryWithFinished.map{ it.toResponse() }
    }

    override fun getCardById(cardId: Long): CardResponse {
        val card=cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card",cardId)
        return card.toResponse()
    }

    @Transactional
    override fun createCard(request: CreateCardRequest): CardResponse {
        return cardRepository.save(
            Card(
                title = request.title,
                description= request.description,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse {
        val card=cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card",cardId)
        val(title,description,finished) = request

        card.title=title
        card.description=description
        card.finished=finished

        return cardRepository.save(card).toResponse()
    }

    @Transactional
    override fun deleteCard(cardId: Long) {
        val card=cardRepository.findByIdOrNull(cardId)?: throw ModelNotFoundException("Card",cardId)
        cardRepository.delete(card)
    }
}