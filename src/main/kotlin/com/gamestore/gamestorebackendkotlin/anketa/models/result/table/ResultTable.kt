package com.gamestore.gamestorebackendkotlin.anketa.models.result.table

import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column

object ResultTable: ExtendedLongIdTable(name = "result") {
    val title: Column<String> = varchar("title", length = 100)
    val description: Column<String> = varchar("description", length = 500)

    init {
        uniqueIndex(
            customIndexName = "RESULT_UNIQUE",
            columns = arrayOf(ResultTable.title),
        )
    }
}