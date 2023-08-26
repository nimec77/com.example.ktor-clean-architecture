package com.example.config

import ch.qos.logback.classic.Logger
import io.ktor.server.application.*
import org.koin.ktor.ext.inject
import org.slf4j.LoggerFactory

class AppConfig {
    lateinit var serverConfig: ServerConfig
}

fun Application.configureAppConfig() {
    val appConfig by inject<AppConfig>()

    val serverObject = environment.config.config("ktor.server")
    val isProd = serverObject.property("isProd").getString().toBoolean()
    appConfig.serverConfig = ServerConfig(isProd)

    if (!appConfig.serverConfig.isProd) {
        val root = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME) as Logger
        root.level = ch.qos.logback.classic.Level.TRACE
    }
}

data class ServerConfig(
    val isProd: Boolean
)