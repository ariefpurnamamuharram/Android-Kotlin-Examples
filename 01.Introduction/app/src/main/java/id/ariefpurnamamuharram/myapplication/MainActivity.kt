package id.ariefpurnamamuharram.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart: Button

    // Main function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get button instance.
        btnStart = findViewById(R.id.btn_start)

        // Call buttonListener function.
        buttonListener()
    }

    // Create buttonListener function.
    private fun buttonListener() {
        btnStart.setOnClickListener {
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
        }
    }
}
