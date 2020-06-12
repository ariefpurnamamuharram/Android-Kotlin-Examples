package id.ariefpurnamamuharram.imageencryption

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val original = File(
            Environment.getExternalStorageDirectory().path.plus("/").plus("original.jpg")
        )

        val destination = File(
            Environment.getExternalStorageDirectory().path.plus("/").plus("destination.jpg")
        )

        btn_encrypt.setOnClickListener {
            ImageCrypter.encryptImage(original, destination)
        }

        btn_decrypt.setOnClickListener {
            ImageCrypter.decryptImage(destination, original)
        }
    }
}