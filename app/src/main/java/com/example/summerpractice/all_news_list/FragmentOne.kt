package com.example.summerpractice.all_news_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice.*
import com.example.summerpractice.spec_news.Fragment_specific_news
import com.example.summerpractice.start_window.Frame603
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment 1", "onActivityCreated")

        creatList()
    }


    fun creatList() {

        var recyclerView: RecyclerView
            val linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            tagsRV.layoutManager = linearLayoutManager
            val tags = ArrayList<MyNews>()


        tags.add(MyNews(resources.getString(R.string.first_news), resources.getString(R.string.first_date), R.drawable.pic1, 1))
        tags.add(MyNews(resources.getString(R.string.sec_news), resources.getString(R.string.sec_date), R.drawable.pic2, 2))
        tags.add(MyNews(resources.getString(R.string.third_news), resources.getString(R.string.third_date), R.drawable.pic3, 2))

        val adapter = TagsAdapter(tags, object : MyOnClickListener {

            override fun onClicked(tag: String) {
                Log.d("FragmentOne", "tag = " + tag)
                val fragmentSpecificNews = Fragment_specific_news()

                val transaction: FragmentTransaction = parentFragmentManager!!.beginTransaction()
                transaction.replace(R.id.mainLayout, fragmentSpecificNews)
                transaction.commit()
            }
        })

            tagsRV.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_one, container, false)

        val back_bt = v.findViewById<ImageButton>(R.id.button_back)

        back_bt.setOnClickListener(){
            val fragmentFrame603 = Frame603()

            val transaction : FragmentTransaction = parentFragmentManager!!.beginTransaction()
            transaction.replace(R.id.mainLayout,fragmentFrame603)
            transaction.commit()

        }
        return v
    }
}