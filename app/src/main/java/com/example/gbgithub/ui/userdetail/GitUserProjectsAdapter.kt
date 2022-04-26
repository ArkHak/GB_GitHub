package com.example.gbgithub.ui.userdetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gbgithub.domain.dto.GitProjectDto
import com.example.gbgithub.domain.entitys.GitProjectsEntity

class GitUserProjectsAdapter : RecyclerView.Adapter<GitUserProjectVH>() {
    private var data: List<GitProjectsEntity> = emptyList()

    fun setData(projects: List<GitProjectsEntity>) {
        data = projects
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitUserProjectVH {
        return GitUserProjectVH.create(parent)
    }

    override fun onBindViewHolder(holder: GitUserProjectVH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitProjectsEntity = data[pos]

    override fun getItemCount(): Int = data.size

}
