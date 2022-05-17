package uz.project.musicplayer.domain.repository

import uz.project.carwash24.domain.repository.MainRepository
import uz.project.musicplayer.model.local.SharePref

class MainRepositoryImpl(
    private val pref: SharePref
) : MainRepository {

}