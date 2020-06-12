package id.ariefpurnamamuharram.imageencryption

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    companion object {
        private const val INPUT_IMAGE_FILENAME = "original.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encrypt button
        btn_encrypt.setOnClickListener {
            ImageCrypter.encryptImage(getFile(INPUT_IMAGE_FILENAME), getFile("encrypt.data"))
        }

        // Decrypt button.
        btn_decrypt.setOnClickListener {
            ImageCrypter.decryptImage(getFile("encrypt.data"), getFile("decrypt.jpg"))
        }
    }

    private fun getFile(filename: String): File {
        return File(
            Environment.getExternalStorageDirectory().path.plus("/").plus(filename)
        )
    }
}