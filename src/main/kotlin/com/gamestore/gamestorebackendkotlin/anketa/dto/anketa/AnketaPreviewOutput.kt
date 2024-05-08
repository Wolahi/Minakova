package com.gamestore.gamestorebackendkotlin.anketa.dto.anketa

import com.gamestore.gamestorebackendkotlin.anketa.models.anketa.AnketaEntity

class AnketaPreviewOutput(
    val id: Long,
    val title: String,
    val descr: String,
) {
    constructor(a: AnketaEntity) : this(
        a.id.value,
        a.title,
        a.descr
    )
}