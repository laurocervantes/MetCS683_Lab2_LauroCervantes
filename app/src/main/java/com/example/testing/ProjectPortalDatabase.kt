package com.example.testing

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Project::class],
    version = 1
)
abstract class ProjectPortalDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}