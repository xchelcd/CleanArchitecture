package com.example.cleanarchitecture.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentLoginBinding
import com.example.cleanarchitecture.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn

@AndroidEntryPoint
class LoginScreen : Fragment() {

    private val TAG = this.javaClass.simpleName

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@LoginScreen
            setHandlerSubmit(::handlerSubmit)
            setHandlerUserName(viewModel::setUserName)
            setHandlerPassword(viewModel::setPassword)
            setHandlerTest(::handlerTest)
        }
    }

    private fun handlerTest() {
        binding.root.toast("click")
    }

    private fun handlerSubmit() {
        viewModel.tryLogin(::render) {
            findNavController().navigate(R.id.action_loginScreen_to_homeScreen)
        }
    }

    private fun render(state: LoginState) {
        binding.loginState = state
    }
}
