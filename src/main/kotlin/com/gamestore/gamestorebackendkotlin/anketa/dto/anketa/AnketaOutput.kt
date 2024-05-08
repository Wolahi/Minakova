package com.gamestore.gamestorebackendkotlin.anketa.dto.anketa

import com.gamestore.gamestorebackendkotlin.anketa.dto.question.QuestionOutput
import com.gamestore.gamestorebackendkotlin.anketa.dto.question.QuestionsInput
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.AnketaEntity

class AnketaOutput(
    val id: Long,
    val title: String,
    val descr: String,
    val questions: List<QuestionOutput>,
)  {
    constructor(a: AnketaEntity, q: List<QuestionOutput>): this(
        a.id.value,
        a.title,
        a.descr,
        questions = q
    )
}