package com.example.notes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.viewModel.NoteViewModel

class FragmentCreateNote: Fragment() {

    private val noteViewModel: NoteViewModel by activityViewModels()
    private var _binding : FragmentCreateNoteBinding ?= null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false).apply {
            viewModel = noteViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backTxt.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentCreateNote_to_fragmentMenu)
        }
    }
}