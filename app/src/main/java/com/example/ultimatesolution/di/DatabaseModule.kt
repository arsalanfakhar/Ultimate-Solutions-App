package com.example.ultimatesolution.di

import android.content.Context
import androidx.room.Room
import com.example.ultimatesolution.database.AppDatabase
import com.example.ultimatesolution.database.TasksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideTasksDao(appDatabase: AppDatabase):TasksDao {
//        return appDatabase.getTasksDao()
//    }

}