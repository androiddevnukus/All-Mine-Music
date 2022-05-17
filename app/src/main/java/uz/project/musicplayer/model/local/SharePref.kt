package uz.project.musicplayer.model.local

import android.content.Context
import android.content.SharedPreferences

class SharePref(context: Context) {
    private val pref: SharedPreferences =
        context.getSharedPreferences("sharePref", Context.MODE_PRIVATE)

}