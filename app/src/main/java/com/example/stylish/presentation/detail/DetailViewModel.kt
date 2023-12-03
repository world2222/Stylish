package com.example.stylish.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.detail.Data
import com.example.stylish.data.remote.dto.you_might_also_like.DataYouMightAlsoLike
import com.example.stylish.domain.repository.AsosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {
    
    private val _itemDetail = mutableStateOf(Data())
    val itemDetail: State<Data> = _itemDetail

    private val _youMightAlsoLike = mutableStateOf<List<DataYouMightAlsoLike>>(listOf())
    val youMightAlsoLike: State<List<DataYouMightAlsoLike>> = _youMightAlsoLike
    fun getDetails(id: Int) {
        viewModelScope.launch { 
            _itemDetail.value = service.getItemDetailById(id).data?: Data()
            _youMightAlsoLike.value = service.getYouMightAlsoLike(id).data?: listOf()
        }
    }
}