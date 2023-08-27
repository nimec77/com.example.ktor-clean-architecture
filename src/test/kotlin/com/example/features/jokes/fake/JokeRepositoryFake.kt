package com.example.features.jokes.fake

import com.example.features.jokes.domain.JokeRepository
import com.example.features.jokes.domain.model.JokeDTO

class JokeRepositoryFake : JokeRepository {
    override suspend fun getRandomJoke(): JokeDTO {
        return JokeDTO(
            jokeId = "fake-id",
            jokeContent = "fake-content"
        )
    }
}