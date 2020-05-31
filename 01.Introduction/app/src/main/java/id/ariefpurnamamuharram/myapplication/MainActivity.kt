package id.ariefpurnamamuharram.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ariefpurnamamuharram.myapplication.introduction.IntroductionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imgHMBTN: ImageView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get components instance.
        imgHMBTN = findViewById(R.id.img_hmbtn)
        btnStart = findViewById(R.id.btn_start)

        // Call buttonListener function.
        buttonListener()
    }

    // Create buttonListener function.
    private fun buttonListener() {
        // btnStart click listener.
        btnStart.setOnClickListener {
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
        }

        // imgHMBTN click listener.
        imgHMBTN.setOnClickListener {
            Toast.makeText(this, getString(R.string.txt_hmbtn), Toast.LENGTH_SHORT).show()
        }
    }
}
