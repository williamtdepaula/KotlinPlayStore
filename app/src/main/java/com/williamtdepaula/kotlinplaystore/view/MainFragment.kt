package com.williamtdepaula.kotlinplaystore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.williamtdepaula.kotlinplaystore.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    val listTest : List<String> = arrayListOf<String>("Teste", "Super", "Kotlin", "Flutter", "Dart")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.frag_view_page.adapter = FragmentTypeAdapter(this)

        TabLayoutMediator(view.tab_layout, view.frag_view_page) { tab, position ->
            tab.text = listTest[position]
        }.attach()
    }

}


class FragmentTypeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return Fragment()
    }

}