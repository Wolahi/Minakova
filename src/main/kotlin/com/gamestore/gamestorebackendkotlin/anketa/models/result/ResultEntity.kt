package com.gamestore.gamestorebackendkotlin.anketa.models.result

import com.gamestore.gamestorebackendkotlin.anketa.dto.result.ResultOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ResultEntity(id: EntityID<Long>) : ExtendedLongEntity(id, ResultTable) {

    companion object : LongEntityClass<ResultEntity>(ResultTable)

    var title by ResultTable.title
    var description by ResultTable.description
    var answersWeight by ResultTable.answersWeight
    var anketa by AnketaTable.id

    fun toDTO(): ResultOutput {
        return ResultOutput(this)
    }
}