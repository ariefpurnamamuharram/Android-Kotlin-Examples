package id.ariefpurnamamuharram.imageencryption

import android.annotation.SuppressLint
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.CipherOutputStream
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class ImageCrypter() {
    companion object {
        // Algorithm.
        private const val ALGORITHM = "AES"

        // Encrypt and decrypt function.
        fun encryptImage(originalFilePath: File?, destinationFilePath: File?) =
            ImageCrypter().encryptImage(originalFilePath, destinationFilePath)

        fun decryptImage(originalFilePath: File?, destinationFilePath: File?) =
            ImageCrypter().decryptImage(originalFilePath, destinationFilePath)
    }

    // Encryption variables.
    private var key: SecretKey? = null

    // 128-bit key.
    // Define your key here.
    private var salt = "A8768CC5BEAA6093"

    init {
        key = getKey()
    }

    // Get key.
    private fun getKey(): SecretKey? {
        var secretKey: SecretKey? = null

        try {
            secretKey = SecretKeySpec(salt.toBytes(), ALGORITHM)
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return secretKey
    }

    // String to ByteArray conversion.
    private fun String.toBytes(): ByteArray {
        return this.toByteArray(Charsets.UTF_8)
    }

    // Encryption function.
    @SuppressLint("GetInstance")
    private fun encryptImage(originalFilePath: File?, destinationFilePath: File?) {
        try {
            val fis = FileInputStream(originalFilePath.toString())
            val aes = Cipher.getInstance(ALGORITHM)
            aes.init(Cipher.ENCRYPT_MODE, key)
            val fs = FileOutputStream(File(destinationFilePath.toString()))
            val out = CipherOutputStream(fs, aes)
            out.write(fis.readBytes())
            out.flush()
            out.close()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }

    // Decryption function.
    @SuppressLint("GetInstance")
    private fun decryptImage(originalFilePath: File?, destinationFilePath: File?) {
        try {
            val fis = FileInputStream(originalFilePath.toString())
            val aes = Cipher.getInstance(ALGORITHM)
            aes.init(Cipher.DECRYPT_MODE, key)
            val fs = FileOutputStream(File(destinationFilePath.toString()))
            val out = CipherOutputStream(fs, aes)
            out.write(fis.readBytes())
            out.flush()
            out.close()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}