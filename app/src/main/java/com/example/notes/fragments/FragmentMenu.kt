package com.example.notes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.NoteApplication
import com.example.notes.R
import com.example.notes.databinding.FragmentMenuBinding
import com.example.notes.viewModel.NoteFactory
import com.example.notes.viewModel.NoteRecycleView
import com.example.notes.viewModel.NoteViewModel

class FragmentMenu: Fragment(), SearchView.OnQueryTextListener {

    private val factory by lazy {
        val application = requireActivity().application as NoteApplication
        NoteFactory(application.noteRepository)
    }

    private val noteViewModel: NoteViewModel by viewModels{
        factory
    }

    private var _binding : FragmentMenuBinding?= null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = noteViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = NoteRecycleView()

        val rv = binding.notesRv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.item1 -> {
                    findNavController().navigate(R.id.action_fragmentMenu_to_fragmentCreateNote)
                    true
                }
            }
        }

        binding.bottomNavigation.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentMenu_to_fragmentCreateNote)
        }

        noteViewModel.noteList.observe(viewLifecycleOwner){
            rvAdapter.setData(it)
        }


    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            searchNote(query)
        }
        return true
    }

    override fun onQueryTextChange(query:String?): Boolean {
        return true
    }


    private fun searchNote(query: String){
        noteViewModel.searchNote(query)
    }
}