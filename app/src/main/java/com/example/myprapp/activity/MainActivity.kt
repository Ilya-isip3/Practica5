package com.example.myprapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myprapp.R
import com.example.myprapp.databinding.ActivityMainBinding
import com.example.myprapp.dto.Post

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Курско-магнитный студент ГБПОУ ВО БТПИТ и выпускник Курской магнитной аномалии 2 степени.",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → https://yandex.ru/",
            published = "21 мая в 18:36",
            likedByMe = false
        )
        with(binding)
        {
            textView.text = post.author
            textView2?.text = post.published
            textView3?.text = post.content
            if (post.likedByMe) {
                imageButton?.setImageResource(R.drawable.like)
            }

            imageButton?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                imageButton.setImageResource(
                    if (post.likedByMe) R.drawable.like else R.drawable.like_no_activity
                )
                if (post.likedByMe) post.likes++ else post.likes--
                textView4?.text = post.likes.toString()
            }

            imageButton2?.setOnClickListener {
                var k : Int = (textView5?.text.toString()).toInt()
                textView5?.text  = (k + 1).toString()
            }
        }
    }
}