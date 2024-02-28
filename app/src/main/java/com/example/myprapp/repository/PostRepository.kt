package com.example.myprapp.repository

import androidx.lifecycle.LiveData
import com.example.myprapp.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
}