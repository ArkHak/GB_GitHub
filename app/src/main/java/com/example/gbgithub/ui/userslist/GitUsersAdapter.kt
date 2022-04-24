package com.example.gbgithub.ui.userslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gbgithub.domain.entitys.GitUserEntity

class GitUsersAdapter : RecyclerView.Adapter<GitUsersVH>() {
    private var data: List<GitUserEntity> = emptyList()

    fun setData(repos: List<GitUserEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    var listenerClick: OnUserClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitUsersVH {
        return GitUsersVH.create(parent)
    }

    override fun onBindViewHolder(holder: GitUsersVH, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listenerClick?.onUserClick(getItem(position))
        }
    }

    private fun getItem(pos: Int): GitUserEntity = data[pos]

    override fun getItemCount(): Int = data.size

    fun interface OnUserClickListener {
        fun onUserClick(user: GitUserEntity)
    }

}
