package com.sayali

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sayali.adapter.AlbumAdapter
import com.sayali.data.AlbumData
import com.sayali.data.AlbumDataItem
import com.sayali.network.APIClient
import com.sayali.network.AlbumService
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.rv_container.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var albumService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
         albumService = APIClient.getRetrofitInstance().create(AlbumService::class.java)
        btn.text = intent.getStringExtra("choice_name")



        btn.setOnClickListener({
            val x: Int? = intent.getIntExtra("choice_no",-1)
            when (x) {
                0 -> {
                    Toast.makeText(applicationContext, "no mvvm", Toast.LENGTH_SHORT).show()
                    coroutineRetrofit();
                }
                1 -> {
                    Toast.makeText(applicationContext, "with mvvm", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun coroutineRetrofit() {
        GlobalScope.launch {
            val call: Response<AlbumData> = albumService.getAlbums();
            withContext(Dispatchers.Main) {
                recylerview.layoutManager = LinearLayoutManager(this@MainActivity)
                var arr= ArrayList<AlbumDataItem?>();
                arr?.addAll(call.body()!!)
                recylerview.adapter = AlbumAdapter(arr!!, this@MainActivity)
            }
        }
    }
}




