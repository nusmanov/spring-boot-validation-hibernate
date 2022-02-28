package com.example.bookvalidation.author

import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AuthorController::class)
@AutoConfigureMockMvc
internal class AuthorControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `getAuthorFromLegacyApi should deserialize author name - Joe`() {

        this.mockMvc.perform(get("/author/5?author[name]=Joe&country=England"))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(content().string(containsString("Joe")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Joe"))
    }

    @Test
    fun getAuthorFromLegacyApi_negativ_test() {

        this.mockMvc.perform(get("/author/5"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("")))
    }

}