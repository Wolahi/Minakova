package com.gamestore.gamestorebackendkotlin.anketa.api.http
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.anketa.AnketaPreviewOutput
import com.gamestore.gamestorebackendkotlin.anketa.dto.answer.AnswerAnketaInput
import com.gamestore.gamestorebackendkotlin.anketa.dto.result.ResultOutput
import com.github.michaelbull.result.Ok
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/anketa")
class AnketaController(val anketaService: AnketaService) {


    @GetMapping("all")
    fun getAllAnketas(): ResponseEntity<Ok<List<AnketaPreviewOutput>>> {
        return ok(anketaService.getAnketas())
    }

    @GetMapping("{id}")
    fun getAnketaById(
        @PathVariable id: Long
    ): ResponseEntity<Ok<*>> {
        return ok(anketaService.getAnketa(id))
    }

    @PostMapping("/create")
    fun createAnketa(
        @RequestBody body: AnketaInput
    ): ResponseEntity<Ok<String>> {
        return ok(anketaService.createAnketa(body))
    }

    @PostMapping("/result")
    fun result(@RequestBody body: AnswerAnketaInput): ResponseEntity<Ok<ResultOutput?>> {
        return ok(anketaService.result(body))
    }
}