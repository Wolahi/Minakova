package com.gamestore.gamestorebackendkotlin.anketa.dto.question

import com.gamestore.gamestorebackendkotlin.anketa.dto.answer.AnswerInput

class QuestionsInput(val question: String, val answers: List<AnswerInput>)