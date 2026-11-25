package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogapp.R
import com.dogapp.databinding.FragmentLoginBinding
import com.dogapp.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observadorViewModel()
    }

    private fun controladores() {
        binding.lottieHuella.setOnClickListener {
            autenticar()
        }
    }

    private fun observadorViewModel() {
        loginViewModel.autenticado.observe(viewLifecycleOwner) { autenticado ->
            if (autenticado == true) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    private fun autenticar() {
        val authenticators = BiometricManager.Authenticators.BIOMETRIC_STRONG
        val status = BiometricManager.from(requireContext()).canAuthenticate(authenticators)
        if (status != BiometricManager.BIOMETRIC_SUCCESS) {
            Toast.makeText(context, mensajeBiometria(status), Toast.LENGTH_SHORT).show()
            return
        }

        val prompt = BiometricPrompt(
            this,
            ContextCompat.getMainExecutor(requireContext()),
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    loginViewModel.loginCorrecto()
                }
            }
        )
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.biometric_title))
            .setSubtitle(getString(R.string.biometric_subtitle))
            .setNegativeButtonText(getString(R.string.biometric_negative))
            .setAllowedAuthenticators(authenticators)
            .setConfirmationRequired(false)
            .build()
        prompt.authenticate(promptInfo)
    }

    private fun mensajeBiometria(status: Int): String {
        val messageId = when (status) {
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> R.string.biometric_none_enrolled
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> R.string.biometric_no_hardware
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> R.string.biometric_hw_unavailable
            else -> R.string.biometric_unavailable
        }
        return getString(messageId)
    }
}
