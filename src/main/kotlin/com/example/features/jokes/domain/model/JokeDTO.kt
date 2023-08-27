package com.example.features.jokes.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class JokeDTO(
    val jokeId: String,
    val jokeContent: String
)

