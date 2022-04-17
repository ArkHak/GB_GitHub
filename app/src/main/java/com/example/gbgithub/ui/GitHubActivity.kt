package com.example.gbgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.gbgithub.R
import com.example.gbgithub.databinding.GitHubMainBinding

class GitHubActivity : AppCompatActivity() {
    private lateinit var binding: GitHubMainBinding
    private val navigationController by lazy { findNavController(R.id.navigation_container_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GitHubMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}