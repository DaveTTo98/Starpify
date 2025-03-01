package com.ddeveloper.starpify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {

    //variables
    private lateinit var HomeButton: Button
    private lateinit var RegisterLink: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("HomeActivity", "onCreate: Activity Home iniciando")

        //INICIAR VARIABLE DE VISTAS
        HomeButton = findViewById(R.id.BTstart)
        RegisterLink = findViewById(R.id.TVregister_home)

        //CONFIGURACION DEL LISTENER DE LOGIN Y REGISTER
        //REDIRECCION A LOGINACTIVITY
        HomeButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

            Log.d("HomeActivity", "HomeButton: Boton ejecutandose")
        }

        //REDIRECCION A REGISTERACTIVITY
        RegisterLink.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

    }






















    override fun onStart() {
        super.onStart()
        Log.d("HomeActivity", "Onstart: Activity Home está en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeActivity", "onPause: Activity Home está en primer plano")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeActivity", "onResume: Activity Home está en primer plano")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "onDestroy: Activity Home está en primer plano")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeActivity", "onStop: Activity Home está en primer plano")
    }



}