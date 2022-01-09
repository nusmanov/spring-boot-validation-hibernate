package com.example.bookvalidation

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
@Validated
class AuthorController {


    @GetMapping("/author/{id}")
    fun getAuthorFromLegacyApi(@PathVariable("id") id: Long, authorDto: AuthorDto) = ResponseEntity.ok(authorDto.name)

}

data class AuthorDto(@JsonProperty("author[name]") val name: String?)
