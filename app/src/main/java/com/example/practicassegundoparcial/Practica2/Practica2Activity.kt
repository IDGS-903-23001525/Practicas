package com.example.practicassegundoparcial.Practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicassegundoparcial.R

class Practica2Activity : AppCompatActivity() {

    private lateinit var etLadoA: EditText
    private lateinit var etLadoB: EditText
    private lateinit var etLadoC: EditText
    private lateinit var btnVerificar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica2)

        etLadoA = findViewById<EditText>(R.id.etLadoA)
        etLadoB = findViewById<EditText>(R.id.etLadoB)
        etLadoC = findViewById<EditText>(R.id.etLadoC)
        btnVerificar = findViewById<Button>(R.id.btnVerificar)

        btnVerificar.setOnClickListener { verificarTriangulo() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun verificarTriangulo() {
        val sA = etLadoA.text.toString()
        val sB = etLadoB.text.toString()
        val sC = etLadoC.text.toString()

        val a = sA.toDouble()
        val b = sB.toDouble()
        val c = sC.toDouble()

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            val intent = Intent(this, ResultadoTrianguloActivity::class.java)
            intent.putExtra("LADO_A", a)
            intent.putExtra("LADO_B", b)
            intent.putExtra("LADO_C", c)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Las medidas no forman un triángulo válido", Toast.LENGTH_LONG).show()
        }
    }
}