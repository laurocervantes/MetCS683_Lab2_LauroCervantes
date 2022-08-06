package com.example.testing
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.testing.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val position:Int = arguments?.getInt("position")?:0
        Log.d("TAG","position:"+position)


        val viewModel =
            ViewModelProvider(requireActivity()).get(CurProjectViewModel::class.java)

        viewModel.curProject.observe(viewLifecycleOwner, Observer {
            binding.projTitleEdit.setText(it.title)
            binding.projDescEdit.setText(it.description)
        })

        binding.submit.setOnClickListener {
            viewModel.updateCurProject( binding.projTitleEdit.text.toString(),
                binding.projDescEdit.text.toString() )
            view.findNavController().navigate(R.id.action_editFragment_pop)
        }

        binding.cancel.setOnClickListener {
            view.findNavController().
            navigate(R.id.action_editFragment_pop)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}