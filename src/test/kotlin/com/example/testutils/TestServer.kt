package com.example.testutils

import com.example.config.AppConfig
import com.example.config.ServerConfig
import com.example.di.appTestModule
import com.example.module
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.koin.core.module.Module

fun MapApplicationConfig.createConfigForTesting() {
    put("ktor.server.isProd", "false")
}

fun getAppConfigForUnitTest(): AppConfig {
    return AppConfig().apply {
        serverConfig = ServerConfig(isProd = false)
    }
}

fun withTestServer(koinModules: List<Module> = listOf(appTestModule), block: suspend (HttpClient) -> Unit) {
    testApplication {
        application {
            module(testing = true, koinModules = koinModules)
        }
        this.environment {
            config = MapApplicationConfig().apply {
                createConfigForTesting()
            }
        }

        client.get("/")

        block(client)
    }
}