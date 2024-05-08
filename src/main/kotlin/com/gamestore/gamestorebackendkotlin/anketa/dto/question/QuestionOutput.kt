package com.gamestore.gamestorebackendkotlin.anketa.dto.question

import com.gamestore.gamestorebackendkotlin.anketa.dto.answer.AnswerOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.QuestionsEntity

class QuestionOutput(val id: Long, val question: String , val answers: List<AnswerOutput>) {

    constructor(q: QuestionsEntity, a: List<AnswerOutput>) : this(
        q.id.value,
        q.question,
        answers = a
    )
}