package vn.onlyduyy.onlytoodoo.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import vn.onlyduyy.onlytoodoo.database.TaskDao
import vn.onlyduyy.onlytoodoo.database.TaskDatabase
import vn.onlyduyy.onlytoodoo.database.TaskRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.databaseBuilder(app, TaskDatabase::class.java, "task_db")
            .build()
    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase) = taskDatabase.getTaskDao()

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao) = TaskRepository(taskDao)

}

