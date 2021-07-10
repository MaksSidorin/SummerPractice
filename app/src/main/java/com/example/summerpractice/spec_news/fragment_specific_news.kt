package com.example.summerpractice.spec_news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice.all_news_list.FragmentOne
import com.example.summerpractice.R
import kotlinx.android.synthetic.main.fragment_specific_news.*

class Fragment_specific_news : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment spec News", "onActivityCreated")
        SpecCreatList()
    }

    fun SpecCreatList() {

        var recyclerView: RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        tagsSpecRV.layoutManager = linearLayoutManager
        val tags = ArrayList<SpecNewsType>()

        tags.add(ImageType(R.drawable.pic4))
        tags.add(HeaderType(resources.getString(R.string.bols_header)))
        tags.add(GreyTextType(resources.getString(R.string.grey_text)))
           tags.add(BlackTextType(resources.getString(R.string.black_text)))
           tags.add(BulletedTextType(resources.getString(R.string.bulleted_list)))
           tags.add(ItalicTextType(resources.getString(R.string.italic_text)))
                      tags.add(TwoButtonsType(1, 2, resources.getString(R.string.like_text),
                              resources.getString(R.string.dislike_text)))

        val adapter = specNewsAdapter(tags)

        tagsSpecRV.adapter = adapter
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.fragment_specific_news, container, false)

        val back_bt2 = v.findViewById<ImageButton>(R.id.button_back2)

        back_bt2.setOnClickListener(){
            val fragmentOne = FragmentOne()

            val transaction : FragmentTransaction = parentFragmentManager!!.beginTransaction()
            transaction.replace(R.id.mainLayout,fragmentOne)
            transaction.commit()

        }

        return v
    }
}