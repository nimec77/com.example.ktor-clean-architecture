package com.example.features.jokes.resource

import com.example.di.appTestModule
import com.example.features.jokes.domain.JokeRepository
import com.example.features.jokes.domain.JokeRepositoryImpl
import com.example.features.jokes.domain.model.JokeDTO
import com.example.testutils.withTestServer
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.junit.Test
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import kotlin.test.assertEquals

class JokeResourceTest : AutoCloseKoinTest() {
    @Test
    fun `random joke api works correctly`() = withTestServer(
        koinModules = appTestModule.plus(
            module {
                single<JokeRepository> { JokeRepositoryImpl() }
            }
        )
    ) { client ->
        val response = client.get("/joke/random")
        assertEquals(HttpStatusCode.OK, response.status)

        val jokeDTO = Json.decodeFromString<JokeDTO>(response.body())

        assertEquals("jokeId", jokeDTO.jokeId)
        assertEquals("jokeContent", jokeDTO.jokeContent)
    }
}