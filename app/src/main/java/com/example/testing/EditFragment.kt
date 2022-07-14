package com.example.testing
import android.content.Context
import android.os.Bundle
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

        projTitle.setText(Project.project.title)
        projDesc.setText(Project.project.description)

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
        editTextLinks = view.findViewById(R.id.editTextTextMultiLine)


        submit.setOnClickListener {
            Project.project.title = projTitle.text.toString()
            Project.project.description = projDesc.text.toString()
            Project.project.authors = listAuthor.toString()
            Project.project.links = editTextLinks.text.toString()
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
        cancel.setOnClickListener {
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
    }
}