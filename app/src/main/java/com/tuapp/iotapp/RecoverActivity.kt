package com.tuapp.iotapp

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
=======
import android.R

>>>>>>> 73d23e4 (avance)

class RecoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

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
}