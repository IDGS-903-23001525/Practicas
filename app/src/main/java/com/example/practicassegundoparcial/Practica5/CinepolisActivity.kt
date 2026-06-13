package com.example.practicassegundoparcial.Practica5

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicassegundoparcial.R

class CinepolisActivity : AppCompatActivity() {

    private val PRECIO_BOLETA = 12.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCantidadCompradores = findViewById<EditText>(R.id.etCantidadCompradores)
        val etCantidadBoletas = findViewById<EditText>(R.id.etCantidadBoletas)
        val rgTarjetaCineco = findViewById<RadioGroup>(R.id.rgTarjetaCineco)
        val rbSiCineco = findViewById<RadioButton>(R.id.rbSiCineco)
        val tvValorPagar = findViewById<TextView>(R.id.tvValorPagar)
        val btnProcesar = findViewById<Button>(R.id.btnProcesar)
        val btnSalir = findViewById<Button>(R.id.btnSalir)

        btnProcesar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val txtCompradores = etCantidadCompradores.text.toString()
            val txtBoletas = etCantidadBoletas.text.toString()

            if (nombre.isEmpty() || txtCompradores.isEmpty() || txtBoletas.isEmpty()) {
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cantCompradores = txtCompradores.toInt()
            val cantBoletas = txtBoletas.toInt()

            if (cantCompradores <= 0 || cantBoletas <= 0) {
                Toast.makeText(this, "Las cantidades deben ser mayores a cero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val maximoPermitido = cantCompradores * 7
            if (cantBoletas > maximoPermitido) {
                Toast.makeText(
                    this,
                    "No se permite comprar más de 7 boletas por persona (Máx para esta compra: $maximoPermitido)",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val valorBase = cantBoletas * PRECIO_BOLETA
            var descuentoBoletas = 0.0

            if (cantBoletas > 5) {
                descuentoBoletas = 0.15
            } else if (cantBoletas in 3..5) {
                descuentoBoletas = 0.10
            } else {
                descuentoBoletas = 0.00
            }

            val valorConPrimerDescuento = valorBase - (valorBase * descuentoBoletas)

            var descuentoCineco = 0.0
            if (rbSiCineco.isChecked) {
                descuentoCineco = 0.10
            }

            val valorFinal = valorConPrimerDescuento - (valorConPrimerDescuento * descuentoCineco)

            tvValorPagar.text = String.format("$%,.2f", valorFinal)
            Toast.makeText(this, "Procesado para: $nombre", Toast.LENGTH_SHORT).show()
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }
}