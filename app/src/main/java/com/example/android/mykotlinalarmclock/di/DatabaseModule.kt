package com.example.android.mykotlinalarmclock.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.data.AlarmDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AlarmDatabase {
        return Room.databaseBuilder(appContext, AlarmDatabase::class.java, "alarm_database")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDao(database: AlarmDatabase): AlarmDao {
        return database.alarmDao()
    }
}