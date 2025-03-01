package com.ddeveloper.starpify

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoveryActivity: AppCompatActivity() {
    //variables
    private lateinit var editEmail : EditText
    private lateinit var sendButton : Button
    //sharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recoverpassword)




        //Logd

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)

        //INICIALIZAR VARIABLES GENERALES
        editEmail = findViewById(R.id.ETEmail_recovery)
        sendButton = findViewById(R.id.BTsend_recovery_email)

        //Configurar boton

        sendButton.setOnClickListener{
            if(valEmail()){
                checkEmail()
            }
        }
    }

    private fun valEmail(): Boolean{
        val email =  editEmail.text.toString().trim()
        //validar formato de correo electronico
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //MOSTRAR MENSAJE DE ERROR
            Toast.makeText(this, "EL correo es obligatorio", Toast.LENGTH_SHORT).show()
            return false

        }
        return true

        //LOG D
    }

    private fun checkEmail(){
        val email =  editEmail.text.toString().trim()
        val email_registered = sharedPreferences.getString("email", "")

        if(email == email_registered){
            //Mensaje de exito
            Toast.makeText(this, "Revisa tu bandeja de entrada", Toast.LENGTH_SHORT).show()
            //Log

            //SI se valida el correo, se dirige a la activity anterior despues de 1.5s (puede variar)
            sendButton.postDelayed({
                finish()
            },1500)
        }else{
            Toast.makeText(this,"Algo salió mal, revisa la información y vuelve a intentarlo", Toast.LENGTH_SHORT).show()
            //LOG d
        }
    }



}