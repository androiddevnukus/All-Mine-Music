package uz.project.musicplayer.presenter

import androidx.lifecycle.LiveData

interface UniversalViewModel<T> {
    val loadingLD: LiveData<Boolean>
    val errorLD: LiveData<String>
    val errorInternetLD: LiveData<String>
    val successLD: LiveData<T>

}