package com.gamestore.gamestorebackendkotlin.anketa.service.anketa

import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaPreviewOutput
import com.github.michaelbull.result.Ok

interface IAnketaService {

    fun getAnketas() : Ok<List<AnketaPreviewOutput>>

    fun getAnketa(id: Long): Ok<*>

    fun createAnketa(body: AnketaInput): Ok<String>
}