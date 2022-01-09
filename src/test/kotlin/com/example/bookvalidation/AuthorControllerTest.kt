package com.example.bookvalidation

import org.hamcrest.Matchers
import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AuthorController::class)
@AutoConfigureMockMvc
internal class AuthorControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `getAuthorFromLegacyApi should deserialize author name - Tom`() {

        this.mockMvc.perform(get("/author/5?author[name]=Tom"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Tom")))
    }

    @Test
    fun getAuthorFromLegacyApi_negativ_test() {

        this.mockMvc.perform(get("/author/5"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("")))
    }

}