package com.example.cleanarchitecture.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.databinding.FragmentHomeBinding
import com.example.cleanarchitecture.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        lifecycleScope.launchWhenCreated {
            launch { viewModel.state.collect(::render) }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@HomeScreen
            setHandlerItemSelected(::handlerItemSelected)
        }
    }

    private fun handlerItemSelected(post: Any) {
        if (post is Post) binding.root.toast(post.title)
        else binding.root.toast("Hola")
    }

    private fun render(state: HomeState) {
        binding.state = state
    }

}