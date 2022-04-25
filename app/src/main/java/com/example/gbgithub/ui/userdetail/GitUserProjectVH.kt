package com.example.gbgithub.ui.userdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gbgithub.databinding.ItemProjectsListBinding
import com.example.gbgithub.domain.dto.GitProjectDto
import com.example.gbgithub.domain.entitys.GitProjectsEntity

class GitUserProjectVH(private val binding: ItemProjectsListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GitUserProjectVH {
            val inflater = LayoutInflater.from(parent.context)
            return GitUserProjectVH(ItemProjectsListBinding.inflate(inflater))
        }
    }

    fun bind(item: GitProjectsEntity) {
        binding.idProjectTextView.text = item.id.toString()
        binding.titleProjectTextView.text = item.nameProject
    }
}