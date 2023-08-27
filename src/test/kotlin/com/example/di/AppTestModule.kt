package com.example.di

import com.example.config.AppConfig
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appTestModule = module {
    singleOf(::AppConfig)
}