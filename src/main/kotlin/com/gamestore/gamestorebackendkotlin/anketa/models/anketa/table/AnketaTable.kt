package com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table

import com.gamestore.gamestorebackendkotlin.config.ExtendedLongIdTable
import org.jetbrains.exposed.sql.Column

object AnketaTable: ExtendedLongIdTable(name = "anketa") {
    val title: Column<String> =  varchar(name = "title", length = 500)
    val descr: Column<String> =  varchar(name = "descr", length = 500)

    init {
        uniqueIndex(
            customIndexName = "ANKETA_UNIQUE",
            columns = arrayOf(AnketaTable.title),
        )
    }
}