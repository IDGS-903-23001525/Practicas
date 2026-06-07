package com.example.practicassegundoparcial.Practica2

import com.example.practicassegundoparcial.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class ResultadoTrianguloActivity : AppCompatActivity() {

    private lateinit var tvAreaResultado: TextView
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_triangulo)

        tvAreaResultado = findViewById<TextView>(R.id.tvAreaResultado)
        btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnRegresar.setOnClickListener { regresar() }

        // Ejecutamos el procesamiento al cargar la pantalla
        procesarArea()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun procesarArea() {
        val a = intent.getDoubleExtra("LADO_A", 0.0)
        val b = intent.getDoubleExtra("LADO_B", 0.0)
        val c = intent.getDoubleExtra("LADO_C", 0.0)

        val s = (a + b + c) / 2

        val area = sqrt(s * (s - a) * (s - b) * (s - c))

        tvAreaResultado.text = "Área: $area"
    }

    fun regresar() {
        finish()
    }
}