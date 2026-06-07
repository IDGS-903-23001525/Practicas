package com.example.practicassegundoparcial.Practica3

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicassegundoparcial.R

class Practica3Activity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etApaterno: EditText
    private lateinit var etAmaterno: EditText
    private lateinit var etDia: EditText
    private lateinit var etMes: EditText
    private lateinit var etAnio: EditText
    private lateinit var rgSexo: RadioGroup
    private lateinit var btnImprimir: Button

    private lateinit var tvResNombre: TextView
    private lateinit var tvResEdad: TextView
    private lateinit var tvResSigno: TextView
    private lateinit var imgSigno: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica3)

        etNombre = findViewById(R.id.etNombre)
        etApaterno = findViewById(R.id.etApaterno)
        etAmaterno = findViewById(R.id.etAmaterno)
        etDia = findViewById(R.id.etDia)
        etMes = findViewById(R.id.etMes)
        etAnio = findViewById(R.id.etAnio)
        rgSexo = findViewById(R.id.rgSexo)
        btnImprimir = findViewById(R.id.btnImprimir)

        tvResNombre = findViewById(R.id.tvResultadoNombre)
        tvResEdad = findViewById(R.id.tvResultadoEdad)
        tvResSigno = findViewById(R.id.tvResultadoSigno)
        imgSigno = findViewById(R.id.imgSigno)

        btnImprimir.setOnClickListener { mostrarInformacion() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun mostrarInformacion() {
        val nombre = etNombre.text.toString()
        val apaterno = etApaterno.text.toString()
        val amaterno = etAmaterno.text.toString()
        val sAnio = etAnio.text.toString()

        val anioNacimiento = sAnio.toInt()

        val edad = 2026 - anioNacimiento

        tvResNombre.text = "Hola $nombre $apaterno $amaterno"
        tvResEdad.text = "Tienes $edad años"
        tvResSigno.text = "tu signo zodiacal"

        val residuo = anioNacimiento % 12
        var nombreSigno = ""
        var idImagen = 0

        when (residuo) {
            0 -> { nombreSigno = "Mono"; idImagen = R.drawable.mono }
            1 -> { nombreSigno = "Gallo"; idImagen = R.drawable.gallo }
            2 -> { nombreSigno = "Perro"; idImagen = R.drawable.perro }
            3 -> { nombreSigno = "Cerdo"; idImagen = R.drawable.cerdo }
            4 -> { nombreSigno = "Rata"; idImagen = R.drawable.rata }
            5 -> { nombreSigno = "Buey"; idImagen = R.drawable.buey }
            6 -> { nombreSigno = "Tigre"; idImagen = R.drawable.tigre }
            7 -> { nombreSigno = "Conejo"; idImagen = R.drawable.conejo }
            8 -> { nombreSigno = "Dragón"; idImagen = R.drawable.dragon }
            9 -> { nombreSigno = "Serpiente"; idImagen = R.drawable.serpiente }
            10 -> { nombreSigno = "Caballo"; idImagen = R.drawable.caballo }
            11 -> { nombreSigno = "Cabra"; idImagen = R.drawable.cabra }
        }

        tvResSigno.text = "tu signo zodiacal\nEs $nombreSigno"

        if (idImagen != 0) {
            imgSigno.setImageResource(idImagen)
            imgSigno.visibility = ImageView.VISIBLE
        }
    }
}