package com.example.gbgithub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gbgithub.app
import com.example.gbgithub.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {

    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UsersListViewModel by activityViewModels {
        UsersListViewModelFactory(
            requireContext().app.gitUsersRepo
        )
    }
    private val adapter = GitUsersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModelEvents()
    }

    private fun initViews() {
        binding.usersListRecyclerView.adapter = adapter
    }

    private fun initViewModelEvents() {
        viewModel.usersList.observe(this) { usersList ->
            adapter.setData(usersList)
        }
        viewModel.updateUsersListRepo()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}