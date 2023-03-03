package com.example.androidweek_4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidweek_4.model.Image
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RestaurantVM : ViewModel() {
    private var _listOfImage: MutableLiveData<List<Image>> = MutableLiveData()
    val listOfIdol: LiveData<List<Image>>
        get() = _listOfImage

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun loadData() {
        _isLoading.postValue(true)

        viewModelScope.launch {
            delay(3000)
            val dataSet = DataRestaurant.getDataSet()

            _isLoading.postValue(false)
            _listOfImage.postValue(dataSet)
        }
    }
}