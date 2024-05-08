package com.gamestore.gamestorebackendkotlin.anketa.models.answer.table

import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption

object AnswerTable: ExtendedLongIdTable(name = "answer")  {
    val answerText: Column<String> =  varchar(name = "answer_text", length = 500)
    val question = reference("questions_id", QuestionsTable, onDelete = ReferenceOption.CASCADE)
    val result = reference("result_id", ResultTable, onDelete = ReferenceOption.CASCADE)
    init {
        uniqueIndex(
            customIndexName = "ANSWER_UNIQUE",
            columns = arrayOf(AnswerTable.answerText),
        )
    }
}