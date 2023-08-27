package com.example.features.jokes.domain

import com.example.features.jokes.domain.model.JokeDTO

class JokeRepositoryImpl : JokeRepository {
    override suspend fun getRandomJoke(): JokeDTO {
        return JokeDTO(
            jokeId = "jokeId",
            jokeContent = "jokeContent"
        )
    }
}