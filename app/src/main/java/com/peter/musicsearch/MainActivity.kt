package com.peter.musicsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.peter.musicsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //by키워드는 위임하는것 상속을 허용하지 않는 클래스에 새로운 기능을 추가할때사용
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

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

    }
}