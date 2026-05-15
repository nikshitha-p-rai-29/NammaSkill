package com.nammaskill.app.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nammaskill.app.data.model.Application
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.data.model.SuccessStory
import com.nammaskill.app.data.model.UserProfile
import com.nammaskill.app.utils.Converters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Course::class, UserProfile::class, Application::class, SuccessStory::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NammaSkillDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun applicationDao(): ApplicationDao
    abstract fun storyDao(): StoryDao

    companion object {
        @Volatile private var INSTANCE: NammaSkillDatabase? = null

        fun getDatabase(context: Context): NammaSkillDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NammaSkillDatabase::class.java,
                    "namma_skill_db"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        INSTANCE?.let { database ->
                            CoroutineScope(Dispatchers.IO).launch {
                                SeedData.seedDatabase(database)
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
