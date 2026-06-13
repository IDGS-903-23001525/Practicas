package com.example.practicassegundoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicassegundoparcial.Practica1.Practica1Activity
import com.example.practicassegundoparcial.Practica2.Practica2Activity
import com.example.practicassegundoparcial.Practica3.Practica3Activity
import com.example.practicassegundoparcial.Practica4.ResistenciasActivity
import com.example.practicassegundoparcial.Practica5.CinepolisActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnP1 = findViewById<Button>(R.id.btn1)
        val btnP2 = findViewById<Button>(R.id.btn2)
        val btnP3 = findViewById<Button>(R.id.btn3)
        val btnP4 = findViewById<Button>(R.id.btn4)
        val btnP5 = findViewById<Button>(R.id.btn5)


        btnP1.setOnClickListener { navegateToPractica1() }
        btnP2.setOnClickListener { navegateToPractica2() }
        btnP3.setOnClickListener { navegateToPractica3() }
        btnP4.setOnClickListener { navegateToPractica4() }
        btnP5.setOnClickListener { navegateToPractica5() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navegateToPractica1() {
        val intent = Intent(this, Practica1Activity::class.java)
        startActivity(intent)
    }

    fun navegateToPractica2() {
        val intent = Intent(this, Practica2Activity::class.java)
        startActivity(intent)
    }

    fun navegateToPractica3() {
        val intent = Intent(this, Practica3Activity::class.java)
        startActivity(intent)
    }

    fun navegateToPractica4() {
        val intent = Intent(this, ResistenciasActivity::class.java)
        startActivity(intent)
    }

    fun navegateToPractica5() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }
}