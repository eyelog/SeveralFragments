package ru.eyelog.severalfragments.di

import dagger.Module
import dagger.Provides
import ru.eyelog.severalfragments.AwesomeViewModel
import javax.inject.Singleton

@Module
class VMModule {

    @Singleton
    @Provides
    fun provideViewModel() = AwesomeViewModel()
}