package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    lateinit var projectportalDatabase: ProjectPortalDatabase
    lateinit var projectPortalRepository: ProjectPortalRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}