package com.emanuel.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val rgGenre = findViewById<RadioGroup>(R.id.rgGenre)
        val rbMale = findViewById<RadioButton>(R.id.rbMale)
        val rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        val chbTerms = findViewById<CheckBox>(R.id.chbTerms)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            // 1. Validaciones
            var name = etName.text.toString()
            var age = etAge.text.toString()
            //var age2 = etAge.text.toString().toInt() // Para usar edad como entero

            if (name.isEmpty()) {
                Toast.makeText(this, "Pon tu nombre",Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Para que no se ejecute nada mas despues
            }
            if (age.isEmpty()) {
                Toast.makeText(this, "Pon tu edad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!chbTerms.isChecked) {
                Toast.makeText(this, "Aceptar términos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var genre = if (rbMale.isChecked)"Masculino" else "Femenino"

            val bundle = Bundle()
            bundle.putString("key_nombre", name)
            bundle.putString("key_edad", age)
            bundle.putString("key_genero", genre)

            val intent = Intent(this, DestinoActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

}