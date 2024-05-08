package com.gamestore.gamestorebackendkotlin.anketa.repository.anketa

import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaOutput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaPreviewOutput
import com.gamestore.gamestorebackendkotlin.anketa.dto.question.QuestionOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.AnketaEntity
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.anketa.models.answer.AnswerEntity
import com.gamestore.gamestorebackendkotlin.anketa.models.answer.table.AnswerTable
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.QuestionsEntity
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.ResultEntity
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

@Repository
@Transactional
class AnketaRepository {

    fun getAnketas(): List<AnketaPreviewOutput> {
        val anketas = AnketaEntity.all();
        val dtoAnketas = anketas.map { anketaEntity: AnketaEntity -> anketaEntity.toDto() }
        return dtoAnketas
    }

    fun getAnketa(id: Long): AnketaOutput? {

        val anketa = AnketaEntity.find(AnketaTable.id.eq(id)).firstOrNull()

        val questions = QuestionsEntity.find(QuestionsTable.anketa.eq(id));

        val answers = questions.map { questionsEntity -> AnswerEntity.find(AnswerTable.question.eq(questionsEntity.id)).map {
            answerEntity -> answerEntity.toDTO()
        } }

        if(anketa != null && questions.count().toInt() != 0 && answers.isNotEmpty()) {
            val questionsDto = questions.mapIndexed { index, questionsEntity -> QuestionOutput(questionsEntity, answers[index])}
            return AnketaOutput(anketa, questionsDto)
        }

        return null
    }

    fun createAnketa(body: AnketaInput): String {
        try {

            val anketaId = AnketaTable.insertAndGetId {
                it[title] = body.title
                it[descr] = body.descr
            }

            val resultIds = mutableListOf<EntityID<Long>>()

            body.results.forEach { result ->
                resultIds.add(ResultTable.insertAndGetId {
                    it[title] = result.title
                    it[description] = result.description
                })
            }


            body.questions.forEach {
                questionsInput ->
                val questionId = QuestionsTable.insertAndGetId {
                    it[question] = questionsInput.question
                    it[anketa] = anketaId
                }

                questionsInput.answers.map { answerInput ->
                    transaction {
                        AnswerEntity.new {
                            answer = answerInput.answer;
                            result = resultIds[answerInput.indexResult];
                            question = questionId
                        }
                    }
                }
            }
            return "Успешно созданно!"
        } catch (e: Error) {
            return "Ошибка"
        }
    }
}