package com.example.testing

import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class ProjectPortalRepository (
    private val projectDao: ProjectDao
) {
    val executor =  Executors.newSingleThreadExecutor()

    fun addProject(project: Project){
        executor.execute {
            projectDao.addProject(project)
        }
    }

    fun delProject(project: Project) {
        executor.execute {
            projectDao.delProject(project)
        }
    }

    fun editProject(project: Project) {
        executor.execute {
            projectDao.editProject(project)
        }
    }

    fun getAllProjects(): LiveData<List<Project>> {
        return projectDao.getAllProjects()
    }

    fun searchProject(projId: Long): LiveData<Project> {
       return projectDao.searchProject(projId)
    }

    fun searchProjectsbyTitle(projTitle:String): LiveData<List<Project>> {
        return projectDao.searchProjectsbyTitle(projTitle)
    }

    fun count(): LiveData<Int> {
        return projectDao.count()
    }
}