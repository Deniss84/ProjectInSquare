package com.example.projectinsquare.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OnlineStorage

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalStorage
