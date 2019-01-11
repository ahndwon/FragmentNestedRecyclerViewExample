package com.example.ahndwon.fragmentrecyclerviewexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ahndwon.fragmentrecyclerviewexample.ItemListAdapter.Companion.VIEW_BASIC
import kotlinx.android.synthetic.main.fragment_basic.view.*


class BasicFragment : Fragment() {
    private var title: String? = null
    private var image: ArrayList<String>? = null

    companion object {
        const val FRAGMENT_TITLE = "fragment_title"
        const val FRAGMENT_IMAGE = "fragment_image"

        fun newInstance(title: String, image: ArrayList<String>) : BasicFragment {
            return BasicFragment().apply {
                val bundle = Bundle()
                bundle.putString(FRAGMENT_TITLE, title)
                bundle.putStringArrayList(FRAGMENT_IMAGE, image)
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_basic, container, false)

        val title = arguments?.getString(FRAGMENT_TITLE)
        val image= arguments?.getStringArrayList(FRAGMENT_IMAGE) ?: ArrayList<String>()

        view.fragmentTitle.text = title

        val adapter = ItemListAdapter(VIEW_BASIC)
        adapter.items = image
        view.recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

        return view
    }


}
