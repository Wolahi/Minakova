package com.gamestore.gamestorebackendkotlin.anketa.api.http

import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaOutput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaPreviewOutput
import com.gamestore.gamestorebackendkotlin.anketa.repository.anketa.AnketaRepository
import com.gamestore.gamestorebackendkotlin.anketa.service.anketa.IAnketaService
import com.gamestore.gamestorebackendkotlin.extensions.Result
import com.gamestore.gamestorebackendkotlin.extensions.ok
import com.github.michaelbull.result.Ok
import org.springframework.stereotype.Service

@Service
class AnketaService(val anketaRepository: AnketaRepository) : IAnketaService{
    override fun getAnketas(): Ok<List<AnketaPreviewOutput>> {
        return Result.ok(anketaRepository.getAnketas())
    }

    override fun getAnketa(id: Long): Ok<*> {
        val anketa = anketaRepository.getAnketa(id)
        if(anketa != null) {
            return Result.ok(anketaRepository.getAnketa(id))
        }
        return Result.ok("Такой анкеты нет")

    }

    override fun createAnketa(body: AnketaInput): Ok<String> {
        return Result.ok(anketaRepository.createAnketa(body))
    }

}