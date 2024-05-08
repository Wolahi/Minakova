package com.gamestore.gamestorebackendkotlin.anketa.models.anketa

import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaPreviewOutput
import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.table.AnketaTable
import com.gamestore.gamestorebackendkotlin.config.ExtendedLongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class AnketaEntity(id: EntityID<Long>) : ExtendedLongEntity(id, AnketaTable) {

    companion object : LongEntityClass<AnketaEntity>(AnketaTable)

    var title by AnketaTable.title
    var descr by AnketaTable.descr

    fun toDto(): AnketaPreviewOutput {
        return AnketaPreviewOutput(this)
    }
}


