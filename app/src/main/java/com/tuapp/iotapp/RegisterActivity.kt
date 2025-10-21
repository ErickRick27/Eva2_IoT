package com.tuapp.iotapp
import com.tuapp.iotapp.R

import android.app.AlertDialog
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register) // Asegúrate de que el layout se llame 'activity_register.xml'

        // Habilita la flecha de "Regresar" en la ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // <-- AÑADE ESTA LÍNEA

        // Aquí iría el resto de tu lógica para el registro
        val email = findViewById<EditText>(R.id.editEmail) // Asume que tienes estos IDs en tu XML
        val password = findViewById<EditText>(R.id.editPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val correo = email.text.toString()
            val clave = password.text.toString()

            if (correo.isNotEmpty() && clave.isNotEmpty()) {
                // Lógica de registro (aquí solo mostramos un diálogo de éxito)
                AlertDialog.Builder(this)
                    .setTitle("Registro Exitoso")
                    .setMessage("El usuario $correo ha sido registrado.")
                    .setPositiveButton("OK") { _, _ ->
                        // Finaliza la actividad de registro y regresa al login
                        finish()
                    }
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor, completa todos los campos.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }

    // Este método se llama cuando se presiona la flecha de regreso
    override fun onOptionsItemSelected(item: MenuItem): Boolean { // <-- AÑADE ESTE MÉTODO
        when (item.itemId) {
            android.R.id.home -> {
                // Finaliza la actividad actual y regresa a la pantalla anterior (Login)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}