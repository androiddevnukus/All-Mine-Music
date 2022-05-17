package uz.project.musicplayer.presenter.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.musicplayer.R
import uz.project.musicplayer.databinding.PageMusicBinding
import uz.project.musicplayer.presenter.adapters.MainMusicsAdapter
import uz.project.musicplayer.presenter.music.MusicPageViewModel

class SplashFragment : Fragment(R.layout.splash_fragment) {
    private val binding by viewBinding(PageMusicBinding::bind)
    private lateinit var myAdapter: MainMusicsAdapter
    private val viewModel by viewModel<MusicPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Handler().postDelayed({
            findNavController().navigate(R.id.action_global_mainPage)
        }, 3000)

    }
}