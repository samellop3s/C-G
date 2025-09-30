package com.app.estudos

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay de 3 segundos antes de ir pra tela de entrada
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, EntradaActivity::class.java))
            finish()
        }, 3000) // 3000 ms = 3s
    }
}
