package com.example.gbgithub.ui.userslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gbgithub.app
import com.example.gbgithub.databinding.FragmentUsersListBinding
import com.example.gbgithub.domain.RepositoryUsecase
import javax.inject.Inject


class UsersListFragment : Fragment() {

    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var repository: RepositoryUsecase

    private val viewModel: UsersListViewModel by viewModels {
        UsersListViewModelFactory(repository)
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

        app.appDependenciesComponent.inject(this)

        initViews()
        initViewModelEvents()
        initActon()
    }

    private fun initViews() {
        binding.usersListRecyclerView.adapter = adapter
    }

    private fun initActon() {
        adapter.listenerClick = GitUsersAdapter.OnUserClickListener { user ->
            findNavController().navigate(
                UsersListFragmentDirections.actionUsersListToUserDetail(user)
            )
        }
    }

    private fun initViewModelEvents() {
        viewModel.usersList.observe(viewLifecycleOwner) { usersList ->
            adapter.setData(usersList)
        }
        viewModel.inProgress.observe(viewLifecycleOwner) { inProgress ->
            binding.progressBarFrameLayout.isVisible = inProgress
        }
        viewModel.updateUsersListRepo()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}