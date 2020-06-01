package id.ariefpurnamamuharram.hmbtn.girls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ariefpurnamamuharram.hmbtn.R

class GirlsActivity : AppCompatActivity() {
    private lateinit var rvGirls: RecyclerView
    private lateinit var rvGirlsAdapter: GirlsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_girls)

        rvGirls = findViewById(R.id.rv_girls)

        // Create dataset.
        val girls = listOf<Girl>(
            Girl("Karen", R.drawable.ic_karen),
            Girl("Ann", R.drawable.ic_ann),
            Girl("Popuri", R.drawable.ic_popuri),
            Girl("Elli", R.drawable.ic_elli),
            Girl("Mary", R.drawable.ic_mary)
        )

        // Create RecyclerView adapter.
        rvGirlsAdapter = GirlsAdapter(girls)

        // Setting up rvGirls.
        rvGirls.apply {
            layoutManager = LinearLayoutManager(this@GirlsActivity)
            adapter = rvGirlsAdapter
        }
    }
}