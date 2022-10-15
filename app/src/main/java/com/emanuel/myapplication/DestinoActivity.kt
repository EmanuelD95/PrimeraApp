package com.emanuel.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DestinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destino)
        val bundle = intent.extras

        val nombres = bundle!!.getString("key_nombre")

        Toast.makeText(this, nombres, Toast.LENGTH_SHORT).show()
    }
}