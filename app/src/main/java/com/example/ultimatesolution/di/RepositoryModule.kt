package com.example.ultimatesolution.di

import com.example.ultimatesolution.database.AppDatabase
import com.example.ultimatesolution.repository.UltimateSolutionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {


    @Singleton
    @Provides
    fun provideRepository(appDatabase: AppDatabase): UltimateSolutionRepository {
        return UltimateSolutionRepository(
            appDatabase
        )
    }


}