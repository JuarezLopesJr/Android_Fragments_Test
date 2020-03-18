package com.example.fragmentstest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.book_description.*

class BookDescription : Fragment() {
    lateinit var arrBookDesc: Array<String>
    var bookIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.book_description, container, false)
       //This statement reads the file /app/res/values/books_descriptions.xml and creates an array out of it
        arrBookDesc = resources.getStringArray(R.array.books_descriptions)

        return v
    }

    fun changeDescription(index: Int): Unit {
        bookIndex = index
        txtDescription?.text = arrBookDesc[bookIndex]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookIndex)
    }
}