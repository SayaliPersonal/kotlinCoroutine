package com.sayali

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sayali.adapter.ChoiceAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main2.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var arr_choice: Array<String> = arrayOf("co routine & retrofit","co -routine + retrofit + MVVM")
        rv_choice.layoutManager = LinearLayoutManager(this)
        rv_choice.adapter = ChoiceAdapter(arr_choice,this)

    }
}