package uz.project.musicplayer.presenter.music

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.carwash24.domain.repository.MainRepository
import uz.project.musicplayer.presenter.UniversalViewModel

class MusicPageViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()


}