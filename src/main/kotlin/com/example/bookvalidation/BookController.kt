package com.example.bookvalidation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class BookController {


    @GetMapping("/book/{id}")
    fun getBook(@PathVariable("id") id: Long): BookDto = BookDto(1, "Harry Potter", 2004)

    @PostMapping("/book")
    fun createBook(@RequestBody bookDto: BookDto) = ResponseEntity.created(URI.create("some-cool-haeos-uri"))
}