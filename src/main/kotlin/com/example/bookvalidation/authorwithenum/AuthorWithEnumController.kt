package com.example.bookvalidation

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@Validated
class AuthorWithEnumController {

    @GetMapping("/abc")
    fun getBookType(@RequestParam(required = false) bookType: BookTypeEnum): ResponseEntity<BookTypeEnum> {
        //val bookType=BookTypeEnum.FANTASY
        println(" ENUM: $bookType")
        return ResponseEntity.ok(bookType)
    }


}

enum class BookTypeEnum(val value: String) {
    HISTORY("HISTORY"),
    FANTASY("FANTASY")
}