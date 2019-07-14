package com.example.ahndwon.fragmentrecyclerviewexample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val adapter = FragmentListAdapter(childFragmentManager)

        adapter.fragments = listOf(
            BasicFragment.newInstance("FIRST", Dummies.imageList),
            BasicFragment.newInstance("SECOND", Dummies.imageList),
            BasicFragment.newInstance("THIRD", Dummies.imageList),
            BasicFragment.newInstance("FOURTH", Dummies.imageList),
            BasicFragment.newInstance("FIFTH", Dummies.imageList)
        )

        view.homeRecyclerView.adapter = adapter
        view.homeRecyclerView.layoutManager = LinearLayoutManager(view.context)

        return view
    }


}
