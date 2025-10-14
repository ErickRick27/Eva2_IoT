package com.tuapp.iotapp

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.editName)
        val email = findViewById<EditText>(R.id.editEmail)
        val password = findViewById<EditText>(R.id.editPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val nombre = name.text.toString()
            val correo = email.text.toString()
            val clave = password.text.toString()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && clave.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Registro exitoso")
                    .setMessage("Usuario $nombre registrado correctamente.")
                    .setPositiveButton("OK") { _, _ -> finish() }
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor completa todos los campos.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}