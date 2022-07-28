package com.example.testing
import android.content.Context
import android.icu.lang.UCharacter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout.VERTICAL
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.FragmentProjectRecyclerViewBinding

class ProjectListRecyclerViewFragment : Fragment() {

    lateinit var myProjListRecyclerViewAdapter: MyProjListRecyclerViewAdapter
    lateinit var projlist: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projlist = view.findViewById(R.id.projlist)

        myProjListRecyclerViewAdapter = MyProjListRecyclerViewAdapter(Project.projects)
        projlist.adapter = myProjListRecyclerViewAdapter
        projlist.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

}