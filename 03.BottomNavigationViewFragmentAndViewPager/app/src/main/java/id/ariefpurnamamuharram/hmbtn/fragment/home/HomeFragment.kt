package id.ariefpurnamamuharram.hmbtn.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ariefpurnamamuharram.hmbtn.R

class HomeFragment : Fragment() {
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    companion object {
        // Create fragment instance.
        fun newInstance(): HomeFragment =
            HomeFragment()
    }
}