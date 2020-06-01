package id.ariefpurnamamuharram.hmbtn.girls

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ariefpurnamamuharram.hmbtn.R

class GirlsAdapter(private val girls: List<Girl>) : RecyclerView.Adapter<GirlsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GirlsViewHolder {
        return GirlsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_girl, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return girls.size
    }

    override fun onBindViewHolder(holder: GirlsViewHolder, position: Int) {
        holder.bindItem(girls[position])
    }
}

class GirlsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val root = view
    private val tvCharacterName = view.findViewById<TextView>(R.id.tv_character_name)
    private val ivCharacterImage = view.findViewById<ImageView>(R.id.iv_girl)

    fun bindItem(item: Girl) {
        tvCharacterName.text = item.characterName
        Picasso.get().load(item.characterImage).into(ivCharacterImage)

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, item.characterName, Toast.LENGTH_SHORT).show()
        }
    }
}