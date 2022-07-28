package com.example.testing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var projTitle: TextView
    private lateinit var projDesc: TextView
    private lateinit var editProj: ImageButton
    private lateinit var links: TextView
    private lateinit var isFav: TextView
    private lateinit var authors: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projTitle = view.findViewById(R.id.projTitle)
        projDesc =  view.findViewById(R.id.projDesc)
        editProj = view.findViewById(R.id.editProj)
        isFav = view.findViewById(R.id.textViewIsFav)
        authors = view.findViewById(R.id.projectAuthors)

        val position:Int = arguments?.getInt("projId")?:1
        Log.d("TAG","position:"+ position)
        projTitle.text =  Project.projects[position].title
        projDesc.text = Project.projects[position].description
        isFav.text = Project.projects[position].isFavorite
        authors.text = Project.projects[position].description

        editProj.setOnClickListener{
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }
    }
}