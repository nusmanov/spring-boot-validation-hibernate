package com.example.bookvalidation.authorwithenum

import com.example.bookvalidation.AuthorWithEnumController
import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AuthorWithEnumController::class, properties = ["spring.jackson.mapper.ACCEPT_CASE_INSENSITIVE_ENUMS=true"])
@AutoConfigureMockMvc
internal class AuthorWithEnumControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc




    @Test
    fun `getBookType - FANTASY`() {

        this.mockMvc.perform(get("/abc?bookType=fantasy"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("FANTASY")))
    }

}