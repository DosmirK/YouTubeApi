package com.example.youtubeapi.data.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

abstract class BaseRepository {
    fun <T> doRequest(apiCall: suspend () -> Response<T>): LiveData<Resource<T>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = apiCall()
                emit(Resource.Success(response.body()!!))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error!"))
                e.localizedMessage?.let { Log.e("ololo", it) }
            }
        }
}