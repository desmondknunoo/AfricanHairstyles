package com.d.g.africanhairstyles

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.afollestad.materialdialogs.MaterialDialog

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var cardButton: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    
       Handler(Looper.getMainLooper()).postDelayed({
            // Your Code
            if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()}
        }, 3000)
    }

}
