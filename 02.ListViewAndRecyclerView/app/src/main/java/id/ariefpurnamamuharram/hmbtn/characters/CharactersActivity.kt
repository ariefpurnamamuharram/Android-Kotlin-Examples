package id.ariefpurnamamuharram.hmbtn.characters

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ariefpurnamamuharram.hmbtn.R

class CharactersActivity : AppCompatActivity() {
    private lateinit var lvCharacters: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        lvCharacters = findViewById(R.id.lv_characters)

        // Create list of data.
        val characters = arrayListOf(
            "Ann", "Anna", "Aqua", "Barley", "Basil", "Bold", "Carter", "Chef", "Cliff",
            "Doctor", "Doug", "Duke", "Ellen", "Elli", "Gotz", "Gourmet", "Gray", "Greg",
            "Harris", "Harvest Goddess", "Harvest Spirites", "Hoggy", "Jeff", "Kai", "Kano",
            "Kappa", "Karen", "Lillia", "Louis", "Manna", "Mary", "May", "Nappy", "Popuri",
            "Rick", "Saibara", "Sasha", "Staid", "Stu", "Thomas", "Timid", "Won", "Zack"
        )

        // Create ArrayAdapter.
        val charactersAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, characters)

        // Setting up ListView.
        lvCharacters.apply {
            adapter = charactersAdapter
            setOnItemClickListener { _, _, i, _ ->
                Toast.makeText(this@CharactersActivity, characters[i], Toast.LENGTH_SHORT).show()
            }
        }
    }
}