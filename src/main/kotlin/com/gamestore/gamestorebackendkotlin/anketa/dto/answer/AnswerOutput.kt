package com.gamestore.gamestorebackendkotlin.anketa.dto.answer

import com.gamestore.gamestorebackendkotlin.anketa.models.answer.AnswerEntity

class AnswerOutput(val id: Long, val answer: String) {

    constructor(a: AnswerEntity): this(
        a.id.value,
        a.answer,
    )
}