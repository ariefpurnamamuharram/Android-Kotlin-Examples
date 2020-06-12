package id.ariefpurnamamuharram.imageencryption

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    companion object {
        private const val INPUT_IMAGE_FILENAME = "original.jpg"
        private const val PERMISSION_REQUEST_CODE = 10
    }

    private var isPermission: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encrypt button
        btn_encrypt.setOnClickListener {
            if (!isPermission) {
                checkPermissions()
            } else {
                Toast.makeText(this, getString(R.string.txt_image_encrypted), Toast.LENGTH_SHORT)
                    .show()
                ImageCrypter.encryptImage(getFile(INPUT_IMAGE_FILENAME), getFile("encrypt.data"))
            }
        }

        // Decrypt button.
        btn_decrypt.setOnClickListener {
            if (!isPermission) {
                checkPermissions()
            } else {
                Toast.makeText(this, getString(R.string.txt_image_decrypted), Toast.LENGTH_SHORT)
                    .show()
                ImageCrypter.decryptImage(getFile("encrypt.data"), getFile("decrypt.jpg"))
            }
        }
    }

    private fun checkPermissions() {
        val permissionReadExternalStorage =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val permissionWriteExternalStorage =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permissionReadExternalStorage != PackageManager.PERMISSION_GRANTED ||
            permissionWriteExternalStorage != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                PERMISSION_REQUEST_CODE
            )
        } else {
            isPermission = true
        }
    }

    private fun getFile(filename: String): File {
        return File(
            Environment.getExternalStorageDirectory().path.plus("/").plus(filename)
        )
    }
}