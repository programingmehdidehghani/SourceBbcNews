package com.example.sourcebbcnews.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.biometric.BiometricManager

import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.sourcebbcnews.R
import java.util.concurrent.Executor

class SplashActivity : AppCompatActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val biometricManager = BiometricManager.from(this)
        executor = ContextCompat.getMainExecutor(this)

        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int,
                                                   errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext,
                        "Authentication error: $errString", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    val  intent = Intent(this@SplashActivity , MainActivity::class.java)
                    startActivity(intent)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")
            .build()
        biometricPrompt.authenticate(promptInfo)



 /*       when (biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS ->{
                intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->{
                intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->{
                intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {

                }
            }*/
        }

}