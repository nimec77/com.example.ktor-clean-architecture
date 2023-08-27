package com.example.features.jokes.domain

import com.example.features.jokes.domain.model.JokeDTO

interface JokeRepository {
    suspend fun getRandomJoke(): JokeDTO
}