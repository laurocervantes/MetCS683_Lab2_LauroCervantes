package com.example.testing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class ProjectListViewModel(application: Application):
    AndroidViewModel(application) {


    val projectPortalRepository =
        (application as ProjectPortalApplication).projectPortalRepository


    private val _projectList: LiveData<List<Project>>
            = projectPortalRepository.getAllProjects()
    val projectList:LiveData<List<Project>>
        get() = _projectList

    fun getAllProjects(): LiveData<List<Project>> {
        return projectPortalRepository.getAllProjects()
    }

    fun addProject(project: Project) {
        projectPortalRepository.addProject(project)
    }

    fun delProject(project: Project) {
        projectPortalRepository.delProject(project)
    }

}