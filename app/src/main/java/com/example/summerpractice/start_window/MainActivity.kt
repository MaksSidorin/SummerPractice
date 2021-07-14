package com.example.summerpractice.start_window

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.support.v4.app.Fragment
//import androidx.core.app.`import android`.support.v4.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.summerpractice.R
import android.media.session.MediaController;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // добавление фрагментов
        val frame603 = Frame603()
        val fm : FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.mainLayout,frame603).commit()

    }
}

