package com.gamestore.gamestorebackendkotlin.anketa.dto.anketa
import com.gamestore.gamestorebackendkotlin.anketa.dto.question.QuestionsInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.result.ResultInput

class AnketaInput(
    val title: String,
    val descr: String,
    val results: List<ResultInput>,
    val questions: List<QuestionsInput>
)