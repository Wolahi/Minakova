package com.gamestore.gamestorebackendkotlin.anketa.models.questions.table

import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption

object QuestionsTable : ExtendedLongIdTable(name = "question") {
    val anketa = reference("anketa_id", AnketaTable, onDelete = ReferenceOption.CASCADE)
    val question: Column<String> =  varchar(name = "questionLabel", length = 500)

    init {
        uniqueIndex(
            customIndexName = "QUESTION_UNIQUE",
            columns = arrayOf(QuestionsTable.question),
        )
    }
}