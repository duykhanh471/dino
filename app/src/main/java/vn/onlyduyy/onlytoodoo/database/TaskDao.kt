package vn.onlyduyy.onlytoodoo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface TaskDao {
    @Query("select * from task_table order by taskName DESC")
    fun retrieveAllTasks() : LiveData<List<TaskEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)
    @Update
    suspend fun updateTask(task: TaskEntity)
    @Delete
    suspend fun deleteTask(task: TaskEntity)

}