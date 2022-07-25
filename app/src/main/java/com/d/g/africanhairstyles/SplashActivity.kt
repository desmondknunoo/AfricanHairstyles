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

        cardButton = findViewById(R.id.shell)
        cardButton!!.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW)
            //webIntent.data = Uri.parse("https://www.google.com/maps/search/puma+fuel+station+near+me")
            webIntent.data = Uri.parse("http://maps.apple.com/?q=shell+station+near+me")

            try {
                startActivity(Intent.createChooser(webIntent, "Complete action using"))

            } catch (ex: android.content.ActivityNotFoundException) {
                noClientDialog()

            }
        }
       /* Handler(Looper.getMainLooper()).postDelayed({
            // Your Code
            if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()}
        }, 3000)*/
    }

    public override fun onDestroy() {

        super.onDestroy()
    }
    private fun noClientDialog(){
        val dialog = MaterialDialog.Builder(this).title("No client available")
            .positiveText("OK")
            .onPositive { dialog, _ -> dialog.dismiss() }.build()

        dialog.show()
    }

}