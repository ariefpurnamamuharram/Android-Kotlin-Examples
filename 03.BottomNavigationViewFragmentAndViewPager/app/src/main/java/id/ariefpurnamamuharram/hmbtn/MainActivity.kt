package id.ariefpurnamamuharram.hmbtn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ariefpurnamamuharram.hmbtn.fragment.girls.GirlsFragment
import id.ariefpurnamamuharram.hmbtn.fragment.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)

        // Setting up BottomNavigationView.
        bottomNav.setOnNavigationItemSelectedListener(mItemSelectedListener)
        bottomNav.selectedItemId = R.id.menu_home
    }

    // Create BottomNavigationView menu listener.
    private val mItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    openFragment(HomeFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_girls -> {
                    openFragment(GirlsFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    // Create openFragment function to inflate fragment.
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}