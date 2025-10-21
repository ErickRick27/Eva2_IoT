package com.tuapp.iotapp
import com.tuapp.iotapp.R

import android.app.AlertDialog
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class RecoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

        // Habilita la flecha de "Regresar" en la ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // <-- AÑADE ESTA LÍNEA

        val email = findViewById<EditText>(R.id.editEmail)
        val btnRecover = findViewById<Button>(R.id.btnRecover)

        btnRecover.setOnClickListener {
            val correo = email.text.toString()

            if (correo.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Recuperación de clave")
                    .setMessage("Se ha enviado un correo a $correo con instrucciones para recuperar la contraseña.")
                    .setPositiveButton("OK") { _, _ -> finish() }
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor ingresa tu correo electrónico.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}