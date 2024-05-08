package com.gamestore.gamestorebackendkotlin.anketa.models.questions

import com.gamestore.gamestorebackendkotlin.anketa.dto.question.QuestionOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.anketa.models.answer.AnswerEntity
import com.gamestore.gamestorebackendkotlin.anketa.models.answer.table.AnswerTable
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class QuestionsEntity(id: EntityID<Long>) : ExtendedLongEntity(id, QuestionsTable) {

    companion object : LongEntityClass<QuestionsEntity>(QuestionsTable)

    var question by QuestionsTable.question
    var anketa by QuestionsTable.anketa
    fun toDTO(): QuestionOutput {
        val answers = AnswerEntity.find(AnswerTable.question.eq(this.id.value)).map { answerEntity -> answerEntity.toDTO() }
        return QuestionOutput(this, answers)
    }
}