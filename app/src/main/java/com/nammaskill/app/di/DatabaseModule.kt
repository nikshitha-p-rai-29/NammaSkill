package com.nammaskill.app.di

import android.content.Context
import com.nammaskill.app.data.repository.ApplicationDao
import com.nammaskill.app.data.repository.CourseDao
import com.nammaskill.app.data.repository.NammaSkillDatabase
import com.nammaskill.app.data.repository.StoryDao
import com.nammaskill.app.data.repository.UserProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NammaSkillDatabase {
        return NammaSkillDatabase.getDatabase(context)
    }

    @Provides
    fun provideCourseDao(db: NammaSkillDatabase): CourseDao = db.courseDao()

    @Provides
    fun provideProfileDao(db: NammaSkillDatabase): UserProfileDao = db.userProfileDao()

    @Provides
    fun provideApplicationDao(db: NammaSkillDatabase): ApplicationDao = db.applicationDao()

    @Provides
    fun provideStoryDao(db: NammaSkillDatabase): StoryDao = db.storyDao()
}
