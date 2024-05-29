package com.gamestore.gamestorebackendkotlin.anketa.models.answer.table

import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption

object AnswerTable: ExtendedLongIdTable(name = "answer")  {
    val answerText: Column<String> =  varchar(name = "answer_text", length = 500)
    val question = reference("questions_id", QuestionsTable, onDelete = ReferenceOption.CASCADE)
    val weight: Column<Int> = integer(name = "weight")
}