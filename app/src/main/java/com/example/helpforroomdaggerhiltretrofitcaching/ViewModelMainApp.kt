package com.example.helpforroomdaggerhiltretrofitcaching

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelMainApp @Inject constructor(private val localRepository: LocalRepository) : ViewModel() {

    val Mainlist = mutableStateOf<List<Post>>(listOf())

    init {
        getpostfromviewmodel()
    }

    fun getpostfromviewmodel(){
        CoroutineScope(IO).launch {
            var result = localRepository.getpost()

            for(item in result)
            {
                Mainlist.value += Post(item.id,item.userId,item.title,item.body)
            }
        }

    }


}