package org.example.spartatodolist.domain.card.repository

import org.example.spartatodolist.domain.card.model.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card,Long> {
}