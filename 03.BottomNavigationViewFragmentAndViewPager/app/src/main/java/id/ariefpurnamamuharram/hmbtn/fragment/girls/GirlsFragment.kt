package id.ariefpurnamamuharram.hmbtn.fragment.girls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import id.ariefpurnamamuharram.hmbtn.R

class GirlsFragment : Fragment() {
    private lateinit var root: View
    private lateinit var vpGirls: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get components instance.
        root = inflater.inflate(R.layout.fragment_girls, container, false)
        vpGirls = root.findViewById(R.id.vp_girls)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Get all girl characters.
        val girls = listOf(
            Girl(getString(R.string.txt_character_karen), R.drawable.ic_character_karen),
            Girl(getString(R.string.txt_character_ann), R.drawable.ic_character_ann),
            Girl(getString(R.string.txt_character_popuri), R.drawable.ic_character_popuri),
            Girl(getString(R.string.txt_character_elli), R.drawable.ic_character_elli),
            Girl(getString(R.string.txt_character_mary), R.drawable.ic_character_mary)
        )

        // Setting up the ViewPager.
        vpGirls.adapter = fragmentManager?.let { GirlsAdapter(it, girls) }
    }

    companion object {
        // Create fragment instance.
        fun newInstance(): GirlsFragment = GirlsFragment()
    }
}