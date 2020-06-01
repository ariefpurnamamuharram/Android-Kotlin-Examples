package id.ariefpurnamamuharram.hmbtn.fragment.girls

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GirlsAdapter(fm: FragmentManager, private val characters: List<Girl>) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        // Load item pager.
        return GirlPagerFragment.newInstance(characters[position])
    }

    override fun getCount(): Int {
        return characters.size
    }

}