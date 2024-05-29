package com.gamestore.gamestorebackendkotlin.anketa.models.result.table

import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.anketa.models.questions.table.QuestionsTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption

object ResultTable: ExtendedLongIdTable(name = "result") {
    val title: Column<String> = varchar("title", length = 100)
    val description: Column<String> = varchar("description", length = 500)
    val answersWeight: Column<Int> = integer("answers_weight")
    val anketaId = reference("anketa_id", AnketaTable, onDelete = ReferenceOption.CASCADE)

    init {
        uniqueIndex(
            customIndexName = "RESULT_UNIQUE",
            columns = arrayOf(ResultTable.title),
        )
    }
}