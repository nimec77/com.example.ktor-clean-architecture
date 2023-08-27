package com.example.features.jokes.resources

import com.example.features.jokes.domain.JokeRepository
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

@Resource("joke")
class JokeEndpoint {
    @Resource("/random")
    class Random(val parent: JokeEndpoint = JokeEndpoint())
}

fun Route.jokeEndpoint() {
    val jokeRepository by inject<JokeRepository>()

    get<JokeEndpoint.Random> {
        call.respond(jokeRepository.getRandomJoke())
    }
}