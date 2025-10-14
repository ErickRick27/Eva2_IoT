package com.tuapp.iotapp

import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
=======
import android.R

>>>>>>> 73d23e4 (avance)

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referencias a los elementos del layout
        val email = findViewById<EditText>(R.id.editEmail)
        val password = findViewById<EditText>(R.id.editPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnRecover = findViewById<Button>(R.id.btnRecover)
        val btnBluetooth = findViewById<Button>(R.id.btnBluetooth)

        // --- Acción de inicio de sesión simulada ---
        btnLogin.setOnClickListener {
            val correo = email.text.toString()
            val clave = password.text.toString()

            if (correo.isNotEmpty() && clave.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Inicio de sesión")
                    .setMessage("Bienvenido, $correo.\nSesión iniciada correctamente.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor, ingresa correo y contraseña.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        // --- Navegación hacia Registrar Cuenta ---
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // --- Navegación hacia Recuperar Clave ---
        btnRecover.setOnClickListener {
            startActivity(Intent(this, RecoverActivity::class.java))
        }

        // --- Verificación del estado del Bluetooth ---
        btnBluetooth.setOnClickListener {
            val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

            if (bluetoothAdapter == null) {
                // El dispositivo no tiene Bluetooth
                AlertDialog.Builder(this)
                    .setTitle("Bluetooth no disponible")
                    .setMessage("Tu dispositivo no soporta Bluetooth.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                // El dispositivo tiene Bluetooth, verificamos su estado
                if (bluetoothAdapter.isEnabled) {
                    AlertDialog.Builder(this)
                        .setTitle("Estado Bluetooth")
                        .setMessage("✅ El Bluetooth está ACTIVADO.\nSimulando conexión IoT exitosa.")
                        .setPositiveButton("OK", null)
                        .show()
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Estado Bluetooth")
                        .setMessage("⚠️ El Bluetooth está DESACTIVADO.\nPor favor actívalo para conectar dispositivos IoT.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
        }
    }
}