package com.example.gbgithub.ui.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gbgithub.R
import com.example.gbgithub.databinding.ItemUsersListBinding
import com.example.gbgithub.domain.entitys.GitUserEntity
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.subjects.PublishSubject

class GitUsersVH(private val binding: ItemUsersListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GitUsersVH {
            val inflater = LayoutInflater.from(parent.context)
            return GitUsersVH(ItemUsersListBinding.inflate(inflater))
        }
    }

    fun bind(item: GitUserEntity) {
        binding.loginUserItemTextView.text = item.login
        binding.nameUserItemTextView.text = item.name
        binding.repositoryCountersUserItemTextView.text = item.publicRepos.toString()
        binding.followersCountersUserItemTextView.text = item.followers.toString()
        binding.followingCountersUserItemTextView.text = item.following.toString()
        Picasso.get()
            .load(item.avatarUrl)
            .error(R.drawable.img_user_item_default)
            .into(binding.avatarItemUsersListImageView)
    }
}
