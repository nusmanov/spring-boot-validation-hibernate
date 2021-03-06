package com.example.bookvalidation.author

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthorController {


    @GetMapping("/author/{id}")
    fun getAuthorFromLegacyApi(
        @PathVariable("id") id: Long,
        authorDto: AuthorDto?
    ) = ResponseEntity.ok(authorDto)

}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class AuthorDto(
    @RequestParam(name = "author[name]")
    val name: String?,
    // long list of different query parameters
    val country: String? = null,
)
