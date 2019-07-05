package com.daemonvision.activityfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.daemonvision.activityfragments.fragments.FirstFragment
import com.daemonvision.activityfragments.fragments.SecondFragment
import com.daemonvision.activityfragments.model.FirstContent
import com.daemonvision.activityfragments.model.SecondContent

class MainActivity : AppCompatActivity(),
    FirstFragment.OnListFragmentInteractionListener,
    SecondFragment.OnListFragmentInteractionListener {

    private lateinit var data: TextView

    override fun onListFragmentInteraction(item: SecondContent.DummyItem?) {
        Log.e("Second",item!!.id)
        data.text = "fdg"
        val fragment1 = supportFragmentManager
        fragment1.beginTransaction().replace(R.id.fragment1,FirstFragment()).commit()
    }

    override fun onListFragmentInteraction(item: FirstContent.DummyItem?) {
        Log.e("Data",item!!.id)
        SecondContent.ITEMS.add(SecondContent.DummyItem("hj","hg","kj"))
        val fragment2 = supportFragmentManager
        fragment2.beginTransaction().replace(R.id.fragment2,SecondFragment()).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = findViewById(R.id.data)
        val fragment = supportFragmentManager
        fragment.beginTransaction().replace(R.id.fragment1,FirstFragment()).commit()

        val fragment2 = supportFragmentManager
        fragment2.beginTransaction().replace(R.id.fragment2,SecondFragment()).commit()
    }
}
