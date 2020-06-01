package id.ariefpurnamamuharram.hmbtn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import id.ariefpurnamamuharram.hmbtn.characters.CharactersActivity
import id.ariefpurnamamuharram.hmbtn.girls.GirlsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnCharacters: Button
    private lateinit var btnGirls: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCharacters = findViewById(R.id.btn_characters)
        btnGirls = findViewById(R.id.btn_girls)

        buttonListener()
    }

    private fun buttonListener() {
        btnCharacters.setOnClickListener {
            val intent = Intent(this, CharactersActivity::class.java)
            startActivity(intent)
        }

        btnGirls.setOnClickListener {
            val intent = Intent(this, GirlsActivity::class.java)
            startActivity(intent)
        }
    }
}