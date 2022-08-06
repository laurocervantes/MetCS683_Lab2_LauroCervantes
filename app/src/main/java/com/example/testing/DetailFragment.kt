package com.example.testing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class DetailFragment : Fragment(R.layout.fragment_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val projTitle = view.findViewById<TextView>(R.id.projTitle)
        val projDesc =  view.findViewById<TextView>(R.id.projDesc)
        val editProj = view.findViewById<ImageButton>(R.id.editProj)

        val viewModel =
            ViewModelProvider(requireActivity()).get(CurProjectViewModel::class.java)

        viewModel.curProject.observe(viewLifecycleOwner, Observer {
            projTitle.text =  it?.title?:""
            projDesc.text = it?.description?:""
        })


        editProj.setOnClickListener{
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }
    }
}