package com.example.gbgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.example.gbgithub.databinding.GitHubMainBinding

class GitHubActivity : AppCompatActivity() {
    private lateinit var binding: GitHubMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        binding = GitHubMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}