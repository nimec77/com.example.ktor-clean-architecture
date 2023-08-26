package com.example

import com.example.config.configureAppConfig
import com.example.di.appModule
import com.example.di.configureDI
import com.example.plugins.configureMonitoring
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.cio.*
import org.koin.core.module.Module

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false, koinModules: List<Module> = listOf(appModule)) {
    configureDI(koinModules)
    configureAppConfig()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
