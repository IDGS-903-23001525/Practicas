package com.example.practicassegundoparcial.Practica4

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.math.pow
import androidx.appcompat.app.AppCompatActivity
import com.example.practicassegundoparcial.R

class ResistenciasActivity : AppCompatActivity() {

    private val colores = arrayOf(
        "Negro", "Café", "Rojo", "Naranja", "Amarillo",
        "Verde", "Azul", "Violeta", "Gris", "Blanco"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resistencias)

        val spinnerBanda1 = findViewById<Spinner>(R.id.spinnerBanda1)
        val spinnerBanda2 = findViewById<Spinner>(R.id.spinnerBanda2)
        val spinnerMultiplicador = findViewById<Spinner>(R.id.spinnerMultiplicador)

        val tvResultadoBanda1 = findViewById<TextView>(R.id.tvResultadoBanda1)
        val tvResultadoBanda2 = findViewById<TextView>(R.id.tvResultadoBanda2)
        val tvResultadoMultiplicador = findViewById<TextView>(R.id.tvResultadoMultiplicador)

        val radioGroupTolerancia = findViewById<RadioGroup>(R.id.radioGroupTolerancia)
        val viewColorTolerancia = findViewById<View>(R.id.viewColorTolerancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val tvValorOhm = findViewById<TextView>(R.id.tvValorOhm)
        val tvValorMaximo = findViewById<TextView>(R.id.tvValorMaximo)
        val tvValorMinimo = findViewById<TextView>(R.id.tvValorMinimo)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colores)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerBanda1.adapter = adapter
        spinnerBanda2.adapter = adapter
        spinnerMultiplicador.adapter = adapter

        spinnerBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvResultadoBanda1.text = position.toString()
                tvResultadoBanda1.setBackgroundColor(obtenerColorHex(position))
                tvResultadoBanda1.setTextColor(if (position == 0 || position == 1 || position == 5 || position == 6) Color.WHITE else Color.BLACK)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvResultadoBanda2.text = position.toString()
                tvResultadoBanda2.setBackgroundColor(obtenerColorHex(position))
                tvResultadoBanda2.setTextColor(if (position == 0 || position == 1 || position == 5 || position == 6) Color.WHITE else Color.BLACK)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val multiplicador = java.lang.Math.pow(10.0, position.toDouble()).toInt()

                tvResultadoMultiplicador.text = multiplicador.toString()
                tvResultadoMultiplicador.setBackgroundColor(obtenerColorHex(position))
                tvResultadoMultiplicador.setTextColor(if (position == 0 || position == 1 || position == 5 || position == 6) Color.WHITE else Color.BLACK)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        radioGroupTolerancia.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbOro) {
                viewColorTolerancia.setBackgroundColor(Color.parseColor("#FFD700"))
            } else if (checkedId == R.id.rbPlata) {
                viewColorTolerancia.setBackgroundColor(Color.parseColor("#C0C0C0"))
            }
        }

        btnCalcular.setOnClickListener {
            val b1 = spinnerBanda1.selectedItemPosition
            val b2 = spinnerBanda2.selectedItemPosition
            val multExp = spinnerMultiplicador.selectedItemPosition

            val baseValue = "$b1$b2".toDouble()
            val multiplicador = java.lang.Math.pow(10.0, multExp.toDouble())
            val valorOhm = baseValue * multiplicador

            val porcentajeTolerancia = if (radioGroupTolerancia.checkedRadioButtonId == R.id.rbOro) {
                0.05
            } else {
                0.10
            }

            val variacion = valorOhm * porcentajeTolerancia
            val valorMaximo = valorOhm + variacion
            val valorMinimo = valorOhm - variacion

            tvValorOhm.text = String.format("%.0f", valorOhm)
            tvValorMaximo.text = String.format("%.0f", valorMaximo)
            tvValorMinimo.text = String.format("%.0f", valorMinimo)
        }
    }
    private fun obtenerColorHex(posicion: Int): Int {
        val colorString = when (posicion) {
            0 -> "#000000" // Negro
            1 -> "#8B4513" // Café
            2 -> "#FF0000" // Rojo
            3 -> "#FFA500" // Naranja
            4 -> "#FFFF00" // Amarillo
            5 -> "#008000" // Verde
            6 -> "#0000FF" // Azul
            7 -> "#EE82EE" // Violeta
            8 -> "#808080" // Gris
            9 -> "#FFFFFF" // Blanco
            else -> "#FFFFFF"
        }
        return Color.parseColor(colorString)
    }
}