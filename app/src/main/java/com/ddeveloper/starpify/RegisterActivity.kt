package com.ddeveloper.starpify

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity :AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextTel: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextRpPassword: EditText
    private lateinit var checkBoxterms: CheckBox
    private lateinit var buttonRegister: Button
    private lateinit var loginLink: TextView

    //VARIABLE PARA GUARDAR INFORMACION
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_register)

        Log.d("RegisterActivity", "onCreate: Activity Registro iniciando")


        //INICIALIZAR VARIABLES
        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)

        //Inicializar variables de vistas
        editTextName = findViewById(R.id.ETName_user)
        editTextLastName = findViewById(R.id.ETLastName_user)
        editTextEmail = findViewById(R.id.ETemail_user)
        editTextTel = findViewById(R.id.ETtel_user)
        editTextPassword = findViewById(R.id.IPpassword_user)
        editTextRpPassword = findViewById(R.id.IPpassword_user_repeat)
        checkBoxterms = findViewById(R.id.CBterms)
        buttonRegister = findViewById(R.id.BTRegister)
        loginLink = findViewById(R.id.TVlogin_link)

        //Configuracion Listener de boton registrar e iniciar sesión

        loginLink.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
            finish()
        }

        buttonRegister.setOnClickListener{
            if (validateFields()){
                //metodo de guardar datos
                saveUserData()
                //redireccionamiento
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }


    }



     private fun validateFields():Boolean {
         val name_ver = editTextName.text.toString().trim()
         val lastname_ver =editTextLastName.text.toString().trim()
         val email_ver = editTextEmail.text.toString().trim()
         val tel_ver = editTextTel.text.toString().trim()
         val pass_ver = editTextPassword.text.toString().trim()
         val pass_rpt_ver = editTextRpPassword.text.toString().trim()
         val check_ver = checkBoxterms.isChecked


         if (name_ver.isEmpty()) {
            //mostrar mensaje
             Toast.makeText(this, "El campo nombre es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(lastname_ver.isEmpty()){
             Toast.makeText(this, "El campo Apellidos es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(email_ver.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email_ver).matches()){
             Toast.makeText(this, "El campo Email es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(tel_ver.isEmpty()){
             Toast.makeText(this, "El campo Teléfono es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(pass_ver.isEmpty()){
             Toast.makeText(this, "El campo Contraseña es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(pass_rpt_ver.isEmpty()){
             Toast.makeText(this, "El campo Repetir contraseña es obligatorio", Toast.LENGTH_SHORT).show()
             return false
         }
         if(pass_ver != pass_rpt_ver){
            Toast.makeText(this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
             return false
         }
         if(!check_ver){
             Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
             return false
         }



         return true
     }

    private fun saveUserData(){
        val editor = sharedPreferences.edit()
        editor.putString("nombre", editTextName.text.toString().trim())
        editor.putString("apellidos", editTextLastName.text.toString().trim())
        editor.putString("email", editTextEmail.text.toString().trim())
        editor.putString("telefono", editTextTel.text.toString().trim())
        editor.putString("contraseña", editTextPassword.text.toString().trim())
        editor.putString("repetir_contraseña", editTextRpPassword.toString().trim())
        editor.apply()

        Log.d("Register Activity", "saveUserData: Datos del usuario guardados")
        //Mensaje de registro exitoso
        Toast.makeText(this,"Te has registrado exitosamente", Toast.LENGTH_SHORT).show()
    }
}