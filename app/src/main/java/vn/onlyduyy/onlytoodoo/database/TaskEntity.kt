package vn.onlyduyy.onlytoodoo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "taskName")
    var taskName: String = "unknown",
    @ColumnInfo(name = "taskProgress")
    var isDone: Boolean = false
)