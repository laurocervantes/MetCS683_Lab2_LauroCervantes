package com.example.testing

import android.os.Bundle
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projTitle = view.findViewById(R.id.projTitle)
        projDesc =  view.findViewById(R.id.projDesc)
        editProj = view.findViewById(R.id.editProj)
        links = view.findViewById(R.id.editTextTextLinks)
        isFav = view.findViewById(R.id.textViewIsFav)

        projTitle.text =  Project.project.title
        projDesc.text = Project.project.description
        links.text = Project.project.links
        isFav.text = Project.project.isFavorite

        editProj.setOnClickListener{
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }
    }
}