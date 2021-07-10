package com.example.summerpractice.start_window

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.summerpractice.R
import com.example.summerpractice.all_news_list.FragmentOne

class Frame603 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

         val v = inflater.inflate(R.layout.fragment_frame603, container, false)

        val bt = v.findViewById<Button>(R.id.button)

        bt.setOnClickListener(){
             val fragmentOne = FragmentOne()

             val transaction : FragmentTransaction = parentFragmentManager!!.beginTransaction()
            transaction.replace(R.id.mainLayout,fragmentOne)
            transaction.commit()

          }
     return v
    }

}