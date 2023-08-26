package com.example.di

import com.example.config.AppConfig
import io.ktor.server.application.*
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger

fun Application.configureDI(koinModules: List<Module>) {
    install(Koin) {
        SLF4JLogger()
        modules(koinModules)
    }

}

val appModule = module {
    single { AppConfig() }
}
