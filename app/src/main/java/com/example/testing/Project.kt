package com.example.testing

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="projects")
data class Project(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    @ColumnInfo(name="desc")
    var description: String)
/*data class Project
    (val id: Int,
     var title: String,
     var description: String,
     var authors: String,
     var isFavorite: String
    )*/
{

    /*companion object {
        // val project = Project(0, "Weather Forecast", "Weather Forcast is an app ...")
        val projects = mutableListOf(
            Project(0, "Weather Forecast", "Weather Forecast is an app ...", "KimK, Lady Gaga",
            "Favorite"),
            Project(1, "Connect Me", "Connect Me is an app ... ",
            "Kim K, Lady gaga", "Not favorite"),
            Project(2, "What to Eat", "What to Eat is an app ...",
            "Kim K, Britney S", "Favorite"),
            Project(3, "Project Portal", "Project Portal is an app ...",
            "Kim K, Theodore K", "Not favorite"))
    }*/
}
