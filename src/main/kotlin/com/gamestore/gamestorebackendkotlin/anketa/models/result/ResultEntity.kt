package com.gamestore.gamestorebackendkotlin.anketa.models.result

import com.gamestore.gamestorebackendkotlin.anketa.dto.result.ResultOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.anketa.models.result.table.ResultTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ResultEntity(id: EntityID<Long>) : ExtendedLongEntity(id, QuestionsTable) {

    companion object : LongEntityClass<ResultEntity>(ResultTable)

    var title by ResultTable.title
    var description by ResultTable.description

    fun toDTO(): ResultOutput {
        return ResultOutput(this)
    }
}