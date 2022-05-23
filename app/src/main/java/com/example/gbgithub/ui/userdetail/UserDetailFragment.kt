package com.example.gbgithub.ui.userdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.gbgithub.R
import com.example.gbgithub.app
import com.example.gbgithub.databinding.FragmentUserDetailBinding
import com.example.gbgithub.domain.RepositoryUsecase
import com.squareup.picasso.Picasso
import javax.inject.Inject

class UserDetailFragment : Fragment() {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var repository: RepositoryUsecase

    private val viewModel: UserDetailViewModel by viewModels {
        GitUserProjectsViewModelFactory((repository))
    }

    private val adapter = GitUserProjectsAdapter()

    private val args by navArgs<UserDetailFragmentArgs>()
    private val user by lazy { args.user }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        app.appDependenciesComponent.inject(this)

        initViews()
        initViewModelEvents()
    }

    private fun initViews() {
        binding.userDetailProjectsRecyclerView.adapter = adapter
        binding.loginUserDetailTextView.text = user.login
        Picasso.get()
            .load(user.avatarUrl)
            .error(R.drawable.img_user_item_default)
            .into(binding.avatarUserDetailImageView)
    }

    private fun initViewModelEvents() {
        viewModel.userProjectsList.observe(viewLifecycleOwner) { usersList ->
            adapter.setData(usersList)
        }
        viewModel.inProgress.observe(viewLifecycleOwner) { inProgress ->
            binding.progressBarFrameLayout.isVisible = inProgress
            binding.userDetailProjectsRecyclerView.isVisible = !inProgress
        }
        viewModel.updateUserProjectsListRepo(user.login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}