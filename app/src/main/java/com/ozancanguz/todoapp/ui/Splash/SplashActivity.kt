package com.ozancanguz.todoapp.ui.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
//splash ekran için bir Thread oluşturuyoruz
        val background = object : Thread() {
            override fun run() {
                try {
                    //threaad 7 sn yani 7000 ms uyusun
                    Thread.sleep(7000)
                    //intent ile splash ekranından sonra MainActivity ekranı açılsın diyoruz
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}