package com.example.ahndwon.fragmentrecyclerviewexample


import android.os.Bundle
import android.util.Log
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

        val images = arrayListOf(
                "http://www.koreadaily.com/_data/article_img/2012/11/01/205001638.jpg",
                "https://encrypted-tbn0.gstatic.com/images?" +
                        "q=tbn:ANd9GcTm_FFgaK1uOeGKex6usvDwauT38u2PzdzqVQpWKkEs6foPIFepSw",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTm_" +
                        "FFgaK1uOeGKex6usvDwauT38u2PzdzqVQpWKkEs6foPIFepSw",
                "http://img.cgv.co.kr/Movie/Thumbnail/StillCu" +
                        "t/000076/76655/76655101760_727.jpg" ,
                "http://www.koreadaily.com/_data/article_img/2012/11/01/205001638.jpg"

                )


        adapter.fragments = listOf(
            TopFragment.newInstance("Top", images),
            BasicFragment.newInstance("FIRST", images),
            BasicFragment.newInstance("SECOND", images),
            BasicFragment.newInstance("THIRD", images),
            BasicFragment.newInstance("FOURTH", images),
            BasicFragment.newInstance("FIFTH", images)
        )

        view.homeRecyclerView.adapter = adapter
        view.homeRecyclerView.layoutManager = LinearLayoutManager(view.context)

        return view
    }


}
