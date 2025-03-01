package com.ddeveloper.starpify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    //oncreate funciona de manera visual en desarrollo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Log.d("SplashActivity","onCreate: Iniciando Activity Splash")

        //COnfigurar el temposizador de redireccion a Home Activity
        //LOOPER TRAE EL MODULO PRINCIPAL
        Handler(Looper.getMainLooper()).postDelayed({
            //donde estoy y para donde voy
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)

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