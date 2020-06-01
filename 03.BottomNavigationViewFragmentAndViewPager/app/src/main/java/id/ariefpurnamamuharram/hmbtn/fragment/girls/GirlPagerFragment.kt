package id.ariefpurnamamuharram.hmbtn.fragment.girls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import id.ariefpurnamamuharram.hmbtn.R

class GirlPagerFragment(private val girl: Girl) : Fragment() {
    private lateinit var root: View
    private lateinit var ivCharacterImage: ImageView
    private lateinit var tvCharacterName: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Load component instances.
        root = inflater.inflate(R.layout.item_pager_girl, container, false)
        ivCharacterImage = root.findViewById(R.id.iv_hmbtn_character)
        tvCharacterName = root.findViewById(R.id.tv_character_name)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Load character image.
        Picasso.get().load(girl.characterImage).into(ivCharacterImage)

        // Set character name.
        tvCharacterName.text = girl.characterName
    }

    companion object {
        // Create fragment instance.
        fun newInstance(girl: Girl): GirlPagerFragment = GirlPagerFragment(girl)
    }
}