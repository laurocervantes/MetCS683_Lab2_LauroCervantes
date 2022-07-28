package com.example.testing
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class EditFragment : Fragment() {
    private lateinit var projTitle: EditText
    private lateinit var projDesc: EditText
    private lateinit var submit:Button
    private lateinit var cancel:Button
    private lateinit var editTextAuthor: EditText
    private lateinit var buttonAuthor: Button
    private lateinit var listViewAuthor: ListView
    var listAuthor: ArrayList<String> = ArrayList()
    lateinit var arrayAdapterAuthor: ArrayAdapter<String>
    private lateinit var editTextLinks: EditText
    private lateinit var isFavorite: CheckBox
    private lateinit var notFavorite: CheckBox


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projTitle = view.findViewById(R.id.projTitleEdit)
        projDesc =  view.findViewById(R.id.projDescEdit)

        submit = view.findViewById(R.id.submit)
        cancel = view.findViewById(R.id.cancel)
        isFavorite = view.findViewById(R.id.checkBox)
        notFavorite = view.findViewById(R.id.checkBox2)

        editTextAuthor= view.findViewById(R.id.editTextAuthor)
        buttonAuthor= view.findViewById(R.id.buttonAuthor)
        listViewAuthor= view.findViewById(R.id.listViewAuthor)
        arrayAdapterAuthor = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listAuthor)
        buttonAuthor.setOnClickListener {
            listAuthor.add(editTextAuthor.text.toString())
            editTextAuthor.setText("")
            arrayAdapterAuthor.notifyDataSetChanged()
            listViewAuthor.adapter = arrayAdapterAuthor
        }


        val position:Int = arguments?.getInt("projId")?:0
        Log.d("TAG","position:"+position)

        projTitle.setText(Project.projects[position].title)
        projDesc.setText(Project.projects[position].description)


        submit.setOnClickListener {
            Project.projects[position].title = projTitle.text.toString()
            Project.projects[position].description = projDesc.text.toString()
            Project.projects[position].authors = listAuthor.toString()
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }

        cancel.setOnClickListener {
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
    }
}