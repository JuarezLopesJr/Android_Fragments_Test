package com.example.fragmentstest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.books_titles.*

// i need to implement View.OnClickListener interface to use setOnClickListener(this)
class BookTitle : Fragment(), View.OnClickListener {
    /* can't refer to any UI element inside this method, because the XML resource is not inflated yet
    *   The UI elements MUST BE referenced inside the onViewCreated() method
    */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.books_titles, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // "this" means the listener object for the radio button is an instance of BookTitle class
        book_kotlin.setOnClickListener(this)
        book_android.setOnClickListener(this)
        book_ktor.setOnClickListener(this)
        //super.onViewCreated(view, savedInstanceState)
    }

    // overriding from View.OnClickListener interface
    override fun onClick(v: View?) {
        var index = 0
        when (v?.id) {
            R.id.book_kotlin -> {
                index = 0
            }
            R.id.book_android -> {
                index = 1
            }
            R.id.book_ktor -> {
                index = 2
            }
        }
/* get a reference to the currently running Activity, which is MainActivity
    it just returns the supertype of MainActivity (FragmentActivity) */
        val activity = activity
        if (activity is Coordinator) {
            activity.onBookChanged(index)
        }
    }
}