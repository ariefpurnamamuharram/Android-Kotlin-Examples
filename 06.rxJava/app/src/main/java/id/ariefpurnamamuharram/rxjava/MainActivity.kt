package id.ariefpurnamamuharram.rxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRxJava.setOnClickListener {
            RxJavaBasicDialogFragment.newInstance().show(supportFragmentManager, "RxJava")
        }

        btnRxKotlin.setOnClickListener {
            RxKotlinBasicDialogFragment.newInstance().show(supportFragmentManager, "RxKotlin")
        }
    }
}