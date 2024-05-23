package org.example.spartatodolist.domain.card.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카드 요청!!!!!")
data class UpdateCardRequest(
    @Schema(description = "카드 제목",example= "2024-05-23 할일 목록")
    val title:String,

    @Schema(description = "할일 목록들",example= "TIL 작성하기, 책읽기 등등")
    val description:String?,

    val finished:Boolean
)
