package com.ddeveloper.starpify

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ProfileActivity: AppCompatActivity()  {
    //VARIABLES
    private lateinit var showName : TextView
    private lateinit var showLastName : TextView
    private lateinit var showEmail : TextView
    private lateinit var showTel : TextView

    //SHAREDPREFERENCES

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        Log.d("profile Activity", "Activity rofile ejecutandose")

        //OBTENER SHARED PREFERENCES

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)

        //INICIAR VARIABLES

        showName = findViewById(R.id.TVshow_profile_name)
        showLastName = findViewById(R.id.TVshow_profile_lastname)
        showEmail = findViewById(R.id.TVshow_profile_email)
        showTel = findViewById(R.id.TVshow_profile_tel)

        //metodos
        mostrarNombre()
        mostrarApellido()
        mostrarEmail()
        mostrarTel()

    }

    private fun mostrarNombre(){
        showName.text = sharedPreferences.getString("nombre", "")
    }
    private fun mostrarApellido(){
        showLastName.text = sharedPreferences.getString("apellidos", "")
    }
    private fun mostrarEmail(){
        showEmail.text = sharedPreferences.getString("email", "")
    }
    private fun mostrarTel(){
        showTel.text = sharedPreferences.getString("telefono", "")
    }

}