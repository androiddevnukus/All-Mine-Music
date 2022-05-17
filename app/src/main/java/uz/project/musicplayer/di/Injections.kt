package uz.project.musicplayer.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.project.carwash24.domain.repository.MainRepository
import uz.project.musicplayer.domain.repository.MainRepositoryImpl
import uz.project.musicplayer.model.local.SharePref
import uz.project.musicplayer.presenter.main.MainPageViewModel
import uz.project.musicplayer.presenter.music.MusicPageViewModel
import uz.project.musicplayer.presenter.splash.SplashViewModel

val networkModule = module {
}

val helperModule = module {
    single { SharePref(androidApplication().applicationContext) }

}

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}


val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { MainPageViewModel(get()) }
    viewModel { MusicPageViewModel(get()) }
}
