package com.ddeveloper.starpify

import android.content.Intent
import android.content.SharedPreferences
import  android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
     private lateinit var username : EditText
     private lateinit var password : EditText
     private lateinit var recoverLink : TextView
     private lateinit var registerLink : TextView
     private lateinit var loginButton : Button

     //SHARE PREFERENCES

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //INICIALIZAR VARIABLES
        username = findViewById(R.id.IPuserInput)
        password = findViewById(R.id.IPpassword)
        recoverLink = findViewById(R.id.TVrecoverpswd)
        registerLink = findViewById(R.id.TVregister)
        loginButton =findViewById(R.id.BTlogin)

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)




        //LISTENERS

        recoverLink.setOnClickListener{
            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)
            finish()

            Log.d("LoginActivity","Recuperar contraseña está Ejecutandose")
        }

        registerLink.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()

            Log.d("LoginActivity", "Redireccionamiento a register funcionando")
        }

        loginButton.setOnClickListener{
            if (name_val()){
                checkpassword()
                val intent = Intent(this,ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun name_val(): Boolean{
        val name_check = sharedPreferences.getString("nombre", "")
        val name = username.text.toString().trim()

        if (name != name_check){
            Toast.makeText(this, "El nombre de usuario no es el correcto", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }

    private fun checkpassword(): Boolean{
        val password =password.text.toString().trim()
        val checkPassword = sharedPreferences.getString("contraseña","")

        if (password != checkPassword){
            Toast.makeText(this, "La contraseña no es la correcta", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }












    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "Onstart: Activity Splash está en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SpashActivity", "onPause: Activity Splash estás en primer plano")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SpashActivity", "onResume: Activity Splah está en primer plano")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SpashActivity", "onDestroy: Activity Splah está en primer plano")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SpashActivity", "onStop: Activity Splah está en primer plano")
    }
}