package com.example.fragmentstest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Coordinator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//this function is to avoid tight coupling with BookTitle and BookDescription fragments
    override fun onBookChanged(index: Int) {

/* getting reference to BookDescription fragment, This call returns a Fragment class;
    NOT yet the BookDescription class */
        val frag = fragmentBookDescription

//    casting frag (which is still a Fragment class) to BookDescription
        if (frag is BookDescription) {
            frag.changeDescription(index)
        }
    }
}
