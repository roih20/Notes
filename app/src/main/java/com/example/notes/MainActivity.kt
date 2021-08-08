package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.viewModel.NoteFactory
import com.example.notes.viewModel.NoteViewModel

class MainActivity : AppCompatActivity() {

    private val app by lazy {
        application as NoteApplication
    }

    private val noteFactory: NoteFactory by lazy {
        NoteFactory(app.noteRepository)
    }

    private val noteViewModel: NoteViewModel by viewModels {
        noteFactory
    }

    private var _binding : ActivityMainBinding?= null
    private val binding get () = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel = noteViewModel
            lifecycleOwner = this@MainActivity
        }

        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController =  navHost.navController
    }


}