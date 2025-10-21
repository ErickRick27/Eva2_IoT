package com.tuapp.iotapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Duración de la pantalla de bienvenida (ej: 2 segundos)
        val splashScreenDuration = 3000L

        // Handler para ejecutar una acción después de un tiempo determinado
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un Intent para ir a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Cierra MainActivity para que el usuario no pueda volver a ella con el botón de "atrás"
            finish()
        }, splashScreenDuration)
    }
}
