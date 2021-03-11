package com.peter.musicsearch.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.peter.musicsearch.R
import com.peter.musicsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ArtistAdapter.ArtistItemClickListener {
    private lateinit var binding: ActivityMainBinding
    //by키워드는 위임하는것 상속을 허용하지 않는 클래스에 새로운 기능을 추가할때사용
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initRecyclerView()
        setListener()
        setObserver()

    }

    //반응을 뷰모델로
    private fun setListener() {
        binding.apply {
            searchButton.setOnClickListener {
                //editText 글내용 가져오기
                val artist : String = searchInput.text.toString()

                //만약 비어있지않다면
                if (artist.isNotBlank()){
                    viewModel.searchArtist(artist)
                }
            }


        }

    }

    //뷰모델에서 뷰로 오도록
    private fun setObserver() {
        viewModel.apply {
            artistDataLiveData.observe(
                this@MainActivity,
                Observer {
                    val adapter = binding.musicList.adapter as ArtistAdapter
                    adapter.submitList(it.response.hitsList)
                }
            )
        }

    }

    private fun initRecyclerView() {
        binding.apply {
            musicList.apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(
                    DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
                )
                adapter = ArtistAdapter(this@MainActivity)
            }
        }
    }

    override fun onItemClick(position: Int) {
        viewModel.toggleItemOpen(position)

        binding.musicList.adapter?.notifyItemChanged(position)
    }



}