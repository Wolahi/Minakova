package com.gamestore.gamestorebackendkotlin.anketa.models.answer

import com.gamestore.gamestorebackendkotlin.anketa.dto.answer.AnswerOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.answer.table.AnswerTable
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class AnswerEntity(id: EntityID<Long>) : ExtendedLongEntity(id, AnswerTable) {
    companion object : LongEntityClass<AnswerEntity>(AnswerTable)

    var question by AnswerTable.question
    var answer by AnswerTable.answerText
    var weight by AnswerTable.weight
    fun toDTO(): AnswerOutput {
        return AnswerOutput(this)
    }
}