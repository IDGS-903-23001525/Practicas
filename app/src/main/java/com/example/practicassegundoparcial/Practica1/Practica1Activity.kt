package com.example.practicassegundoparcial.Practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicassegundoparcial.R
import kotlin.math.pow
import kotlin.math.sqrt

class Practica1Activity : AppCompatActivity() {

    private lateinit var etX1: EditText
    private lateinit var etY1: EditText
    private lateinit var etX2: EditText
    private lateinit var etY2: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica1)

        etX1 = findViewById<EditText>(R.id.etX1)
        etY1 = findViewById<EditText>(R.id.etY1)
        etX2 = findViewById<EditText>(R.id.etX2)
        etY2 = findViewById<EditText>(R.id.etY2)
        tvResultado = findViewById<TextView>(R.id.tvResultado)
        btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener { calcularDistancia() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularDistancia() {
        val sX1 = etX1.text.toString()
        val sY1 = etY1.text.toString()
        val sX2 = etX2.text.toString()
        val sY2 = etY2.text.toString()

        val x1 = sX1.toDouble()
        val y1 = sY1.toDouble()
        val x2 = sX2.toDouble()
        val y2 = sY2.toDouble()

        val distancia = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

        tvResultado.text = "Resultado: d = $distancia"
    }
}