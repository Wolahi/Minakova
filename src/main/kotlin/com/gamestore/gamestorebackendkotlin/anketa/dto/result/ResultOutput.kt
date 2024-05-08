package com.gamestore.gamestorebackendkotlin.anketa.dto.result

import com.gamestore.gamestorebackendkotlin.anketa.models.result.ResultEntity

class ResultOutput(val id: Long, val title: String, val description: String) {

    constructor(r: ResultEntity): this(
        r.id.value,
        r.description,
        r.title
    )
}