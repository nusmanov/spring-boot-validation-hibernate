package com.example.bookvalidation

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class BookDto(

        val id: Long,

        @field:NotBlank
        @field:Length(min = 2,max = 3, message = "Bitte Buchtitel ab ...")
        val title: String,

        @field:NotNull
        @field:Min(1900)
        val year: Long)