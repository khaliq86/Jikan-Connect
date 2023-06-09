package com.example.jikanconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jikanconnect.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiClient.apiService

        val call = apiService.getAnime("13")

        call.enqueue(object : Callback<AnimeResponse> {
            override fun onResponse(
                call: Call<AnimeResponse>,
                response: Response<AnimeResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("MainActivity", "Response: ${response.body()}")
                        val result = response.body()
                        val animeList = result?.animeList ?: emptyList()
                        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                        recyclerView.adapter = MainAdapter(animeList)

                } else {
                    Log.d("MainActivity", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                Log.d("MainActivity", "Error: ${t.message}")
            }
        })

    }
}
