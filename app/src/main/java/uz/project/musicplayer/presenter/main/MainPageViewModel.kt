package uz.project.musicplayer.presenter.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.carwash24.domain.repository.MainRepository
import uz.project.musicplayer.R
import uz.project.musicplayer.model.remote.Model
import uz.project.musicplayer.presenter.UniversalViewModel

class MainPageViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()


    fun getMusicsList(): List<Model> {
        return listOf(
            Model(id = 0, "Somebody is watching me", "Mxyq", R.drawable.photo1,R.raw.somebodyiswatchingme),
            Model(id = 1, "Maktabimda", "Xamdam Sobirov", R.drawable.photo1,R.raw.maktabimda),
            Model(id = 2, "Mama I'm a criminal ", "2Pac & Nas feat. Eminem", R.drawable.photo1,R.raw.criminal),
            Model(id = 3, "After Dark", "Mr.Kitty", R.drawable.photo1,R.raw.afterdark),
            Model(id = 4, "Stories", "MACAN", R.drawable.photo1,R.raw.stories),
        )
    }

}